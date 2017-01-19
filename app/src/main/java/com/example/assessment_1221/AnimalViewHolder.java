package com.example.assessment_1221;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assessment_1221.Model.Animals;

/**
 * Created by Millochka on 1/19/17.
 */
public class AnimalViewHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView mName;
    LinearLayout mBackground;

    public AnimalViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView=itemView;
    }

    public static View inflateView(ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.listed_animal,parent,false);
    }

   public void onBind(Animals animal){

       mName=(TextView) mView.findViewById(R.id.animal_name);
       mName.setText(animal.getName());
       mName.setTextColor(Color.parseColor(animal.getTextColor()));
       mBackground=(LinearLayout) mView.findViewById(R.id.animal_background);


   }

    public TextView getmName() {
        return mName;
    }

    public LinearLayout getmBackground() {
        return mBackground;
    }


}
