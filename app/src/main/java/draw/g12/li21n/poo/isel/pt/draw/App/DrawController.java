package draw.g12.li21n.poo.isel.pt.draw.App;


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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Circle;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.DrawModel;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Line;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Pixel;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Rect;
import draw.g12.li21n.poo.isel.pt.draw.App.View.DrawView;


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

        if (savedInstanceState != null) {
            drawModel = (DrawModel) savedInstanceState.getSerializable("teste");
            drawView.reloadModel(drawModel);
            drawView.invalidate();
        } else
            drawModel = new DrawModel();

        buildView();


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("teste", drawModel);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void buildView() {
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
            lineRadio.setTag(Line.class.getName());

            final RadioButton rectRadio = new RadioButton(this);
            rectRadio.setText("Rect");
            rectRadio.setTag(Rect.class.getCanonicalName());

            final RadioButton pixelRadio = new RadioButton(this);
            pixelRadio.setText("Pixel");
            pixelRadio.setTag(Pixel.class.getCanonicalName());

            final RadioButton circleRadio = new RadioButton(this);
            circleRadio.setText("Circle");
            circleRadio.setTag(Circle.class.getCanonicalName());

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
                    radioButtonChecked = findViewById(checkedId);
                    Log.v("RadioChecked", radioButtonChecked.getText().toString());
                }
            });

            setContentView(rootPanel);
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
