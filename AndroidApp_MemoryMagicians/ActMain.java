package edu.wsu.memorymagicians2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Random;

public class ActMain extends AppCompatActivity {

    private ImageButton imageBtn1, imageBtn2, imageBtn3, imageBtn4, imageBtn5, imageBtn6,
            imageBtn7, imageBtn8, imageBtn9, imageBtn10, imageBtn11, imageBtn12, tempBtn0, tempBtn;

    RadioButton radioButtonBlue, radioButtonRed, radioButtonGreen, radioButtonYellow,
            radioButtonOrange, radioButtonPurple, currentUnmatchedColor, currentMatchedColor;

    private Button resetBtn;
    private int[] imageArray;
    private int[] randomArray;
    private RadioGroup radioGroup1, radioGroup2;
    private EditText numberOfTries, numberOfMatches;
    private boolean imageClick, firstTry;
    private int blue, red, yellow, green, purple, orange,
            currentUMC, currentMC, attempt, guess1, guess2, numOfTries, numOfMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laymain);

        imageArray = new int[]{R.drawable.bear, R.drawable.elephant, R.drawable.giraffe, R.drawable.kangaro,
                R.drawable.lionjpg, R.drawable.monkey};

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        numberOfTries = findViewById(R.id.numberOfTries);
        numberOfMatches = findViewById(R.id.numberOfMatches);
        resetBtn = findViewById(R.id.resetBtn);
        blue = R.color.blue;
        red = R.color.red;
        yellow = R.color.yellow;
        green = R.color.green;
        purple = R.color.purple;
        orange = R.color.orange;

        imageClick = true;

        imageBtn1 = findViewById(R.id.imageBtn1);
        imageBtn2 = findViewById(R.id.imageBtn2);
        imageBtn3 = findViewById(R.id.imageBtn3);
        imageBtn4 = findViewById(R.id.imageBtn4);
        imageBtn5 = findViewById(R.id.imageBtn5);
        imageBtn6 = findViewById(R.id.imageBtn6);
        imageBtn7 = findViewById(R.id.imageBtn7);
        imageBtn8 = findViewById(R.id.imageBtn8);
        imageBtn9 = findViewById(R.id.imageBtn9);
        imageBtn10 = findViewById(R.id.imageBtn10);
        imageBtn11 = findViewById(R.id.imageBtn11);
        imageBtn12 = findViewById(R.id.imageBtn12);

        int radioIdBlue = radioGroup1.getCheckedRadioButtonId();
        radioButtonBlue = findViewById(radioIdBlue);
        int radioIdRed = radioGroup1.getCheckedRadioButtonId();
        radioButtonRed = findViewById(radioIdRed);
        int radioIdYellow = radioGroup1.getCheckedRadioButtonId();
        radioButtonYellow = findViewById(radioIdYellow);
        int radioIdGreen = radioGroup2.getCheckedRadioButtonId();
        radioButtonGreen = findViewById(radioIdGreen);
        int radioIdOrange = radioGroup2.getCheckedRadioButtonId();
        radioButtonOrange = findViewById(radioIdOrange);
        int radioIdPurple = radioGroup2.getCheckedRadioButtonId();
        radioButtonPurple = findViewById(radioIdPurple);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetImageBtnColors();
                resetBoard();
            }
        });
    }

    public void changeUnmatchedColor(View view) {
        resetBoard();
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonBlue:
                if (checked) {
                    imageBtn1.setImageResource(R.color.blue);
                    imageBtn2.setImageResource(R.color.blue);
                    imageBtn3.setImageResource(R.color.blue);
                    imageBtn4.setImageResource(R.color.blue);
                    imageBtn5.setImageResource(R.color.blue);
                    imageBtn6.setImageResource(R.color.blue);
                    imageBtn7.setImageResource(R.color.blue);
                    imageBtn8.setImageResource(R.color.blue);
                    imageBtn9.setImageResource(R.color.blue);
                    imageBtn10.setImageResource(R.color.blue);
                    imageBtn11.setImageResource(R.color.blue);
                    imageBtn12.setImageResource(R.color.blue);
                    currentUMC = blue;
                    currentUnmatchedColor = radioButtonBlue;
                    break;
                }
            case R.id.radioButtonRed:
                if (checked) {
                    imageBtn1.setImageResource(R.color.red);
                    imageBtn2.setImageResource(R.color.red);
                    imageBtn3.setImageResource(R.color.red);
                    imageBtn4.setImageResource(R.color.red);
                    imageBtn5.setImageResource(R.color.red);
                    imageBtn6.setImageResource(R.color.red);
                    imageBtn7.setImageResource(R.color.red);
                    imageBtn8.setImageResource(R.color.red);
                    imageBtn9.setImageResource(R.color.red);
                    imageBtn10.setImageResource(R.color.red);
                    imageBtn11.setImageResource(R.color.red);
                    imageBtn12.setImageResource(R.color.red);
                    currentUMC = red;
                    currentUnmatchedColor = radioButtonRed;
                    break;
                }
            case R.id.radioButtonYellow:
                if (checked) {
                    imageBtn1.setImageResource(R.color.yellow);
                    imageBtn2.setImageResource(R.color.yellow);
                    imageBtn3.setImageResource(R.color.yellow);
                    imageBtn4.setImageResource(R.color.yellow);
                    imageBtn5.setImageResource(R.color.yellow);
                    imageBtn6.setImageResource(R.color.yellow);
                    imageBtn7.setImageResource(R.color.yellow);
                    imageBtn8.setImageResource(R.color.yellow);
                    imageBtn9.setImageResource(R.color.yellow);
                    imageBtn10.setImageResource(R.color.yellow);
                    imageBtn11.setImageResource(R.color.yellow);
                    imageBtn12.setImageResource(R.color.yellow);
                    currentUMC = yellow;
                    currentUnmatchedColor = radioButtonYellow;
                    break;
                }
        }
    }

    public void changeMatchedColor(View view) {
        resetBoard();
        resetImageBtnColors();
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonGreen:
                if (checked) {
                    currentMC = green;
                    break;
                }
            case R.id.radioButtonOrange:
                if (checked) {
                    currentMC = orange;
                    break;
                }
            case R.id.radioButtonPurple:
                if (checked) {
                    currentMC = purple;
                    break;
                }
        }
    }

    public void matchImage(View view)
    {
        int id = view.getId();
        if (imageClick) {
            if (numOfMatches < 6)
            {
                if (id == 2131165254) {
                    imageBtn1.setImageResource(imageArray[randomArray[0]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn1.setEnabled(false);
                        imageBtn1.setImageResource(imageArray[randomArray[0]]);
                        tempBtn = imageBtn1;
                        guess1 = randomArray[0];
                    }
                    else {
                        guess2 = randomArray[0];
                        if(guess1 == guess2){
                            match();
                            imageBtn1.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn1.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn1;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165258) {
                    imageBtn2.setImageResource(imageArray[randomArray[1]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn2.setEnabled(false);
                        imageBtn2.setImageResource(imageArray[randomArray[1]]);
                        tempBtn = imageBtn2;
                        guess1 = randomArray[1];
                    }
                    else {
                        guess2 = randomArray[1];
                        if(guess1 == guess2){
                            match();
                            imageBtn2.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn2.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn2;

                        }
                        attempt = 0;
                    }
                }

                if (id == 2131165259) {
                    imageBtn3.setImageResource(imageArray[randomArray[2]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn3.setEnabled(false);
                        imageBtn3.setImageResource(imageArray[randomArray[2]]);
                        tempBtn = imageBtn3;
                        guess1 = randomArray[2];
                    }
                    else {
                        guess2 = randomArray[2];
                        if(guess1 == guess2){
                            match();
                            imageBtn3.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn3.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn3;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165260) {
                    imageBtn4.setImageResource(imageArray[randomArray[3]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn4.setEnabled(false);
                        imageBtn4.setImageResource(imageArray[randomArray[3]]);
                        tempBtn = imageBtn4;
                        guess1 = randomArray[3];
                    }
                    else {
                        guess2 = randomArray[3];
                        if(guess1 == guess2){
                            match();
                            imageBtn4.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn4.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn4;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165261) {
                    imageBtn5.setImageResource(imageArray[randomArray[4]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn5.setEnabled(false);
                        imageBtn5.setImageResource(imageArray[randomArray[4]]);
                        tempBtn = imageBtn5;
                        guess1 = randomArray[4];
                    }
                    else {
                        guess2 = randomArray[4];
                        if(guess1 == guess2){
                            match();
                            imageBtn5.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn5.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn5;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165262) {
                    imageBtn6.setImageResource(imageArray[randomArray[5]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn6.setEnabled(false);
                        imageBtn6.setImageResource(imageArray[randomArray[5]]);
                        tempBtn = imageBtn6;
                        guess1 = randomArray[5];
                    }
                    else {
                        guess2 = randomArray[5];
                        if(guess1 == guess2){
                            match();
                            imageBtn6.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn6.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn6;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165263) {
                    imageBtn7.setImageResource(imageArray[randomArray[6]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn7.setEnabled(false);
                        imageBtn7.setImageResource(imageArray[randomArray[6]]);
                        tempBtn = imageBtn7;
                        guess1 = randomArray[6];
                    }
                    else {
                        guess2 = randomArray[6];
                        if(guess1 == guess2){
                            match();
                            imageBtn7.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn7.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn7;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165264) {
                    imageBtn8.setImageResource(imageArray[randomArray[7]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn8.setEnabled(false);
                        imageBtn8.setImageResource(imageArray[randomArray[7]]);
                        tempBtn = imageBtn8;
                        guess1 = randomArray[7];
                    }
                    else {
                        guess2 = randomArray[7];
                        if(guess1 == guess2){
                            match();
                            imageBtn8.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn8.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn8;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165265) {
                    imageBtn9.setImageResource(imageArray[randomArray[8]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn9.setEnabled(false);
                        imageBtn9.setImageResource(imageArray[randomArray[8]]);
                        tempBtn = imageBtn9;
                        guess1 = randomArray[8];
                    }
                    else {
                        guess2 = randomArray[8];
                        if(guess1 == guess2){
                            match();
                            imageBtn9.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn9.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn9;
                            noMatch();
                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165255) {
                    imageBtn10.setImageResource(imageArray[randomArray[9]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn10.setEnabled(false);
                        imageBtn10.setImageResource(imageArray[randomArray[9]]);
                        tempBtn = imageBtn10;
                        guess1 = randomArray[9];
                    }
                    else {
                        guess2 = randomArray[9];
                        if(guess1 == guess2){
                            match();
                            imageBtn10.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn10.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn10;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165256) {
                    imageBtn11.setImageResource(imageArray[randomArray[10]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn11.setEnabled(false);
                        imageBtn11.setImageResource(imageArray[randomArray[10]]);
                        tempBtn = imageBtn11;
                        guess1 = randomArray[10];
                    }
                    else {
                        guess2 = randomArray[10];
                        if(guess1 == guess2){
                            match();
                            imageBtn11.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn11.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn11;

                        }
                        attempt = 0;
                    }
                }
                if (id == 2131165257) {
                    imageBtn12.setImageResource(imageArray[randomArray[11]]);
                    attempt++;
                    if(attempt == 1){
                        imageBtn12.setEnabled(false);
                        imageBtn12.setImageResource(imageArray[randomArray[11]]);
                        tempBtn = imageBtn12;
                        guess1 = randomArray[11];
                    }
                    else {
                        guess2 = randomArray[11];
                        if(guess1 == guess2){
                            match();
                            imageBtn12.setImageResource(currentMC);
                            tempBtn.setImageResource(currentMC);
                            imageBtn12.setEnabled(false);
                            tempBtn.setEnabled(false);
                            numOfTries++;
                            numberOfTries.setText(String.valueOf(numOfTries));
                            numOfMatches++;
                            numberOfMatches.setText(String.valueOf(numOfMatches));
                        }
                        else {
                            noMatch();
                            tempBtn.setEnabled(true);
                            tempBtn0 = imageBtn12;

                        }
                        attempt = 0;
                    }
                }
            }

            if (numOfMatches == 6)
            {
                wonGame();
                resetBoard();
                resetImageBtnColors();
            }
        }
    }

    public void resetBoard(){
        attempt = 0;
        Random rn = new Random();
        int[] counterArray = new int[]{0, 0, 0, 0, 0, 0};
        randomArray = new int[12];
        int i = 0;
        numberOfTries.setText(String.valueOf(0));
        numberOfMatches.setText(String.valueOf(0));
        enableImageBtns();
        numOfMatches = 0;
        numOfTries = 0;

        while (i < 12) {
            int a = rn.nextInt(6);
            if (a == 0 && counterArray[0] != 2) {
                randomArray[i] = a;
                counterArray[0]++;
                i++;
            }
            if (a == 1 && counterArray[1] != 2) {
                randomArray[i] = a;
                counterArray[1]++;
                i++;
            }
            if (a == 2 && counterArray[2] != 2) {
                randomArray[i] = a;
                counterArray[2]++;
                i++;
            }
            if (a == 3 && counterArray[3] != 2) {
                randomArray[i] = a;
                counterArray[3]++;
                i++;
            }
            if (a == 4 && counterArray[4] != 2) {
                randomArray[i] = a;
                counterArray[4]++;
                i++;
            }
            if (a == 5 && counterArray[5] != 2) {
                randomArray[i] = a;
                counterArray[5]++;
                i++;
            }
        }
    }

    public void resetImageBtnColors(){
        imageBtn1.setImageResource(currentUMC);
        imageBtn2.setImageResource(currentUMC);
        imageBtn3.setImageResource(currentUMC);
        imageBtn4.setImageResource(currentUMC);
        imageBtn5.setImageResource(currentUMC);
        imageBtn6.setImageResource(currentUMC);
        imageBtn7.setImageResource(currentUMC);
        imageBtn8.setImageResource(currentUMC);
        imageBtn9.setImageResource(currentUMC);
        imageBtn10.setImageResource(currentUMC);
        imageBtn11.setImageResource(currentUMC);
        imageBtn12.setImageResource(currentUMC);
    }

    public void enableImageBtns(){
        imageBtn1.setEnabled(true);
        imageBtn2.setEnabled(true);
        imageBtn3.setEnabled(true);
        imageBtn4.setEnabled(true);
        imageBtn5.setEnabled(true);
        imageBtn6.setEnabled(true);
        imageBtn7.setEnabled(true);
        imageBtn8.setEnabled(true);
        imageBtn9.setEnabled(true);
        imageBtn10.setEnabled(true);
        imageBtn11.setEnabled(true);
        imageBtn12.setEnabled(true);
    }

    public void noMatch(){
        AlertDialog.Builder alert = new AlertDialog.Builder(ActMain.this);
        alert.setMessage("No Match!");
        alert.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        noMatchLogic();
                    }
                });
        alert.show();
    }

    private void noMatchLogic() {
        if(tempBtn0 == imageBtn1){
            imageBtn1.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn2){
            imageBtn2.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn3){
            imageBtn3.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn4){
            imageBtn4.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn5){
            imageBtn5.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn6){
            imageBtn6.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn7){
            imageBtn7.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn8){
            imageBtn8.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn9){
            imageBtn9.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn10){
            imageBtn10.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn11){
            imageBtn11.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
        if(tempBtn0 == imageBtn12){
            imageBtn12.setImageResource(currentUMC);
            tempBtn.setImageResource(currentUMC);
            numOfTries++;
            numberOfTries.setText(String.valueOf(numOfTries));
        }
    }

    public void match(){
        AlertDialog.Builder alert = new AlertDialog.Builder(ActMain.this);
        if (numOfMatches < 5){
            alert.setMessage("You got it!");
        }
        else alert.setMessage("Play again!");

        alert.setPositiveButton("OK",null);
        alert.show();
    }

    public void wonGame(){
        AlertDialog.Builder alert = new AlertDialog.Builder(ActMain.this);
        alert.setMessage("You Win! Great Job!");
        alert.setPositiveButton("OK",null);
        alert.show();
    }
}
