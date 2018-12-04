package draw.g12.li21n.poo.isel.pt.draw.Model;


public class Circle extends Figure {


    public Circle(Point point){
        super(point);
    }


    @Override
    public String toString() {
        return "C " + startPoint.toString() + " |" + radius + "|" ;
    }
}
