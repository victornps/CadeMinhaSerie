package com.victorn.cademinhaserie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    private String jsonResult;
    private String url = "https://terradopelicano.000webhostapp.com/selectseriados.php";
    ArrayList<Seriado> arraylist = new ArrayList<Seriado>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        list = (ListView) findViewById(R.id.listview);
        accessWebService();
    }

    private class JsonReadTask extends AsyncTask<String, Void, String> {

        private ProgressDialog dialogo;

        @Override
        protected void onPreExecute() {
            dialogo = ProgressDialog.show(MainActivity.this, "Aguarde", "Carregando dados...");
        }

        @Override
        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try {
                HttpResponse response = httpclient.execute(httppost);
                jsonResult = inputStreamToString(
                        response.getEntity().getContent()).toString();
            }

            catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            }

            catch (IOException e) {
                Toast.makeText(getApplicationContext(),
                        "Erro..." + e.toString(), Toast.LENGTH_LONG).show();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(String result) {
            dialogo.dismiss();
            ListDrawer();
        }}

    public void accessWebService() {
        JsonReadTask task = new JsonReadTask();

        task.execute(new String[] { url });
    }

    public void ListDrawer() {

        try {
            JSONArray jsonMainNode = new JSONArray(jsonResult);

            for (int i = 0; i < jsonMainNode.length(); i++) {
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                String nome = jsonChildNode.optString("nome");
                String ano = jsonChildNode.optString("ano");
                String criador = jsonChildNode.optString("criador");
                String elencoPrincipal = jsonChildNode.optString("elencoPrincipal");
                String temporadas = jsonChildNode.optString("temporadas");
                String atividade = jsonChildNode.optString("atividade");
                String trama = jsonChildNode.optString("trama");
                String generos = jsonChildNode.optString("generos");
                String paisOrigem = jsonChildNode.optString("paisOrigem");
                String tempoEpisodio = jsonChildNode.optString("tempoEpisodio");
                String thumbnail = jsonChildNode.optString("thumbnail");

                Seriado cms = new Seriado(nome,ano,criador,elencoPrincipal,temporadas,atividade,trama,generos,paisOrigem,tempoEpisodio,thumbnail);
                arraylist.add(cms);
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error" + e.toString(),
                    Toast.LENGTH_SHORT).show();
        }

        adapter = new ListViewAdapter(this, arraylist);
        list.setAdapter(adapter);

        editsearch = (EditText) findViewById(R.id.search);
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }


}
