package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public abstract class FigureView {

    Figure figure;

    FigureView(Figure figure){
        //TODO:FigureView

        this.figure =figure;
        init(figure);
    }

    protected Paint paint(){
        //TODO:paint
        return null;
    }

    abstract void draw(Canvas canvas);

    static FigureView newInstance(Figure figure){
        //TODO:FigureView
        String type = figure.getClass().getName() + "View";

        Class figureView = null;

        try {
            figureView = Class.forName(type);
        } catch (ClassNotFoundException e) {
            Log.e("Draw", "Error loading class " + type, e);
        }

        FigureView obj = null;
        try {
            assert figureView != null;
            obj = (FigureView) figureView.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            Log.e("Draw", "Error instantiating " + type, e);
        }

        return obj;
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
