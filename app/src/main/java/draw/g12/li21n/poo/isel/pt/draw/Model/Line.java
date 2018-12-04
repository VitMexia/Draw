package draw.g12.li21n.poo.isel.pt.draw.Model;


public class Line extends Figure {

    public static final char LETTER = 'L';

    public Line(Point point){
        super(point);
    }

    public Line(){

    }




    @Override
    public String toString() {
        return "L " + startPoint.toString() + " " + endPoint.toString();
    }
}
