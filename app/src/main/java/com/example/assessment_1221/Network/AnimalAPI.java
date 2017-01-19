package com.example.assessment_1221.Network;

import com.example.assessment_1221.Model.AnimalsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Millochka on 1/19/17.
 */

public interface AnimalAPI {
    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalsResponse> getAnimals();

}
