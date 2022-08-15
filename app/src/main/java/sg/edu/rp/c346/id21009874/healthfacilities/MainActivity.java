package sg.edu.rp.c346.id21009874.healthfacilities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.*;

public class MainActivity extends AppCompatActivity {

    ListView lvBedHealth;
    AsyncHttpClient client;
    ArrayList<healthInfo> alHealthInfo;
    ArrayAdapter<healthInfo> aaHealthInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBedHealth = findViewById(R.id.lvHealthBeds);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        alHealthInfo = new ArrayList<healthInfo>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=dee5ccce-4dfb-467f-bcb4-dc025b56b977&limit=20", new JsonHttpResponseHandler() {

            String beds;
            String facilities;
            String institution;
            String year;
            String facility;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.i("response",response.toString());
                    JSONObject result = response.getJSONObject("result");
                    JSONArray jsonArrItems = result.getJSONArray("records");
                    Log.i("records",jsonArrItems.toString());


                    for(int i = 0; i < jsonArrItems.length(); i++) {
                        JSONObject jsonObjForecast = jsonArrItems.getJSONObject(i);
                        beds = jsonObjForecast.getString("no_beds");
                        facilities = jsonObjForecast.getString("no_of_facilities");
                        institution = jsonObjForecast.getString("institution_type");
                        year = jsonObjForecast.getString("year");
                        facility = jsonObjForecast.getString("facility_type_a");
                        healthInfo info = new healthInfo(beds, facilities, institution,year, facility);
                        alHealthInfo.add(info);
                    }
                }
                catch(JSONException e){

                }
                aaHealthInfo = new ArrayAdapter<healthInfo>(MainActivity.this, android.R.layout.simple_list_item_1, alHealthInfo);

                lvBedHealth.setAdapter(aaHealthInfo);





            }//end onSuccess



        });
    }
}