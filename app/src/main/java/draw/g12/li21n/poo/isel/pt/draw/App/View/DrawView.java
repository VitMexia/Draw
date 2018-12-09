package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Iterator;
import java.util.LinkedList;

import draw.g12.li21n.poo.isel.pt.draw.App.DrawController;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.DrawModel;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public class DrawView extends View {

    DrawController drawController;
    FigureView figureView;
    Figure figure;
    private LinkedList<FigureView> reloadFigure;
    DrawModel drawModel;

    public DrawView(DrawController drawController) {
        super(drawController);
        this.drawController = drawController;
        reloadFigure = new LinkedList<>();
    }

    public void reloadModel(DrawModel model) {
        this.drawModel = model;
        if (reloadFigure != null) reloadFigure.clear();

        Iterator<Figure> itr = drawModel.iterator();

        while (itr.hasNext()) {
            reloadFigure.add(FigureView.newInstance(itr.next()));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (reloadFigure != null) {
            for (FigureView f : reloadFigure) {
                f.draw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v("DrawDebug", "Down");
                figure = drawController.createSelectedFigure((int) event.getX(), (int) event.getY());
                figureView = FigureView.newInstance(figure);
                drawModel.add(figure);
                reloadFigure.add(figureView);
                break;
            case MotionEvent.ACTION_UP:
                Log.v("DrawDebug", "Up");
            case MotionEvent.ACTION_MOVE:
                figure.setEnd((int) event.getX(), (int) event.getY());
                invalidate();
                Log.v("DrawDebug", "Moving");
                break;
        }
        return true;
    }
}
