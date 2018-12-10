package draw.g12.li21n.poo.isel.pt.draw;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toolbar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import draw.g12.li21n.poo.isel.pt.draw.Model.Circle;
import draw.g12.li21n.poo.isel.pt.draw.Model.DrawModel;
import draw.g12.li21n.poo.isel.pt.draw.Model.Figure;
import draw.g12.li21n.poo.isel.pt.draw.Model.Line;
import draw.g12.li21n.poo.isel.pt.draw.Model.Pixel;
import draw.g12.li21n.poo.isel.pt.draw.Model.Rect;
import draw.g12.li21n.poo.isel.pt.draw.View.DrawView;


public class DrawController extends Activity {
    private static final float BUTTON_TEXT_SIZE = 30;

    DrawModel drawModel;

    private DrawView drawView;

    RadioButton radioButtonChecked;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        buildView();

        if (savedInstanceState != null) {
            drawModel = (DrawModel) savedInstanceState.getSerializable("drawModel");
            drawView.reloadModel(drawModel);
            drawView.invalidate();
            radioButtonChecked = findViewById(savedInstanceState.getInt("radioID"));
//            if(radioButtonChecked != null)
            radioButtonChecked.setChecked(true);
        }
        else {
            drawModel = new DrawModel();
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("drawModel", drawModel);
        outState.putInt("radioID", radioButtonChecked.getId());

        Log.v("onSaveInstanceState", Integer.toString(radioButtonChecked.getId()));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void buildView() {
        try {

            final Toolbar toolbar = new Toolbar(this);
            toolbar.setLogo(R.mipmap.ic_launcher);
            toolbar.setTitle(R.string.app_name);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setBackgroundColor(Color.BLACK);
            toolbar.getContext().setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);


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
            lineRadio.setTag(Line.class.getName());
            lineRadio.setId(R.id.lineRadio);

            final RadioButton rectRadio = new RadioButton(this);
            rectRadio.setText("Rect");
            rectRadio.setTag(Rect.class.getCanonicalName());
            rectRadio.setId(R.id.rectRadio);

            final RadioButton pixelRadio = new RadioButton(this);
            pixelRadio.setText("Pixel");
            pixelRadio.setTag(Pixel.class.getCanonicalName());
            pixelRadio.setId(R.id.pixelRadio);

            final RadioButton circleRadio = new RadioButton(this);
            circleRadio.setText("Circle");
            circleRadio.setTag(Circle.class.getCanonicalName());
            circleRadio.setId(R.id.circleRadio);

            radioGroup.addView(lineRadio);
            radioGroup.addView(rectRadio);
            radioGroup.addView(pixelRadio);
            radioGroup.addView(circleRadio);

            buttonPanel.addView(resetButton);
            buttonPanel.addView(loadButton);
            buttonPanel.addView(saveButton);

            final LinearLayout rootPanel = new LinearLayout(this);
            rootPanel.setOrientation(LinearLayout.VERTICAL);

            final LinearLayout drawPanel = new LinearLayout(this);
            drawPanel.setBackgroundColor(Color.parseColor("#D3F2EE"));
            drawPanel.addView(drawView);

            rootPanel.addView(toolbar);
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
                    radioButtonChecked = findViewById(checkedId);
                    Log.v("RadioChecked", radioButtonChecked.getText().toString());
                }
            });


            setContentView(rootPanel);
            lineRadio.setChecked(true);
        } catch (Exception e) {
            Log.e("buildingerrors", "Error building Layout", e);
        }
    }

    private void onReset() {
        Iterator<Figure> itr = drawModel.iterator();

        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }
        drawView.reloadModel(drawModel);
        drawView.invalidate();
    }

    private void onLoad() {
        try (FileInputStream fileInputStream = openFileInput("drawingSaved.txt");
             Scanner input = new Scanner(fileInputStream)
        ) {
            drawModel.load(input);
        } catch (IOException e) {
            Log.e("IoError", "ProblemSaving", e);
        }
        drawView.reloadModel(drawModel);
        drawView.invalidate();

    }

    private void onSave() {
        try (FileOutputStream outputStream = openFileOutput("drawingSaved.txt", MODE_PRIVATE);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream))
        ) {
            drawModel.save(out);

        } catch (IOException e) {
            Log.e("IoError", "ProblemSaving", e);
        }
    }

    public Figure createSelectedFigure(int x, int y) {
        Figure figure = Figure.newInstance(radioButtonChecked.getTag().toString(), x, y);
        drawView.reloadModel(drawModel);
        return figure;
    }

}
