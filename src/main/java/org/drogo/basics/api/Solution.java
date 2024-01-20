package org.drogo.basics.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solution {

    public String getCountruCodeAndPhoneNumber(String phoneNumber, String country) throws IOException {

       String apiUrl ="https://jsonmock.hackerrank.com/api/counties?name="+country;
        URL url= new URL(apiUrl);
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuffer stringBuffer= new StringBuffer();
        while((inputLine=bufferedReader.readLine()) !=null){
            stringBuffer.append(inputLine);

        }
       bufferedReader.close();
        conn.disconnect();

        String response= stringBuffer.toString();

        return "-1";

    }

}
