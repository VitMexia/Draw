package draw.g12.li21n.poo.isel.pt.draw.App.Model;


import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Circle extends Figure {
    public static char LETTER = 'C';
    private int radius;

    public Circle(int x, int y){
        super(x,y);
    }

    @Override
    public void setEnd(int x, int y) {
        int xDist = x - startPoint.getX();
        int yDist = y - startPoint.getY();
        this.radius = (int) sqrt(xDist * xDist + yDist * yDist);
    }

    protected char getLetter(){
        return LETTER;
    }

    @Override
    public void save(PrintWriter out){
        out.append(this.LETTER + " " + startPoint.toString() + " |" + radius + "|");
        out.close();
    }
    @Override
    public void load(Scanner in) {

        // TODO: load
    }

    public int getRadius(){
        return radius;
    }


}
