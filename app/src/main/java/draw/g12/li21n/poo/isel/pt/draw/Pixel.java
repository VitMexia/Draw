package draw.g12.li21n.poo.isel.pt.draw;

public class Pixel extends Drawables {
    public Pixel(Position position) {
        super(position);

    }


    @Override
    public String toString() {
        return "P " + endPosition.toString();
    }
}
