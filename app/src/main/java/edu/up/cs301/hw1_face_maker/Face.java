//
// @author Addison Raak
// Homework #1 -- Face Maker
//

package edu.up.cs301.hw1_face_maker;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Face extends SurfaceView {
    public int skinColor = 0;
    public int eyeColor = 0;
    public int hairColor = 0;
    public int hairStyle = 0;
    public Paint paint = new Paint();

    //
    // Constructor
    //
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        randomize();
    }

    /**
     * Setters
     * @param red
     * @param green
     * @param blue
     */
    public void setSkinColor(int red, int green, int blue) {
        skinColor = Color.rgb(red, green, blue);
    }

    public void setEyeColor(int red, int green, int blue) {
        eyeColor = Color.rgb(red, green, blue);
    }

    public void setHairColor(int red, int green, int blue) {
        hairColor = Color.rgb(red, green, blue);
    }

    /**
     * This Randomizes the color values for each attribute of the face.
     *
     * I googled what the integer value range was for colors and found that it was
     * [-16777216,-1]. This is why I picked those values.
     * https://bit.ly/30BDljU
    */

    public void randomize() {
        //integer values of [-16777216,-1], which translate to a color
        skinColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));
        eyeColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));
        hairColor = -1 + (int) (Math.random() * ((-16777216 + 1) + 1));

        //integer values of 0, 1, 2
        hairStyle = (int) (Math.random() * 3);
    }

    /**
     * Helper methods so onDraw ridiculously long
     * @param canvas
     */
    public void drawFace(Canvas canvas) {
        paint.setColor(skinColor);
        canvas.drawCircle(800, 600, 400, paint);

        //draw eyebrows
        paint.setColor(Color.BLACK);
        canvas.drawRect(600, 300, 780, 350, paint);
        canvas.drawRect(820, 350, 1000, 400, paint);
    }

    /**
     * Draws the whites, iris, and pupils of the eyes
     * @param canvas
     */
    public void drawEyes(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawCircle(700, 500, 80, paint);
        canvas.drawCircle(900, 500, 80, paint);

        paint.setColor(eyeColor);
        canvas.drawCircle(700, 500, 70, paint);
        canvas.drawCircle(900, 500, 70, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(700, 500, 20, paint);
        canvas.drawCircle(900, 500, 20, paint);
    }

    /**
     * Draws the shocked mouth!
     * @param canvas
     */
    public void drawMouth(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawCircle(800, 750, 40, paint);
    }

    /**
     * Draws one of three haircuts based on what the hairStyle var is.
     *      0) Bald
     *      1) Flat Top
     *      2) Spiky Hair
     * @param canvas
     */
    public void drawHair(Canvas canvas) {
        // draw three different hair styles
        switch(hairStyle) {

            // Shiny Bald Head
            case 0:
                paint.setColor(Color.WHITE);
                paint.setTextSize(50);
                paint.setFakeBoldText(true);
                canvas.drawText("#", 1000, 325, paint);
                break;

            // Flat top
            case 1:
                paint.setColor(hairColor);
                canvas.drawRect(575, 100, 1025, 275, paint);
                break;

            // Spiky Hair
            case 2:
                // triangle to be translated
                Point a = new Point(575, 275);
                Point b = new Point(650, 100);
                Point c = new Point(725, 275);

                paint.setColor(hairColor);
                paint.setStyle(Paint.Style.FILL);
                Path path = new Path();
                /***********************************************************************************
                 * Uncomment this line to get an interesting shape for the Spiky Hair!
                 *
                 * path.setFillType(Path.FillType.EVEN_ODD);
                 *
                ***********************************************************************************/

                for(int i = 0; i < 4; i++) {
                    path.moveTo(b.x + (i * 100), b.y);
                    path.lineTo(c.x + (i * 100), c.y);
                    path.lineTo(a.x + (i * 100), a.y);
                    path.close();
                }

                canvas.drawPath(path, paint);
        }
    }

    /**
     * Calls all of the helper functions written above to draw the face in the correct order
     * @param canvas
     */
    public void onDraw(Canvas canvas) {
        drawFace(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
        drawHair(canvas);
    }
} // Face