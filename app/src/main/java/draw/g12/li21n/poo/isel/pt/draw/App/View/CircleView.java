package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;

import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public class CircleView extends FigureView {

    CircleView(Figure figure){
        super(figure);
    }

    @Override
    void draw(Canvas canvas) {
        //canvas.drawCircle(figure.getStart().getX(), figure.getStart().getY(), figure.getRadius(), paint());
        //TODO:HOw the hell do we getRadius() from the figure????
    }
}
