package draw.g12.li21n.poo.isel.pt.draw.App.Model;


public class Line extends Figure {

    public static char LETTER = 'L';

    public Line(Point point){
        super(point);
    }

    public Line(){
        super();
    }

    public Point getEnd() {
        return endPoint;
    }

    @Override
    public String toString() {
        return "L " + startPoint.toString() + " " + endPoint.toString();
    }

    // TODO: save
    // TODO: load
}
