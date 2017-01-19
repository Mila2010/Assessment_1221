package com.example.assessment_1221;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.assessment_1221.Model.Animals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 1/19/17.
 */
public class AnimalAdapter extends RecyclerView.Adapter {

    List<Animals> mAnimalses = new ArrayList<>();

    Listener mListener;



    public AnimalAdapter(List<Animals> mAnimalses,Listener listener){

        this.mAnimalses = mAnimalses;
        this.mListener =listener;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        AnimalViewHolder animalViewHolder = (AnimalViewHolder) holder;

        animalViewHolder.onBind(mAnimalses.get(position));
        ((AnimalViewHolder) holder).getmName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 mListener.ChangeBackground(mAnimalses.get(position).getBackground());
                //mBackground.setBackgroundColor(Color.parseColor(mAnimalses.get(position).getBackground()));


            }
        });



    }

    @Override
    public int getItemCount() {
        return mAnimalses.size();
    }

    public interface Listener{

        void ChangeBackground(String colorName);

    }
}
