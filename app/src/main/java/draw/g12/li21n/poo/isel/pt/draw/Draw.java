package draw.g12.li21n.poo.isel.pt.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Iterator;
import java.util.LinkedList;

import draw.g12.li21n.poo.isel.pt.draw.Model.Circle;
import draw.g12.li21n.poo.isel.pt.draw.Model.Drawables;
import draw.g12.li21n.poo.isel.pt.draw.Model.Line;
import draw.g12.li21n.poo.isel.pt.draw.Model.Pixel;
import draw.g12.li21n.poo.isel.pt.draw.Model.Rect;


public class Draw extends View {

    private Drawables toDraw;
    private Paint brush;
    public LinkedList<Drawables> ldrawables;

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
        Iterator<Drawables> itr = ldrawables.iterator();

        while(itr.hasNext()) {
            drawableToDraw(canvas, itr.next());
        }

        drawableToDraw(canvas, toDraw);

        Log.v("ScreenPressed",  " Drawing2?!");
    }

    private void drawableToDraw(Canvas canvas, Drawables toDraw){
        if(toDraw instanceof Line) {
            canvas.drawLine(toDraw.getStartPosition().getLine(), toDraw.getStartPosition().getCol(), toDraw.getEndPosition().getLine(), toDraw.getEndPosition().getCol(), brush);
        }
        else if(toDraw instanceof Circle){
            canvas.drawCircle(toDraw.getStartPosition().getLine(),toDraw.getStartPosition().getCol(),toDraw.getRadius(), brush );
        }
        else if(toDraw instanceof Rect){
            canvas.drawRect(toDraw.getStartPosition().getLine(), toDraw.getStartPosition().getCol(), toDraw.getEndPosition().getLine(), toDraw.getEndPosition().getCol(), brush);
        }
        else if(toDraw instanceof Pixel){
            brush.setStrokeWidth(9);
            canvas.drawPoint(toDraw.endPosition.getLine(), toDraw.endPosition.getCol(), brush);
            brush.setStrokeWidth(3);
        }
    }

    public void repaint(Drawables drawable){
        this.toDraw = drawable;

        this.invalidate();
        Log.v("ScreenPressed",  " Invalidate?!");
    }


}
