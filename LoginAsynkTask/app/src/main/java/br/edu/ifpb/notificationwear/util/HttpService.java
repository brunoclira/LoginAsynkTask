package br.edu.ifpb.notificationwear.util;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpService {

    // IP da máquina onde se encontra o servidor.
    private static final String URL_CONTEXT = "http://192.168.25.203:8080/rest-servlet-service/";

    public static HttpURLConnection sendGetRequest(String service)
            throws MalformedURLException, IOException{

        HttpURLConnection connection = null;

        try {
            URL url = new URL(URL_CONTEXT + service);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
        }catch(Exception e){
            System.out.println("HttpService: " + e.getMessage());
        }
        return connection;
    }

    public void sendJsonPostRequest(String service, JSONObject json) {

    }

    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {

            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    content, "iso-8859-1"), 8);

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            content.close();

        } catch (IOException e) {

            Log.e("NotificationWearApp", "IOException: " + e);
        }

        return builder.toString();
    }
}