package draw.g12.li21n.poo.isel.pt.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Draw extends View {

    private String drawType;

    private Position startPosition;
    private Position endPosition;
    private Paint brush;

    public Draw(Context context){
        super(context);
        setDrawType("Line");
        brush = new Paint();
        brush.setStrokeWidth(3);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        setWillNotDraw(false);
        startPosition = new Position(0,0);
        endPosition = new Position(0,0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.v("ScreenPressed",  " Drawing1?!");
        super.onDraw(canvas);

        float radius = getRadius();

        canvas.drawLine(startPosition.getLine(), startPosition.getCol(), endPosition.getLine(),endPosition.getCol(), brush);
        canvas.drawCircle(startPosition.getLine(),startPosition.getCol(),radius, brush );
        canvas.drawRect(startPosition.getLine(), startPosition.getCol(), endPosition.getLine(),endPosition.getCol(), brush);
        Log.v("ScreenPressed",  " Drawing2?!");
    }

    private float getRadius() {

        float xlength = abs(startPosition.getLine() - endPosition.getLine());
        float ylength = abs(startPosition.getCol() - endPosition.getCol());

        return (float)sqrt(xlength*xlength + ylength*ylength);

    }

    public void repaint(){
//        endPosition = newPos;
        this.invalidate();
        Log.v("ScreenPressed",  " Invalidate?!");
    }

    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }


    public void setStartPosition(Position startPos) {
        this.startPosition = startPos;

    }

    public void setEndPosition(Position endPos) {

        this.endPosition = endPos;
        Log.v("ScreenPressed", Float.toString(startPosition.getLine()) + ", " + Float.toString(startPosition.getCol()) + " Painting - startPos");
        Log.v("ScreenPressed", Float.toString(endPos.getLine()) + ", " + Float.toString(endPos.getCol()) + " Painting - EdnPos");
//        repaint();
        this.invalidate();
    }



  //  public void setBrush(Paint brush) {
//        this.brush = brush;
//    }


}
