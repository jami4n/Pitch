package com.example.jamian.pitch;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;


public class MainActivity extends AppCompatActivity {
    TextView tv_pitch;
    EditText et_pitch;
    Button btn_play;

    public final String TAG = "12345";

    int lastInt = 0;

    Button btn_a,btn_b,btn_c,btn_d,btn_e,btn_f,btn_g,btn_h,btn_i,btn_j,btn_k,btn_l,btn_m,btn_n,btn_o,btn_p,btn_q,btn_r,btn_s,btn_t,btn_u,btn_v,btn_w,btn_x,btn_y,btn_z,btn_dot,btn_space,btn_clear;


    TextView tv_tone_text;

    Frag_ads fragads;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_pitch = (TextView) findViewById(R.id.tv_pitch);
        et_pitch = (EditText) findViewById(R.id.et_pitch);
        btn_play = (Button) findViewById(R.id.btn_play);

        btn_a = (Button) findViewById(R.id.btn_alpha_a);
        btn_b = (Button) findViewById(R.id.btn_alpha_b);
        btn_c = (Button) findViewById(R.id.btn_alpha_c);
        btn_d = (Button) findViewById(R.id.btn_alpha_d);
        btn_e = (Button) findViewById(R.id.btn_alpha_e);
        btn_f = (Button) findViewById(R.id.btn_alpha_f);
        btn_g = (Button) findViewById(R.id.btn_alpha_g);
        btn_h = (Button) findViewById(R.id.btn_alpha_h);
        btn_i = (Button) findViewById(R.id.btn_alpha_i);
        btn_j = (Button) findViewById(R.id.btn_alpha_j);
        btn_k = (Button) findViewById(R.id.btn_alpha_k);
        btn_l = (Button) findViewById(R.id.btn_alpha_l);
        btn_m = (Button) findViewById(R.id.btn_alpha_m);
        btn_n = (Button) findViewById(R.id.btn_alpha_n);
        btn_o = (Button) findViewById(R.id.btn_alpha_o);
        btn_p = (Button) findViewById(R.id.btn_alpha_p);
        btn_q = (Button) findViewById(R.id.btn_alpha_q);
        btn_r = (Button) findViewById(R.id.btn_alpha_r);
        btn_s = (Button) findViewById(R.id.btn_alpha_s);
        btn_t = (Button) findViewById(R.id.btn_alpha_t);
        btn_u = (Button) findViewById(R.id.btn_alpha_u);
        btn_v = (Button) findViewById(R.id.btn_alpha_v);
        btn_w = (Button) findViewById(R.id.btn_alpha_w);
        btn_x = (Button) findViewById(R.id.btn_alpha_x);
        btn_y = (Button) findViewById(R.id.btn_alpha_y);
        btn_z = (Button) findViewById(R.id.btn_alpha_z);
        btn_dot = (Button) findViewById(R.id.btn_alpha_dot);
        btn_clear = (Button) findViewById(R.id.btn_alpha_clear);
        btn_space = (Button) findViewById(R.id.btn_alpha_space);

        tv_tone_text = (TextView) findViewById(R.id.tone_text);

        detectPitch();




        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pitch = et_pitch.getText().toString();
                if(pitch.length() > 0){
                    //play_audio(Integer.parseInt(pitch));
                    new MainActivity.Playaudio().execute(pitch,"test","test");

                }

            }
        });

        btn_a.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1000"),"test","test");}});
        btn_b.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1100"),"test","test");}});
        btn_c.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1200"),"test","test");}});
        btn_d.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1300"),"test","test");}});
        btn_e.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1400"),"test","test");}});
        btn_f.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1500"),"test","test");}});
        btn_g.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1600"),"test","test");}});
        btn_h.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1700"),"test","test");}});
        btn_i.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1800"),"test","test");}});
        btn_j.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("1900"),"test","test");}});
        btn_k.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2000"),"test","test");}});
        btn_l.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2100"),"test","test");}});
        btn_m.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2200"),"test","test");}});
        btn_n.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2300"),"test","test");}});
        btn_o.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2400"),"test","test");}});
        btn_p.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2500"),"test","test");}});
        btn_q.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2600"),"test","test");}});
        btn_r.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2700"),"test","test");}});
        btn_s.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2800"),"test","test");}});
        btn_t.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("2900"),"test","test");}});
        btn_u.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3000"),"test","test");}});
        btn_v.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3100"),"test","test");}});
        btn_w.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3200"),"test","test");}});
        btn_x.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3300"),"test","test");}});
        btn_y.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3400"),"test","test");}});
        btn_z.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3500"),"test","test");}});
        btn_dot.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3600"),"test","test");}});
        btn_space.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3700"),"test","test");}});
        btn_clear.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {new MainActivity.Playaudio().execute(new String("3800"),"test","test");}});


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Log.d(TAG, "run: timer called");
                lastInt = 0;
            }
        },1000,800);

        et_pitch.setVisibility(View.GONE);
        btn_play.setVisibility(View.GONE);
        tv_tone_text.setVisibility(View.INVISIBLE);

    } //end of onCreate

    private void setAlphabetinToneText(int tone) {
        String tone_text = "" + tv_tone_text.getText().toString();

        switch(tone){

            case 10:
                tone_text = tone_text + "A";
                break;
            case 11:
                tone_text = tone_text + "B";
                break;
            case 12:
                tone_text = tone_text + "C";
                break;
            case 13:
                tone_text = tone_text + "D";
                break;
            case 14:
                tone_text = tone_text + "E";
                break;
            case 15:
                tone_text = tone_text + "F";
                break;
            case 16:
                tone_text = tone_text + "G";
                break;
            case 17:
                tone_text = tone_text + "H";
                break;
            case 18:
                tone_text = tone_text + "I";
                break;
            case 19:
                tone_text = tone_text + "J";
                break;
            case 20:
                tone_text = tone_text + "K";
                break;
            case 21:
                tone_text = tone_text + "L";
                break;
            case 22:
                tone_text = tone_text + "M";
                break;
            case 23:
                tone_text = tone_text + "N";
                break;
            case 24:
                tone_text = tone_text + "O";
                break;
            case 25:
                tone_text = tone_text + "P";
                break;
            case 26:
                tone_text = tone_text + "Q";
                break;
            case 27:
                tone_text = tone_text + "R";
                break;
            case 28:
                tone_text = tone_text + "S";
                break;
            case 29:
                tone_text = tone_text + "T";
                break;
            case 30:
                tone_text = tone_text + "U";
                break;
            case 31:
                tone_text = tone_text + "V";
                break;
            case 32:
                tone_text = tone_text + "W";
                break;
            case 33:
                tone_text = tone_text + "X";
                break;
            case 34:
                tone_text = tone_text + "Y";
                break;
            case 35:
                tone_text = tone_text + "Z";
                break;
            case 36:
                tone_text = tone_text + ".";
                break;
            case 37:
                tone_text = tone_text + " ";
                break;
            case 38:
                tone_text = "";
                hideFragment();
                break;

        }

        checkforads(tone_text);

        tv_tone_text.setText(tone_text);

    }

    private void checkforads(String ad_code){
        ad_code = ad_code.toLowerCase();

        switch(ad_code){
            case "cola":
                showfragment(ad_code);
                break;
            case "lego":
                showfragment(ad_code);
                break;
            case "nike":
                showfragment(ad_code);
                break;
            case "adidas":
                showfragment(ad_code);
                break;
            case "norton":
                showfragment(ad_code);
                break;
            case "merc":
                showfragment(ad_code);
                break;
            default :
                break;
        }


    }

    private void showfragment(String ad_code){

        tv_tone_text.setText("");
        hideFragment();

        Bundle bundle = new Bundle();
        bundle.putString("ad_code", ad_code);

        fragads = new Frag_ads();
        fragads.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.roll_in,R.anim.roll_in);
        ft.add(R.id.frag_container,fragads,"fragads");
        ft.commit();
    }

    private void hideFragment(){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("fragads");

        if(fragment != null)
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.roll_out,R.anim.roll_out).remove(fragment).commit();

    }

    void play_audio(int pitch_freq){

    }

    private void detectPitch(){
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult result,AudioEvent e) {
                final float pitchInHz = result.getPitch();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int currenttone = (int)(pitchInHz / 100);
                        //Log.d("123456", "run pitch: " + (int)(pitchInHz / 100));

                        if(currenttone >= 10){
                            if(lastInt != currenttone){
                                lastInt = currenttone;

                                setAlphabetinToneText(currenttone);
                            }
                        }

                        tv_pitch.setText("" + pitchInHz);
                    }
                });
            }
        };
        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher,"Audio Dispatcher").start();

    }

    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu_play_custom_pitch:

                if(et_pitch.getVisibility() == View.VISIBLE){
                    et_pitch.setVisibility(View.INVISIBLE);
                    btn_play.setVisibility(View.INVISIBLE);
                }else{
                    et_pitch.setVisibility(View.VISIBLE);
                    btn_play.setVisibility(View.VISIBLE);
                }

                return true;

            case R.id.menu_show_aplhatext:
                if(tv_tone_text.getVisibility() == View.VISIBLE){
                    tv_tone_text.setVisibility(View.INVISIBLE);
                }else{
                    tv_tone_text.setVisibility(View.VISIBLE);
                }

                return true;

            case R.id.play_nike:
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                new MainActivity.Playaudio().execute(new String("2300"),"test","test");
                new MainActivity.Playaudio().execute(new String("1800"),"test","test");
                new MainActivity.Playaudio().execute(new String("2000"),"test","test");
                new MainActivity.Playaudio().execute(new String("1400"),"test","test");

                return true;

            case R.id.play_cola:
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                new MainActivity.Playaudio().execute(new String("1200"),"test","test");
                new MainActivity.Playaudio().execute(new String("2400"),"test","test");
                new MainActivity.Playaudio().execute(new String("2100"),"test","test");
                new MainActivity.Playaudio().execute(new String("1000"),"test","test");

                return true;

            case R.id.play_lego:
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                new MainActivity.Playaudio().execute(new String("2100"),"test","test");
                new MainActivity.Playaudio().execute(new String("1400"),"test","test");
                new MainActivity.Playaudio().execute(new String("1600"),"test","test");
                new MainActivity.Playaudio().execute(new String("2400"),"test","test");

                return true;

            case R.id.play_adidas:
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                new MainActivity.Playaudio().execute(new String("1000"),"test","test");
                new MainActivity.Playaudio().execute(new String("1300"),"test","test");
                new MainActivity.Playaudio().execute(new String("1800"),"test","test");
                new MainActivity.Playaudio().execute(new String("1300"),"test","test");
                new MainActivity.Playaudio().execute(new String("1000"),"test","test");
                new MainActivity.Playaudio().execute(new String("2800"),"test","test");

                return true;


            case R.id.play_merc:
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                new MainActivity.Playaudio().execute(new String("2200"),"test","test");
                new MainActivity.Playaudio().execute(new String("1400"),"test","test");
                new MainActivity.Playaudio().execute(new String("2700"),"test","test");
                new MainActivity.Playaudio().execute(new String("1200"),"test","test");

                return true;

            case R.id.play_norton:
                    new MainActivity.Playaudio().execute(new String("3800"),"test","test");
                    new MainActivity.Playaudio().execute(new String("3800"),"test","test");

                    new MainActivity.Playaudio().execute(new String("2300"),"test","test");
                    new MainActivity.Playaudio().execute(new String("2400"),"test","test");
                    new MainActivity.Playaudio().execute(new String("2700"),"test","test");
                    new MainActivity.Playaudio().execute(new String("2900"),"test","test");
                    new MainActivity.Playaudio().execute(new String("2400"),"test","test");
                    new MainActivity.Playaudio().execute(new String("2300"),"test","test");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void RunTimeError(String s) {
        Log.d("12345", "RunTimeError: Error");
    }


    public class Playaudio extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {

            double duration = 0.05;                // seconds
            double freqOfTone = Integer.parseInt(params[0]);           // hz
            int sampleRate = 8000;              // a number

            double dnumSamples = duration * sampleRate;
            dnumSamples = Math.ceil(dnumSamples);
            int numSamples = (int) dnumSamples;
            double sample[] = new double[numSamples];
            byte generatedSnd[] = new byte[2 * numSamples];


            for (int i = 0; i < numSamples; ++i) {      // Fill the sample array
                sample[i] = Math.sin(freqOfTone * 2 * Math.PI * i / (sampleRate));
            }

            // convert to 16 bit pcm sound array
            // assumes the sample buffer is normalized.
            // convert to 16 bit pcm sound array
            // assumes the sample buffer is normalised.
            int idx = 0;
            int i = 0 ;

            int ramp = numSamples / 20 ;                                    // Amplitude ramp as a percent of sample count


            for (i = 0; i< ramp; ++i) {                                     // Ramp amplitude up (to avoid clicks)
                double dVal = sample[i];
                // Ramp up to maximum
                final short val = (short) ((dVal * 32767 * i/ramp));
                // in 16 bit wav PCM, first byte is the low order byte
                generatedSnd[idx++] = (byte) (val & 0x00ff);
                generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
            }


            for (i = i; i< numSamples - ramp; ++i) {                        // Max amplitude for most of the samples
                double dVal = sample[i];
                // scale to maximum amplitude
                final short val = (short) ((dVal * 32767));
                // in 16 bit wav PCM, first byte is the low order byte
                generatedSnd[idx++] = (byte) (val & 0x00ff);
                generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
            }

            for (i = i; i< numSamples; ++i) {                               // Ramp amplitude down
                double dVal = sample[i];
                // Ramp down to zero
                final short val = (short) ((dVal * 32767 * (numSamples-i)/ramp ));
                // in 16 bit wav PCM, first byte is the low order byte
                generatedSnd[idx++] = (byte) (val & 0x00ff);
                generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
            }

            AudioTrack audioTrack = null;                                   // Get audio track
            try {
                audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                        sampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                        AudioFormat.ENCODING_PCM_16BIT, (int)numSamples*2,
                        AudioTrack.MODE_STATIC);
                audioTrack.write(generatedSnd, 0, generatedSnd.length);     // Load the track
                audioTrack.play();                                          // Play the track
            }
            catch (Exception e){
                RunTimeError("Error: " + e);
            }

            int x =0;
            do{                                                     // Montior playback to find when done
                if (audioTrack != null)
                    x = audioTrack.getPlaybackHeadPosition();
                else
                    x = numSamples;
            }while (x<numSamples);

            if (audioTrack != null) audioTrack.release();           // Track play done. Release track.



            return null;
        }
    }

}
