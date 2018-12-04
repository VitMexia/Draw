package draw.g12.li21n.poo.isel.pt.draw.Model;

public class Pixel extends Figure {
    public Pixel(Point point) {
        super(point);

    }


    @Override
    public String toString() {
        return "P " + endPoint.toString();
    }
}
