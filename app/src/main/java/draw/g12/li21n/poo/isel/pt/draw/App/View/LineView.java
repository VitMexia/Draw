package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public class LineView extends FigureView {

    LineView(Figure figure){
        super(figure);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawLine(figure.getStart().getX(), figure.getStart().getY(),
                    figure.getEnd().getX(), figure.getEnd().getY(), paint());
    }
}
