package br.edu.ifpb.notificationwear.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import br.edu.ifpb.notificationwear.util.HttpService;
import br.edu.ifpb.notificationwear.util.Response;

public class LoginAsyncTask extends AsyncTask<String, Void, Response>{

    Context context;

    public LoginAsyncTask(Context activity) {

        this.context = activity;
    }

    @Override
    protected void onPreExecute() {

        Log.i("NotificationWearApp", "OnPreExecute");
    }

    @Override
    protected Response doInBackground(String... valores) {

        Log.i("NotificationWearApp", "doInBackground: " + valores[0]);

        Response response = null;
        HttpURLConnection connection = null;

        try {

            connection = HttpService.sendGetRequest("servicoservlet");

            int statusCodeHttp = connection.getResponseCode();
            String contentValue = HttpService.getHttpContent(connection);

            response = new Response(statusCodeHttp, contentValue);

        } catch (MalformedURLException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } catch (IOException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } finally {

            connection.disconnect();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();
            JSONObject json = new JSONObject(response.getContentValue());

            if (status == HttpURLConnection.HTTP_OK) {
                String nome = json.getString("key");
                Log.i("NotificationWearApp", "Nome: " + nome);
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }else{
                String nome = json.getString("mensagem");
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}
