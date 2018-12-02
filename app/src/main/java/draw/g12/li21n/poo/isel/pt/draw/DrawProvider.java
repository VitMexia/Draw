package draw.g12.li21n.poo.isel.pt.draw;

public class DrawProvider implements DrawType{

    @Override
    public Drawables getDrawable(String type, Position position) {
        if(type== "Line"){
            return new Line(position);
        }
        else if (type== "Circle"){
            return new Circle(position);
        }
        else if (type== "Pixel"){
            return new Pixel(position);
        }
        else if (type== "Rect"){
            return new Rectangular(position);
        }
        return null;
    }
}
