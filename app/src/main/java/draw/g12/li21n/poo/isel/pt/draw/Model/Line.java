package draw.g12.li21n.poo.isel.pt.draw.Model;


public class Line extends Drawables {

    public Line(Position position){
        super(position);
    }


    @Override
    public String toString() {
        return "L " + startPosition.toString() + " " + endPosition.toString();
    }
}
