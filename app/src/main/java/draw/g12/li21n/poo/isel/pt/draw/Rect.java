package draw.g12.li21n.poo.isel.pt.draw;

public class Rect extends Drawables {

    public Rect(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "R " + startPosition.toString() + " " + endPosition.toString();
    }
}
