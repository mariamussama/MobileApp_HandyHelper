const fs = require('fs/promises');
const express = require('express');
const cors = require('cors');
const _ = require('lodash');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const { v4: uuid } = require('uuid');


const app = express();
app.use(bodyParser.json());

const connection = mysql.createConnection({
    // connectionLimit: 10,
    host: 'db4free.net',
    user: 'handyhelper',
    password: 'handyhelper',
    database: 'auc_handyhelper'
  });
  
  connection.connect(function(err) {
    if (err) throw err;
    console.log("Connected to MySQL database!");
    });
    
// insert a new user
app.post('/adduser', (req, res) => {
    // extract user data from the request body
    const { nat_ID, username, email, pass, gender, phone, date_of_birth, interest, description, notify} = req.body;
    console.log("nationa: "+nat_ID);
    let query1 =`INSERT INTO users (national_id, username, email, pass, gender, phone_number, date_of_birth`;
    let query2 =`) VALUES ('${nat_ID}', '${username}', '${email}', '${pass}', '${gender}', '${phone}', '${date_of_birth}'`;

  if (interest){
    query1 += `, interests`;
    query2 += `, '${interest}'`;
  }
  // if (image){
  //   query1 += `, image`;
  //   query2 += `, '${image}'`;
  // }
  if (description){
    query1 += `, description`;
    query2 += `, '${description}'`;
  }
  if (notify){
    query1 += `, notify`;
    query2 += `, ${notify}`;
  }
  query1 += query2 + `)`;
  
    // execute the query using the MySQL connection pool
    connection.query(query1, (err, result) => {
      if (err) {
        console.error(err);
        res.status(500).send('Error inserting user into database');
      } else {
        console.log(`User with national ID ${nat_ID} inserted into database`);
        res.status(201).send('User inserted into database');
      }
    });
    
  });

  //
  app.get('/login', (req, res)=>{
    const email = req.query.email;
    const pass = req.query.pass;
    // const {email, pass} = req.body;
    const query = "SELECT * FROM users WHERE email = ?";
    connection.query(query, [email],(err, results)=>{
      if(err) res.status(401).send("Failed to get User")
      if(results.length>0){
        if(results[0].pass === pass){
          res.status(200).send(results[0]);
        }else{
          res.status(401).send("Wrong email or password")
        }

      }
    })
  });

  //get application of a certain user to a certain service
  app.get('/apply', (req, res)=>{
    const {national_id, post_id}  = req.query;
    const query = "SELECT * FROM apply WHERE post_id = ? and national_id = ?";
    connection.query(query, [post_id, national_id], (err, results)=>{
      if(err) res.status(401).send("failed to get row");
      if(results.length > 0){
        res.status(201).json(results[0]);
      }else{
        res.status(404).json({message:"No entry"});
      }
    })
  })

  app.post('/apply', (req, res)=>{
    const {post_id, national_id, apply_price} = req.body;
    const query = "INSERT INTO apply (post_id, national_id, apply_price) VALUES (?, ?, ?)";
    connection.query(query, [post_id, national_id, apply_price], (err, results)=>{
      if(err) {
        console.log(err);
        res.send("0")
      }
      if(results) res.send("1");
    })

  })


    

  

  //retrieve a user by national ID
  app.get('/users/:national_id', (req, res) => {
    // extract the national ID parameter from the request URL
    const national_id = req.params.national_id.replace(':','');
  
    // define a SQL query to select a user by national ID from the 'user' table
    const query = `SELECT * FROM users WHERE national_id = ${national_id}`;
  
    // execute the query using the MySQL connection pool
    connection.query(query, (err, result) => {
      if (err) {
        console.error(err);
        res.status(500).send('Error retrieving user from database');
      } else if (result.length === 0) {
        res.status(404).send('User not found');
      } else {
        const user = result[0];
        res.status(200).json(user);
      }
    });
  });
  

  // get all posts with of a certain user
app.get('/posts/:nationalID', (req, res) => {

  const national_id = req.params.nationalID.replace(':','');
  console.log(national_id);

  const query = `SELECT * FROM post WHERE national_id = '${national_id}'`;
  console.log(query);

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving posts from database');
    } else {
      res.status(200).json(result);
    }
  });
});

app.get('/post', (req, res)=>{
  const post_id = req.query.post_id;
  
    const query = "SELECT * FROM post WHERE id = ?";
    connection.query(query, [post_id], (err, results)=>{
      if(err) {
        console.log(err);
        res.status(401).send("failed to get row");
      }
      else{
      if(results.length > 0){
        res.status(201).json(results[0]);
      }else{
        res.status(404).json({message:"No entry"});
      }
    }
    })
})

//get all posts
app.get('/posts', (req, res) => {

  const query = `SELECT * FROM post p join users u on u.national_id = p.national_id where state = "n"`;

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving posts from database');
    } else {
      res.status(200).json(result);
    }
  });
});

//post a new post
app.post('/newpost', (req, res) => {
  const { national_id, title, content, category, service_date, service_time, location,initial_price } = req.body;

  const query = `INSERT INTO post (national_id, title, content, category, service_date, service_time, location, initial_price) 
                 VALUES ('${national_id}', '${title}', '${content}', '${category}', '${service_date}', '${service_time}', '${location}', ${initial_price})`;

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error inserting post into database');
    } else {
      console.log(`Post with title "${title}" inserted into database`);
      res.status(201).send('Post inserted into database');
    }
  });
});

//update status of post

app.get('/updatepoststatus', (req, res)=>{
  const{post_id, status } = req.query;
  const query = "UPDATE post SET state = ? where id = ?";
  connection.query(query, [status, post_id], (err, results)=>{
    if(err){
      console.log(err);
      res.json({done:0});
    }else{
      if(results.length > 0){
        console.log("hi")
        res.json({done:1});
      }
      res.json({done:1});
    }
  })
})

//add a new job application
app.post('/applies', (req, res) => {

  const { national_id, post_id, apply_price } = req.body;

  const query = `INSERT INTO apply (national_id, post_id, apply_price) 
                 VALUES ('${national_id}', ${post_id}, ${apply_price})`;

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error inserting job application into database');
    } else {
      console.log(`Job application for post ID ${post_id} inserted into database`);
      res.status(201).send('Job application inserted into database');
    }
  });
});

// get all job applications of a certain user
app.get('/applies/user/:national_id', (req, res) => {
  const national_id = req.params.national_id.replace(':','');

  const query = `SELECT * FROM apply 
                 INNER JOIN post ON apply.post_id = post.id 
                 WHERE apply.national_id = '${national_id}'`;

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving job applications from database');
    } else {
      res.status(200).json(result);
    }
  });
});

// get all job applications of a certain post
app.get('/applies/post/:post_id', (req, res) => {
  const post_id = req.params.post_id.replace(':','');

  const query = `SELECT * FROM apply 
                 INNER JOIN users ON apply.national_id = users.national_id 
                 WHERE apply.post_id = '${post_id}'`;
  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving job applications from database');
    } else {
      res.status(200).json(result);
    }
  });
});

 
app.use(bodyParser.json())
// Update user description by username
app.put('/users/:username/description', (req, res) => {
  const { username } = req.params;
  const { description } = req.body;

  const sql = 'UPDATE users SET description = ? WHERE username = ?';
  connection.query(sql, [description, username], (err, result) => {
    if (err) {
      console.error('Error updating user description: ', err);
      res.status(500).json({ error: 'Failed to update user description' });
      return;
    }
    console.log(`User "${username}" description updated successfully`);
    res.json({ message: 'User description updated successfully' });
  });
});

// API to get specific columns from the users table
// image, rating, interests, and description
app.get('/users/:national_id/details', (req, res) => {
  const national_id = req.params.national_id.replace(':','');

  const query = `SELECT image, rating, interests, description FROM users WHERE national_id = '${national_id}'`;

  connection.query(query, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving user details from database');
    } else {
      if (result.length > 0) {
        const userDetails = result[0];
        res.status(200).json(userDetails);
      } else {
        res.status(404).send('User not found');
      }
    }
  });
});

// Update user password by username
app.put('/users/:username/password', (req, res) => {
  const { username } = req.params;
  const { password } = req.body;

  const sql = 'UPDATE users SET pass = ? WHERE username = ?';
  connection.query(sql, [password, username], (err, result) => {
    if (err) {
      console.error('Error updating user password: ', err);
      res.status(500).json({ error: 'Failed to update user password' });
      return;
    }
    console.log(`User "${username}" password updated successfully`);
    res.json({ message: 'User password updated successfully' });
  });
});

// Update user email or phone number by username
app.put('/users/:username/contact', (req, res) => {
  const { username } = req.params;
  const { email, phoneNumber } = req.body;

  // Check if either email or phone number is provided
  if (!email && !phoneNumber) {
    res.status(400).json({ error: 'Either email or phone number must be provided' });
    return;
  }

  // Build the SQL query dynamically based on the provided fields
  let sql = 'UPDATE users SET';
  const values = [];

  if (email) {
    sql += ' email = ?,';
    values.push(email);
  }
  if (phoneNumber) {
    sql += ' phone_number = ?,';
    values.push(phoneNumber);
  }

  // Remove the trailing comma from the query
  sql = sql.slice(0, -1);

  // Add the WHERE clause to update the user with the specified username
  sql += ' WHERE username = ?';
  values.push(username);

  connection.query(sql, values, (err, result) => {
    if (err) {
      console.error('Error updating user contact information: ', err);
      res.status(500).json({ error: 'Failed to update user contact information' });
      return;
    }
    console.log(`User "${username}" contact information updated successfully`);
    res.json({ message: 'User contact information updated successfully' });
  });
});



app.listen(3000, () => console.log('Server started'));

