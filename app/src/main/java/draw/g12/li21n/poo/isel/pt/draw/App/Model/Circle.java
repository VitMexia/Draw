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

    public Circle() {
        super();
    }
    @Override
    public void setEnd(int x, int y) {
        super.setEnd(x, y);
        int xDist = x - startPoint.getX();
        int yDist = y - startPoint.getY();
        this.radius = (int) sqrt(xDist * xDist + yDist * yDist);
    }

    protected char getLetter(){
        return LETTER;
    }

    @Override
    public void save(PrintWriter out){
        super.save(out);
        out.append(" |" + radius + "|");
    }
    @Override
    public void load(Scanner in) {
        super.load(in);
        String[] splt = in.next().trim().split("\\|");
        radius = Integer.parseInt(splt[1]);
    }

    public int getRadius(){
        return radius;
    }

}
