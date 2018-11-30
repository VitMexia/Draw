package draw.g12.li21n.poo.isel.pt.draw;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private static final float BUTTON_TEXT_SIZE = 30;

    private  Draw draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        draw = new Draw(this);
        buildView();



    }
    boolean pushed = false;
    int countMoves = 0;

    @SuppressLint("ClickableViewAccessibility")
    private void buildView(){

        try {
            final LinearLayout buttonPanel = new LinearLayout(this);
            buttonPanel.setOrientation(LinearLayout.HORIZONTAL);

            final Button resetButton = new Button(this);
            resetButton.setText("RESET");
            resetButton.setTextSize(BUTTON_TEXT_SIZE);


            final Button loadButton = new Button(this);
            loadButton.setText("LOAD");
            loadButton.setTextSize(BUTTON_TEXT_SIZE);

            final Button saveButton = new Button(this);
            saveButton.setText("SAVE");
            saveButton.setTextSize(BUTTON_TEXT_SIZE);

            final RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(LinearLayout.HORIZONTAL);

            final RadioButton lineRadio = new RadioButton(this);
            lineRadio.setText("Line");


            final RadioButton rectRadio = new RadioButton(this);
            rectRadio.setText("Rect");

            final RadioButton pixelRadio = new RadioButton(this);
            pixelRadio.setText("Pixel");

            final RadioButton circleRadio = new RadioButton(this);
            circleRadio.setText("Circle");

            radioGroup.addView(lineRadio);
            radioGroup.addView(rectRadio);
            radioGroup.addView(pixelRadio);
            radioGroup.addView(circleRadio);



            lineRadio.setChecked(true);

            buttonPanel.addView(resetButton);
            buttonPanel.addView(loadButton);
            buttonPanel.addView(saveButton);

            final LinearLayout rootPanel = new LinearLayout(this);
            rootPanel.setOrientation(LinearLayout.VERTICAL);

            final LinearLayout drawPanel = new LinearLayout(this);
            drawPanel.setBackgroundColor(Color.parseColor("#D3F2EE"));
            drawPanel.addView(draw);

           drawPanel.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    final int action = event.getAction();


                    if(action == MotionEvent.ACTION_DOWN){
                        Log.v("ScreenPressed", "Down");
                        pushed  = true;
                        draw.setStartPosition(new Position(event.getX(), event.getY()));
                        draw.setEndPosition(new Position(event.getX(), event.getY()));

                    }
                    else if(action == MotionEvent.ACTION_UP){
                        Log.v("ScreenPressed", "Up");
                        draw.setEndPosition(new Position(event.getX(), event.getY()));
                        pushed = false;

                    }
                    else if(pushed && action == MotionEvent.ACTION_MOVE){
                        draw.setEndPosition(new Position(event.getX(), event.getY()));

                    }
                    return true;
                }
            });

            rootPanel.addView(buttonPanel);
            rootPanel.addView(radioGroup);
            rootPanel.addView(drawPanel);

            ViewGroup.LayoutParams params = drawPanel.getLayoutParams();
            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
            params.height = LinearLayout.LayoutParams.MATCH_PARENT;

            drawPanel.setLayoutParams(params);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton radioButton =findViewById(checkedId);

                    Log.v("RadioChecked", radioButton.getText().toString());

                }
            });

            setContentView(rootPanel);
        }
        catch (Exception e){
            Log.e("buildingerrors", "Error building Layout", e);
        }
    }
}
