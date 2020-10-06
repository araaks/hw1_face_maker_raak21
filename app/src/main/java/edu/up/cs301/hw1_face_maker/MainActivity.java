//
// @author Addison Raak
// Homework #1 -- Face Maker
//

package edu.up.cs301.hw1_face_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NEED TO FIGURE OUT HOW TO INIT THE FACE
        Face face = (Face) findViewById(R.id.face);

        // Also need to init the FaceController to actually control the face
        FaceController controller = new FaceController(face);

        // init the seekbars and set their max val to 255
        SeekBar rSeek = (SeekBar) findViewById(R.id.redSeek);
        rSeek.setMax(255);
        rSeek.setOnSeekBarChangeListener(controller);

        SeekBar gSeek = (SeekBar) findViewById(R.id.greenSeek);
        gSeek.setMax(255);
        gSeek.setOnSeekBarChangeListener(controller);

        SeekBar bSeek = (SeekBar) findViewById(R.id.blueSeek);
        bSeek.setMax(255);
        bSeek.setOnSeekBarChangeListener(controller);

        // init the random button
        Button randomButton = (Button) findViewById(R.id.randomButtom);
        randomButton.setOnClickListener(controller);

        /**
         * External Citation
         * Date: October 6, 2020
         * Problem: I needed help to figure out how to set a listener for a spinner
         * Resource:
         * https://stackoverflow.com/questions/1337424/android-spinner-get-the-selected-item-change-event
         *
         * Solution: I used the example code from this post.
         */

        // init the spinner
        Spinner spin = (Spinner) findViewById(R.id.hairSpinner);
        spin.setOnItemSelectedListener(controller);

        // init the radio buttons and the radio group
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        group.setOnCheckedChangeListener(controller);

        RadioButton hairButton = (RadioButton) findViewById(R.id.hairButton);
        RadioButton skinButton = (RadioButton) findViewById(R.id.skinButton);
        RadioButton eyeButton = (RadioButton) findViewById(R.id.eyesButton);



    }
}