package draw.g12.li21n.poo.isel.pt.draw.App.Model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Pixel extends Figure {

    public static char LETTER = 'P';

    public Pixel(){}

    public Pixel(int x, int y) {
        super(x,y);
//        dListener.PointCreated(x,y);
    }

    protected char getLetter(){
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
//        dListener.EndPointChanged(x, y);
        startPoint = new Point(x,y);
    }

    @Override
    public void save(PrintWriter out){
        out.append(this.LETTER + " " + startPoint.toString());
        out.close();
    }
    @Override
    public void load(Scanner in) {

        // TODO: load
    }
}
