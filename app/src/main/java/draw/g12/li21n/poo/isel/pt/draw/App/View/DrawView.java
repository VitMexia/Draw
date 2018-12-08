package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import draw.g12.li21n.poo.isel.pt.draw.App.DrawController;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.DrawModel;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.Figure;

public class DrawView extends View {

    DrawController drawController;
    FigureView figureView;
    Figure figure;

    public DrawView(DrawController drawController){
        super(drawController);
        this.drawController = drawController;
    }
    boolean pushed = false;

    public void reloadModel(DrawModel model){


    }
//    public DrawView(Context context) {
//        super(context);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(figureView != null)
            figureView.draw(canvas);

    } //TODO:UML has this as package access



    @Override
    public boolean onTouchEvent(MotionEvent event){
        final int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            Log.v("DrawDebug", "Down");
            pushed  = true;
            figure = drawController.createSelectedFigure((int)event.getX(), (int) event.getY());
            figureView = FigureView.newInstance(figure);

        }
        else if(action == MotionEvent.ACTION_UP){
            Log.v("DrawDebug", "Up");
            pushed  = false;

            //  draw.ldrawables.add(toDraw);

        }
        else if(pushed && action == MotionEvent.ACTION_MOVE){

            figure.setEnd((int)event.getX(), (int) event.getY());
            invalidate();


            Log.v("DrawDebug", "Moving");

        }
        return true;
    }
}
