package draw.g12.li21n.poo.isel.pt.draw.View;

import android.graphics.Canvas;
import android.graphics.Paint;

import draw.g12.li21n.poo.isel.pt.draw.Model.Figure;

public abstract class FigureView {

    FigureView(Figure figure){
        //TODO:FigureView
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

}
