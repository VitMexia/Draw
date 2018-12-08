package draw.g12.li21n.poo.isel.pt.draw.App.Model;


import android.util.Log;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public abstract class Figure {

    private static final Map<Character, String> figureMap;
    protected Point startPoint;

    // TODO: Verificar alternativas a inicialização estática
    static {
        figureMap = new HashMap<>();
        figureMap.put(Line.LETTER, Objects.requireNonNull(Line.class.getCanonicalName()));
        figureMap.put(Rect.LETTER, Objects.requireNonNull(Rect.class.getCanonicalName()));
        figureMap.put(Circle.LETTER, Objects.requireNonNull(Circle.class.getCanonicalName()));
        figureMap.put(Pixel.LETTER, Objects.requireNonNull(Pixel.class.getCanonicalName()));
    }


    protected FigureListener dListener;

    public interface FigureListener {
        void EndPointChanged(int x, int y);
        void PointCreated(int x, int y);
    }


    public abstract void save(PrintWriter out) ; //TODO:save - abstract?
    public abstract void load(Scanner in); // TODO: load - abstract?
    public abstract void setEnd(int x, int y);


    public Figure(){}

    public Figure(int x, int y){
        startPoint = new Point(x,y);
    }

//    public Figure(Point point){
//        if (point == null)
//            throw new IllegalArgumentException();
//        startPoint = point;
//        //endPoint = point;
//    }

    public void setListener(FigureListener figureListener) {
        this.dListener = figureListener;
        dListener.PointCreated(startPoint.getX(), startPoint.getY());
    }

    public static Figure newInstance(String type, Point point) {

        type = Objects.requireNonNull(Figure.class.getPackage()).getName() + "." + type; // convert to canonical name

         Constructor<?> constructor = null;
         try {
             constructor = Class.forName(type).getConstructor(point.getClass());
         }
         catch (NoSuchMethodException | ClassNotFoundException e)
         {
             Log.e("DrawDebug", "Error loading constructor for class " + type, e);
         }
         Object obj = null;
         try {
             assert constructor != null;
             obj = constructor.newInstance(point);
         }
         catch (IllegalAccessException | InstantiationException | InvocationTargetException e)
         {
             Log.e("DrawDebug", "Error instantiating " + type, e);
         }
         return (Figure) obj;
     }

    public static Figure newInstance(String type) {

        type = Objects.requireNonNull(Figure.class.getPackage()).getName() + "." + type; // convert to canonical name

        Class figure = null;
        try {
            figure = Class.forName(type);
        }
        catch (ClassNotFoundException e)
        {
            Log.e("DrawDebug", "Error loading class " + type, e);
        }

        Figure obj = null;
        try {
            assert figure != null;
            obj = (Figure) figure.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            Log.e("DrawDebug", "Error instantiating " + type, e);
        }

        return obj;
    }

    public static Figure newInstance(String type, int x, int y) {
        Point point = new Point(x, y);
        return Figure.newInstance(type, point);
    }

    public static Figure newInstance(char letter) {
        return newInstance(figureMap.get(letter));
    }



    public Point getStart() {
        return startPoint;
    }
}
