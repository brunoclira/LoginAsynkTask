package com.example.bruno.loginasynktask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifpb.notificationwear.asynctask.LoginAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button asyncTaskButton = (Button) findViewById(R.id.enviarButton);

        asyncTaskButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
                    String nome = nomeEditText.getText().toString();
                EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
                    String senha = senhaEditText.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(view.getContext());
                String[] valores = {nome,senha};
                loginAsyncTask.execute(valores);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
