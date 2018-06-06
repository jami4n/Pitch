package com.example.jamian.pitch;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by jamian on 2/27/2017.
 */

public class Frag_ads extends Fragment {
    ImageView ad_image;

    public Frag_ads() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.frag_ads,container,false);
        ad_image = (ImageView) view.findViewById(R.id.ad_image);

        setAd(getArguments().getString("ad_code"));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.roll_out,R.anim.roll_out).remove(Frag_ads.this).commit();
            }
        });

        return view;
    }


    private void setAd(String ad_code){

        switch(ad_code){
            case "cola":
                ad_image.setImageResource(R.drawable.cola);
                break;
            case "lego":
                ad_image.setImageResource(R.drawable.lego);
                break;
            case "nike":
                ad_image.setImageResource(R.drawable.nike);
                break;
            case "adidas":
                ad_image.setImageResource(R.drawable.adidas);
                break;
            case "norton":
                ad_image.setImageResource(R.drawable.norton);
                break;
            case "merc":
                ad_image.setImageResource(R.drawable.merc);
                break;
            default :
                //Toast.makeText(this, "Blank", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
