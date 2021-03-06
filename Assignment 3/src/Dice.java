import java.util.*;
//this dice class is not mine as allowed in the pdf I have taken the implementation from Lecture 1
public final class Dice {
    private final int numFaces; //maximum face value
    private int faceValue; //current value showing on the dice
    // Constructor: Sets the initial face value.
    public Dice(int _numFaces) {
        numFaces = _numFaces;
        //roll();
    }
    // Rolls the dice
    public void roll() {
        Random rand = new Random();
        int curr_faceValue = 1 + rand.nextInt(numFaces);
        setFaceValue(curr_faceValue);
    }
    // Face value setter/mutator.
    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }


    // Face value getter/setter.
    public int getFaceValue() {
        return faceValue;
    }

    // Face value getter/setter.
    public int getNumFaces() {
        return numFaces;
    }

    // Returns a string representation of this dice
    public String toString() {
        return ("number of Faces " + numFaces +"current face value " + faceValue);
    }
} // End of Dice class

