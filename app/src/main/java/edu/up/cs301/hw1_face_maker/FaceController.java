//
// @author Addison Raak
// Homework #1 -- Face Maker
//

package edu.up.cs301.hw1_face_maker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements View.OnClickListener,  SeekBar.OnSeekBarChangeListener,
                                        Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    //instance variables
    Face controller;
    int red, green, blue, radioButtonIndex;

    /**
     * constructor
     * @param face
     */
    public FaceController(Face face) {
        controller = face;
    }

    /**
     * External Citation
     * Date: October 6, 2020
     * Problem: I needed to get the index of the RadioButton inside the RadioGroup
     * Resource:
     * https://stackoverflow.com/questions/6440259/how-to-get-the-selected-index-of-a-radiogroup-in-android
     *
     * Solution: I used the example code from this post.
     */

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        View tempButton = radioGroup.findViewById(i);
        radioButtonIndex = radioGroup.indexOfChild(tempButton);
        // attempt to update the seekbar after changing the RadioButton
        // SeekBar redSeek = controller.findViewById(R.id.redSeek);
        // redSeek.setProgress(red);
        controller.invalidate();
    }

    /**
     * Handles the SeekBar changes
     * @param seekBar
     * @param i
     * @param b
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //find the SeekBar ID and see if it matches the ones we know, if so, change value
        int barID = seekBar.getId();

        if(barID == R.id.redSeek) {
            red = seekBar.getProgress();
        }
        else if(barID == R.id.blueSeek) {
            blue = seekBar.getProgress();
        }
        else if (barID == R.id.greenSeek) {
            green = seekBar.getProgress();
        }
        switch(radioButtonIndex) {
            case 0:
                controller.setHairColor(red, green, blue);
                break;
            case 1:
                controller.setEyeColor(red, green, blue);
                break;
            case 2:
                controller.setSkinColor(red, green, blue);
                controller.invalidate();
                break;
        }
        // controller.setSkinColor(red, green, blue);
        controller.invalidate();
    }

    /**
     * Handles when the random button is clicked
     * @param view
     */
    @Override
    public void onClick(View view) {
        controller.randomize();
        controller.invalidate();
    }

    /**
     * Handles when the Spinner is changed to select the different hair styles
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        controller.hairStyle = i;
        controller.invalidate();
    }



    /**
     * These all do nothing because we don't need them to do anything, for instance we don't
     * need to track where the user is touching on the screen, only if they touch a button or
     * other feature.
     */

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}
