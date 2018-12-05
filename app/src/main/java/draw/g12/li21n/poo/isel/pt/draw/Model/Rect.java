package draw.g12.li21n.poo.isel.pt.draw.Model;


public class Rect extends Line {

    public static char LETTER = 'R';

    public Rect(Point point) {
        super(point);
    }

    @Override
    public String toString() {
        return "R " + startPoint.toString() + " " + endPoint.toString();
    }
}
