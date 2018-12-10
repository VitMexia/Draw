package draw.g12.li21n.poo.isel.pt.draw.View;

import android.graphics.Canvas;

import draw.g12.li21n.poo.isel.pt.draw.Model.Figure;
import draw.g12.li21n.poo.isel.pt.draw.Model.Line;

public class RectView extends FigureView {
    RectView(Figure figure){
        super(figure);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawRect(figure.getStart().getX(), figure.getStart().getY(),
                ((Line)figure).getEnd().getX(), ((Line)figure).getEnd().getY(), paint);


    }
}
