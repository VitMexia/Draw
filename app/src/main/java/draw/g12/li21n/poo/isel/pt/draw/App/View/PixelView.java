package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;


public class PixelView extends FigureView {

    PixelView(Figure figure){
        super(figure);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawPoint(figure.getStart().getX(), figure.getStart().getY(), paint());
    }

}
