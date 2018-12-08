package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import draw.g12.li21n.poo.isel.pt.draw.App.DrawController;
import draw.g12.li21n.poo.isel.pt.draw.App.Model.DrawModel;

public class DrawView extends View {

    DrawView(DrawController drawController){
        super(drawController);

    }
    boolean pushed = false;

    public void reloadModel(DrawModel model){


    }
    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    } //TODO:UML has this as package access



    @Override
    public boolean onTouchEvent(MotionEvent event){
        final int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            Log.v("ScreenPressed", "Down");
            pushed  = true;
//                        toDraw = new DrawProvider().getDrawable(radioButtonChecked.getText().toString() ,new Point(event.getX(), event.getY()));
//                        init(toDraw);


        }
        else if(action == MotionEvent.ACTION_UP){
            Log.v("ScreenPressed", "Up");
            pushed  = false;
            //  draw.ldrawables.add(toDraw);

        }
        else if(pushed && action == MotionEvent.ACTION_MOVE){
//                        toDraw.setEnd(new Point(event.getX(), event.getY()));
            Log.v("ScreenPressed", "Moving");

        }
        return true;
    }
}
