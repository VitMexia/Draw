package draw.g12.li21n.poo.isel.pt.draw.App.Model;


import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static char LETTER = 'L';
    protected Point endPoint;

    public Line(int x, int y){
        super(x,y);
    }

    public Line(){
        super();
    }

    public Point getEnd() {
        return endPoint;
    }

    protected char getLetter(){
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        dListener.EndPointChanged(x, y);
        endPoint = new Point(x,y);
    }

    @Override
    public void save(PrintWriter out){
        out.append(this.LETTER + " " + startPoint.toString() + " " + endPoint.toString());
        out.close();
    }
    @Override
    public void load(Scanner in) {

        // TODO: load
    }
}
