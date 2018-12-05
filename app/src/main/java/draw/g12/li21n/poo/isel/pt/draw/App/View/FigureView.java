package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;
import android.graphics.Paint;

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
        return null;
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
