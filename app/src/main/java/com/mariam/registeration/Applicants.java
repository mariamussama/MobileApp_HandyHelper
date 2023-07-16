package com.mariam.registeration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Applicant {
    private String natID;
    private Double rating;
    private String username;

    public Applicant(String natID, Double rating, String username) {
        this.natID = natID;
        this.rating = rating;
        this.username = username;
    }

    public String getNatID() {
        return natID;
    }

    public Double getRating() {
        return rating;
    }

    public String getUsername() {
        return username;
    }
}

public class Applicants extends AppCompatActivity {

    private ListView listView;
    private List<Applicant> itemList;
    private CustomArrayAdapter adapter;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicants);

        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();

        adapter = new CustomArrayAdapter(this, itemList);
        listView.setAdapter(adapter);

        int postId = getIntent().getIntExtra("post_id", -1);
        Log.e("TAG", "The post id is: " + postId);

        new RetrieveApplicantsTask().execute(postId);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });
    }

    private void goback() {
        Intent intent = new Intent(Applicants.this, MainActivity.class);
        startActivity(intent);
    }

    private class CustomArrayAdapter extends ArrayAdapter<Applicant> {

        public CustomArrayAdapter(Context context, List<Applicant> items) {
            super(context, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.applicants_list_item, parent, false);
            }

            Applicant applicant = getItem(position);

            TextView titleText = convertView.findViewById(R.id.titleText);
            ImageView icon = convertView.findViewById(R.id.icon);
            TextView ratingText = convertView.findViewById(R.id.ratingText);
            Button acceptButton = convertView.findViewById(R.id.button1);
            Button declineButton = convertView.findViewById(R.id.button2);

            titleText.setText(String.valueOf(applicant.getUsername()));
            ratingText.setText(String.valueOf(applicant.getRating()));

            acceptButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    new UpdateApplicationStatusTask().execute(applicant.getNatID(), String.valueOf(getIntent().getIntExtra("post_id", -1)), "A");
                }
            });

            declineButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeApplicant(position); // Remove the applicant from the list
                    new UpdateApplicationStatusTask().execute(applicant.getNatID(), String.valueOf(getIntent().getIntExtra("post_id", -1)), "R");
                }
            });

            return convertView;
        }

        private void removeApplicant(int position) {
            // Remove the applicant from the list
            if (position >= 0 && position < getCount()) {
                itemList.remove(position);
                notifyDataSetChanged();
            }
        }
    }

    private class RetrieveApplicantsTask extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... postIds) {
            int postId = postIds[0];
            String result = "";

            try {
                URL url = new URL("http://192.168.1.5:3000/applicants/" + postId);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    reader.close();
                    result = stringBuilder.toString();
                } else {
                    result = "HTTP response code: " + responseCode;
                }

                connection.disconnect();
            } catch (Exception e) {
                result = e.getMessage();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result.startsWith("HTTP response code:")) {
                // Handle error
            } else {
                try {
                    JSONArray jsonArray = new JSONArray(result);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String natID = jsonObject.getString("national_id");
                        Double rating = jsonObject.getDouble("rating");
                        String username = jsonObject.getString("username");

                        Applicant applicant = new Applicant(natID, rating, username);
                        itemList.add(applicant);
                    }

                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e("TAG", "JSONException occurred: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private class UpdateApplicationStatusTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String natID = params[0];
            String postID = params[1];
            String status = params[2];

            try {
                URL url = new URL("http://192.168.1.5:3000/updateApplicationStatus");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                JSONObject requestBody = new JSONObject();
                requestBody.put("national_id", natID);
                requestBody.put("post_id", postID);
                requestBody.put("status", status);
                Log.e("TAG", "Testing the request: " + requestBody);

                connection.getOutputStream().write(requestBody.toString().getBytes());

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    Log.e("TAG", "it should have worked" + responseCode);

                    // Application status updated successfully
                } else {
                    Log.e("TAG", "HTTP response code: " + responseCode);
                }

                connection.disconnect();
            } catch (Exception e) {
                Log.e("TAG", "Error updating application status: " + e.getMessage());
            }

            return null;
        }
    }
}
