package draw.g12.li21n.poo.isel.pt.draw.App.Model;

public class Pixel extends Figure {
    public static char LETTER = 'P';

    public Pixel(Point point) {
        super(point);
    }

    @Override
    public String toString() {
        return "P " + endPoint.toString();
    }

    // TODO: save
    // TODO: load
}
