package com.example.asheransari.miwokpractices;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class family_activity extends Fragment {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = (new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releasePlayer();
            }
        }
    });

    private MediaPlayer.OnCompletionListener releasePlayer = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releasePlayer();
        }
    });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.word_list);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        View v = inflater.inflate(R.layout.word_list, parent, false);
        final ArrayList<variableClass> variableClasses = new ArrayList<variableClass>();
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        variableClasses.add(new variableClass("father", "apa", R.drawable.family_father, R.raw.family_father));
        variableClasses.add(new variableClass("mother", "ata", R.drawable.family_mother, R.raw.family_mother));
        variableClasses.add(new variableClass("son", "angsi", R.drawable.family_son, R.raw.family_son));
        variableClasses.add(new variableClass("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        variableClasses.add(new variableClass("old brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        variableClasses.add(new variableClass("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        variableClasses.add(new variableClass("older sister", "tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        variableClasses.add(new variableClass("younger sister", "kolliti", R.drawable.family_older_sister, R.raw.family_younger_sister));
        variableClasses.add(new variableClass("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        variableClasses.add(new variableClass("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(getActivity(), variableClasses, R.color.family);

        ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                variableClass variableClasses1 = variableClasses.get(position);
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), variableClasses1.getmAudioResourceID());
                    mediaPlayer.start();
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasePlayer();
                        Toast.makeText(getActivity(), "I am Done!!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }

    private void releasePlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }
}
