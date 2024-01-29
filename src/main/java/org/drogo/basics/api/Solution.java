package org.drogo.basics.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solution {

    public String getCountruCodeAndPhoneNumber(String phoneNumber, String country) throws IOException {

        String apiUrl = "https://jsonmock.hackerrank.com/api/counties?name=" + country;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(inputLine);

        }
        bufferedReader.close();
        conn.disconnect();

        String response = stringBuilder.toString();

        return "-1";

    }

}
