package draw.g12.li21n.poo.isel.pt.draw.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

import draw.g12.li21n.poo.isel.pt.draw.Model.Figure;


public class Draw extends View {

    private Figure toDraw;
    private Paint brush;
    public LinkedList<Figure> ldrawables;

    public Draw(Context context){
        super(context);

        brush = new Paint();
        brush.setStrokeWidth(3);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        ldrawables = new LinkedList<>();


    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
//        canvas.save();
//
//        Iterator<Figure> itr = ldrawables.iterator();
//
//        while(itr.hasNext()) {
//            drawableToDraw(canvas, itr.next());
//        }
//
//        drawableToDraw(canvas, toDraw);
//
//        Log.v("ScreenPressed",  " Drawing2?!");
    }

//    private void drawableToDraw(Canvas canvas, Figure toDraw){
//        if(toDraw instanceof Line) {
//            canvas.drawLine(toDraw.getStart().getX(), toDraw.getStart().getY(), toDraw.getEndPoint().getLine(), toDraw.getEndPoint().getCol(), brush);
//        }
//        else if(toDraw instanceof Circle){
//            canvas.drawCircle(toDraw.getStart().getX(), toDraw.getStart().getY(), toDraw.getRadius(), brush);
//        }
//        else if(toDraw instanceof Rect){
//            canvas.drawRect(toDraw.getStart().getX(), toDraw.getStart().getY(), toDraw.getEndPoint().getLine(), toDraw.getEndPoint().getCol(), brush);
//        }
//        else if(toDraw instanceof Pixel){
//            brush.setStrokeWidth(9);
//            canvas.drawPoint(toDraw.endPoint.getX(), toDraw.endPoint.getY(), brush);
//            brush.setStrokeWidth(3);
//        }
//    }

    public void repaint(Figure drawable){
        this.toDraw = drawable;

        this.invalidate();
        Log.v("ScreenPressed",  " Invalidate?!");
    }


}
