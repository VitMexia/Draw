package draw.g12.li21n.poo.isel.pt.draw;

public class Rectangular extends Drawables {

    public Rectangular(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "R " + startPosition.toString() + " " + endPosition.toString();
    }
}
