package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public abstract class FigureView {

    Figure figure;
    Paint paint;

    FigureView(Figure figure){
        //TODO:FigureView

        this.figure =figure;
        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        init(figure);
    }

//    Paint paint(){
//        //TODO:paint
//        return null;
//    }

    abstract void draw(Canvas canvas);

    static FigureView newInstance(Figure figure){

        //TODO:FigureView
        String type = figure.getClass().getName() + "View";
        type = type.replace("Model", "View");

        Constructor<?> constructor = null;
        try {
            constructor = Class.forName(type).getConstructor(Figure.class);
        }
        catch (NoSuchMethodException | ClassNotFoundException e)
        {
            Log.e("DrawDebug", "Error loading constructor for class " + type, e);
        }
        FigureView figureView = null;

        try {
            figureView = (FigureView)constructor.newInstance(figure);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("DrawDebug", "Error loading class " + type, e);
        }


       return figureView;
    }

    private void init(final Figure figure){

        Figure.FigureListener listener = new Figure.FigureListener() {
            @Override
            public void EndPointChanged(int x, int y) {
                //TODO: EndPointChanged
            }

            @Override
            public void PointCreated(int x, int y){
                //TODO: PointCreated
            }
        };

        figure.setListener(listener);


    }

}
