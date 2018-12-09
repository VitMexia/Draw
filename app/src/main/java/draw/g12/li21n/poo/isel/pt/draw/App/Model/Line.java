package draw.g12.li21n.poo.isel.pt.draw.App.Model;


import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static final char LETTER = 'L';

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
    public void save(PrintWriter out){
        super.save(out);
        endPoint.save(out);
    }
    @Override
    public void load(Scanner in) {
        super.load(in);
        String[] args = in.next().trim().split("[,()]");
        // Args[0] empty due to splitting on "("
        setEnd(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
}
