package draw.g12.li21n.poo.isel.pt.draw.Model;


public class Circle extends Drawables {


    public Circle(Position position){
        super(position);
    }


    @Override
    public String toString() {
        return "C " + startPosition.toString() + " |" + radius + "|" ;
    }
}
