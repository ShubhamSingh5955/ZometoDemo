package com.example.zometodemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zometodemo.model.Restaurant;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private RecyclerView recyclerView;
    private MyAdapter recyclerView_adapter;
    private List<Restaurant> restaurantsList;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();

        button = findViewById(R.id.search_button);
        recyclerView=findViewById(R.id.recyclerView_main);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                       ) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
                    ){
                        geoLocation();
                    }else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.INTERNET,Manifest.permission.INTERNET}, 44);
                    }

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}, 44);
                }

            }

        });

    }

    private void geoLocation() {

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();

                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());

                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);

                        Log.d("geo_Location", String.valueOf(location.getLatitude()) + " " + String.valueOf(location.getLongitude()));

                        //calling zometo
                        restaurantsList= new ArrayList<>(50);

                        getApi().getNearbyRestaurants(location.getLatitude(),location.getLongitude(),20,5000,"95cf87e7f544695fa28e72b900924d91")
                                .enqueue(new Callback<ApiResponse>() {
                                    @Override
                                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                                        if(response!=null){

                                            List<Restaurant> restaurants=response.body().getRestaurants();
                                            if(response!=null){
                                                Log.d("restorant", String.valueOf(response.body().getRestaurants() ));
                                            }

                                            for (int i = 0; i < restaurants.size(); i++) {
                                                restaurantsList.add(new Restaurant());
                                            }
                                            recyclerView_adapter = new MyAdapter(restaurantsList,context);
                                            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
                                            recyclerView.addItemDecoration(itemDecoration);
                                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                            recyclerView.setAdapter(recyclerView_adapter);


                                        }else{
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                                            builder.setMessage("error to find restaurants");
                                            AlertDialog mDialog = builder.create();
                                            mDialog.show();
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                                        builder.setMessage("Couldn´t find any nearby restaurants");
                                        AlertDialog mDialog = builder.create();
                                        mDialog.show();
                                    }
                                });



                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }

    private Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private ZomatoApi getApi(){
        return  getRetrofit().create(ZomatoApi.class);
    }

}