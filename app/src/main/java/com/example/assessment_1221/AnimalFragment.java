package com.example.assessment_1221;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.assessment_1221.Model.Animals;
import com.example.assessment_1221.Model.AnimalsResponse;
import com.example.assessment_1221.Network.AnimalAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Millochka on 1/19/17.
 */
public class AnimalFragment extends Fragment implements AnimalAdapter.Listener {

    RecyclerView mRecyclerView;
    Retrofit mRetrofit;
    LinearLayout mBackground;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);

        return inflater.inflate(R.layout.scrollable_animals,container,false);

    }

    @Override

    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mBackground= (LinearLayout) view.findViewById(R.id.animal_fragment);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        mRetrofit = new Retrofit.Builder().baseUrl("http://jsjrobotics.nyc/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        AnimalAPI animalAPI = mRetrofit.create(AnimalAPI.class);

        Call<AnimalsResponse>  call = animalAPI.getAnimals();
        call.enqueue(new Callback<AnimalsResponse>() {
            @Override
            public void onResponse(Call<AnimalsResponse> call, Response<AnimalsResponse> response) {
                if (response.isSuccessful()) {
                    AnimalsResponse animalsResponse = response.body();

                   initRecView(animalsResponse.getAnimals(), view);

                }

                }

            @Override
            public void onFailure(Call<AnimalsResponse> call, Throwable t) {

            }
        });




    }

    public void initRecView(List<Animals> response, View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.animal_item);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new AnimalAdapter(response,this));


    }


    @Override
    public void ChangeBackground(String colorName) {

        mBackground.setBackgroundColor(Color.parseColor(colorName));

    }
}

