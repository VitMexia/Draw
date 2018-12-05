package draw.g12.li21n.poo.isel.pt.draw.Model;


import static java.lang.Math.sqrt;

public class Circle extends Figure {
    public static char LETTER = 'C';
    private int radius;

    public Circle(Point point){
        super(point);
    }

    public int getRadius() {
        int xDist = endPoint.getX() - startPoint.getX();
        int yDist = endPoint.getY() - startPoint.getY();
        radius = (int) sqrt(xDist * xDist + yDist * yDist);
        return radius;
    }

    @Override
    public void setEnd(int x, int y) {
        super.setEnd(x, y);
    }

    @Override
    public String toString() {
        return "C " + startPoint.toString() + " |" + getRadius() + "|";
    }

    // TODO: save
    // TODO: load
}
