//
// @author Addison Raak
// Homework #1 -- Face Maker
//

package edu.up.cs301.hw1_face_maker;

public class Face {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    //
    // Constructor
    //
    public Face() {
        Randomize(this);
    }

    //
    // This Randomizes the color values for each attribute of the face.
    //
    // I googled what the integer value range was for colors and found that it was
    // [-16777216,-1]. This is why I picked those values.
    // https://stackoverflow.com/questions/8489990/how-to-set-color-using-integer#:~:text=(i.e.)%20the%20whole%20color%20int,constant%20for%20black%20in%20android.
    //
    public void Randomize(Face face) {
        // integer values of [-16777216,-1]
        skinColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));
        eyeColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));
        hairColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));

        // integer values of 0, 1, 2
        hairStyle = (int) (Math.random() * 3);
    }
}
