package draw.g12.li21n.poo.isel.pt.draw.App;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Line;
import draw.g12.li21n.poo.isel.pt.draw.App.View.DrawView;


public class DrawController extends Activity {
    private static final float BUTTON_TEXT_SIZE = 30;

//    private Draw draw;
//    private Figure toDraw;
//    private LinkedList<Figure> drawablesList;

    private DrawView drawView;

    RadioButton radioButtonChecked;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        buildView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
         outState.putString("CheckedRadio", radioButtonChecked.getTag().toString());
    }

    @SuppressLint("ClickableViewAccessibility")
    private void buildView(){

        try {
            final LinearLayout buttonPanel = new LinearLayout(this);
            buttonPanel.setOrientation(LinearLayout.HORIZONTAL);

            final Button resetButton = new Button(this);
            resetButton.setText("RESET");
            resetButton.setTextSize(BUTTON_TEXT_SIZE);

            resetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onReset();
                }
            });

            final Button loadButton = new Button(this);
            loadButton.setText("LOAD");
            loadButton.setTextSize(BUTTON_TEXT_SIZE);
            loadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLoad();
                }
            });

            final Button saveButton = new Button(this);
            saveButton.setText("SAVE");
            saveButton.setTextSize(BUTTON_TEXT_SIZE);

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSave();
                }
            });

            final RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(LinearLayout.HORIZONTAL);

            final RadioButton lineRadio = new RadioButton(this);
            lineRadio.setText("Line");
            lineRadio.setTag(Line.class.getCanonicalName());

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


            //radioButtonChecked = lineRadio;

            buttonPanel.addView(resetButton);
            buttonPanel.addView(loadButton);
            buttonPanel.addView(saveButton);

            final LinearLayout rootPanel = new LinearLayout(this);
            rootPanel.setOrientation(LinearLayout.VERTICAL);

            final LinearLayout drawPanel = new LinearLayout(this);
            drawPanel.setBackgroundColor(Color.parseColor("#D3F2EE"));
            drawPanel.addView(drawView);

            rootPanel.addView(buttonPanel);
            rootPanel.addView(radioGroup);
            rootPanel.addView(drawPanel);

            lineRadio.setChecked(true);
            radioButtonChecked = lineRadio;
            ViewGroup.LayoutParams params = drawPanel.getLayoutParams();
            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
            params.height = LinearLayout.LayoutParams.MATCH_PARENT;

            drawPanel.setLayoutParams(params);


            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    radioButtonChecked =findViewById(checkedId);

                    Log.v("RadioChecked", radioButtonChecked.getText().toString());

                }
            });

//            lineRadio.setChecked(true);

            setContentView(rootPanel);
        }
        catch (Exception e){
            Log.e("buildingerrors", "Error building Layout", e);
        }
    }

    private void onReset(){

//            if(drawView.ldrawables != null)
//                draw.ldrawables.clear();
//            drawView.repaint(null);
    }

    private void onLoad(){
        //TODO: onLoad
    }

    private void onSave(){
        //TODO: onSave
    }

    public Figure createSelectedFigure(int x, int y){

        return Figure.newInstance(radioButtonChecked.getTag().toString(), x, y);
    }
//******************** Moved to DrawView?! *******************************//

//    private void init(final Figure figure){
//        Figure.FigureListener listener = new Figure.FigureListener() {
//            @Override
//            public void EndPointChanged(Point endPos) {
//                draw.repaint(toDraw);
//            }
//
//            @Override
//            public void PointCreated(Point position) {
//                draw.repaint(toDraw);
//            }
//        };
//        toDraw.setListener(listener);
//
//    }

//    private void saveDrawing(){
//        // TODO: colocar o filepath numa constante ?
//
//        try (FileOutputStream outputStream = openFileOutput("drawingSaved.txt", MODE_PRIVATE);
//             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))
//        ){
//            if(draw.ldrawables != null && draw.ldrawables.size()>0 ){
//                bufferedWriter.write(draw.ldrawables.size());
//                bufferedWriter.newLine();
//                Log.v("BuildingFile", Integer.toString(draw.ldrawables.size()));
//                Iterator<Figure> itr = draw.ldrawables.iterator();
//
//                while(itr.hasNext()){
//                    String temp  =itr.next().toString() ;
//                    bufferedWriter.write(temp);
//                    Log.v("BuildingFile", temp);
//                    bufferedWriter.newLine();
//                }
//                Log.v("BuildingFiledir", this.getFilesDir().getAbsolutePath());
//            }
//        } catch (IOException e){
//            Log.e("IoError", "ProblemSaving", e);
//        }
//    }

    private void loadDrawing() {
        try(FileInputStream fileInputStream = openFileInput("drawingSaved.txt");
            Scanner input = new Scanner(fileInputStream)
        ){
            while(input.hasNext()){
                Log.v("ReadingFile", input.next());
            }
        }
        catch (IOException e){
            Log.e("IoError", "ProblemSaving", e);
        }
    }

}
