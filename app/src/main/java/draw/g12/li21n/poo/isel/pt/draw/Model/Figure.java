package draw.g12.li21n.poo.isel.pt.draw.Model;


import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public abstract class Figure {

    public interface FigureListener {
        void EndPointChanged(Point endPos);
        void PointCreated(Point point);
    }
    protected FigureListener dListener;

    public Point startPoint;
    public Point endPoint;
    public float radius;

    public Figure(){}

    public Figure(Point point){

        if (point == null)
            throw new IllegalArgumentException();
        this.startPoint = point;
        this.endPoint = point;
    }


    public void setListener(FigureListener figureListener) {
        this.dListener = figureListener;
        dListener.PointCreated(startPoint);
    }

    public void setEndPoint(Point pos){
        this.endPoint = pos;
        dListener.EndPointChanged(pos);
    };

    public void setStartPoint(Point pos) {
        this.startPoint = pos;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getStartPoint(){
        return startPoint;
    }

    public float getRadius(){
        float xlength = abs(startPoint.getLine() - endPoint.getLine());
        float ylength = abs(startPoint.getCol() - endPoint.getCol());

        this.radius = (float)sqrt(xlength*xlength + ylength*ylength);
        return radius;
    }

     public static Figure newInstance(String type, int x, int y) {

         Point point = new Point(x, y);

         return Figure.newInstance(type, point);
     }

    private static Figure newInstance(String type, Point point) {

             type = Figure.class.getPackage().getName() + "." + type; // convert to canonical name

             Constructor<?> constructor = null;
             try {
                 constructor = Class.forName(type).getConstructor(point.getClass());
             } catch (NoSuchMethodException | ClassNotFoundException e) {
                 Log.e("Draw", "Error loading constructor for class " + type, e);
             }
             Object obj = null;
             try {
                 obj = constructor.newInstance(point);
             } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                 Log.e("Draw", "Error instantiating " + type, e);
             }
             return (Figure) obj;
         }


}
