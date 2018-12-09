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
    protected Point startPoint, endPoint;

    // TODO: Verificar alternativas a inicialização estática
    static {
        figureMap = new HashMap<>();
        figureMap.put(Line.LETTER, Objects.requireNonNull(Line.class.getCanonicalName()));
        figureMap.put(Rect.LETTER, Objects.requireNonNull(Rect.class.getCanonicalName()));
        figureMap.put(Circle.LETTER, Objects.requireNonNull(Circle.class.getCanonicalName()));
        figureMap.put(Pixel.LETTER, Objects.requireNonNull(Pixel.class.getCanonicalName()));
    }

    public interface FigureListener {
        void EndPointChanged(int x, int y);
        void PointCreated(int x, int y);
    }

    public void save(PrintWriter out) {
        out.append(getLetter());
        startPoint.save(out);
    }

    public void load(Scanner in) {
        String[] args = in.next().trim().split("[,()]");
        // Args[0] empty due to splitting on "("
        setStart(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    public void setEnd(int x, int y) {
        endPoint = new Point(x, y);
    }

    public Figure(){}

    public Figure(int x, int y){
        startPoint = new Point(x,y);
    }

    protected abstract char getLetter();

    public static Figure newInstance(String type, Point point) {
        return Figure.newInstance(type, point.getX(), point.getY());

     }

    public static Figure newInstance(String type) {
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
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName(type).getConstructor(int.class, int.class);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            Log.e("DrawDebug", "Error loading constructor for class " + type, e);
        }
        Object obj = null;
        try {
            assert constructor != null;
            obj = constructor.newInstance(x, y);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("DrawDebug", "Error instantiating " + type, e);
        }
        return (Figure) obj;
    }

    public static Figure newInstance(char letter) {
        return newInstance(figureMap.get(letter));
    }

    protected void setStart(int x, int y) {
        this.startPoint = new Point(x, y);
    }

    public Point getStart() {
        return startPoint;
    }
}
