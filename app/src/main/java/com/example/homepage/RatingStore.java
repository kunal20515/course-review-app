package com.example.homepage;

import android.os.AsyncTask;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class RatingStore {

    public void saveCourses(List<String> courseIds, List<String> courseReviews, List<Float> courseRatings) {
        JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0; i < courseIds.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("courseId", courseIds.get(i));
                jsonObject.put("courseReview", courseReviews.get(i));
                jsonObject.put("courseRating", courseRatings.get(i));
                jsonArray.put(jsonObject);
            }

            PostCoursesTask task = new PostCoursesTask();
            task.execute(new Pair<Function<Void, Void>, JSONArray>((Void a) -> {
                return null;
            }, jsonArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @FunctionalInterface
    interface TriFunction<One, Two, Three> {
        public TriFunction apply(One one, Two two, Three three);
    }
    public void getCourses(TriFunction<List<String>, List<String>, List<Float>> callback) {
        List<String> courseIds = new ArrayList<>();
        List<String> courseReviews = new ArrayList<>();
        List<Float> courseRatings = new ArrayList<>();

        new GetCoursesTask().execute(
                (JSONArray jsonArray) -> {
                    try {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            courseIds.add(jsonObject.getString("courseId"));
                            courseReviews.add(jsonObject.getString("courseReview"));
                            courseRatings.add((float) jsonObject.getDouble("courseRating"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    callback.apply(courseIds, courseReviews, courseRatings);
                    return null;
                }
        );
    }

    private class PostCoursesTask extends AsyncTask<Pair<Function<Void, Void>, JSONArray>, Void, Pair<Function<Void, Void>, String>> {
        @SafeVarargs
        @Override
        protected final Pair<Function<Void, Void>, String> doInBackground(Pair<Function<Void, Void>, JSONArray>... data) {
            String response = "";
            try {
                URL url = new URL("http://139.59.44.123:1337/course-rating");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestMethod("POST");
                con.setDoOutput(true);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = data[0].second.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InputStream in = con.getInputStream();
                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");

                boolean hasInput = scanner.hasNext();
                if (hasInput) {
                    response = scanner.next();
                }

                return new Pair<>(data[0].first, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Pair<Function<Void, Void>, String> data) {
            data.first.apply(null);
        }
    }

    private class GetCoursesTask extends AsyncTask<Function<JSONArray, Void>, Void, Pair<Function<JSONArray, Void>, JSONArray>> {
        @SafeVarargs
        @Override
        protected final Pair<Function<JSONArray, Void>, JSONArray> doInBackground(Function<JSONArray, Void>... data) {
            String response = "";
            try {
                URL url = new URL("http://139.59.44.123:1337/get-courses-rating");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestMethod("GET");


                InputStream in = con.getInputStream();
                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");

                boolean hasInput = scanner.hasNext();
                if (hasInput) {
                    response = scanner.next();
                }

                return new Pair(data[0], new JSONArray(response));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Pair<Function<JSONArray, Void>, JSONArray> data) {
            data.first.apply(data.second);
        }
    }
}