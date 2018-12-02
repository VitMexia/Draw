package draw.g12.li21n.poo.isel.pt.draw;

public class DrawProvider implements DrawType{

    @Override
    public Drawables getDrawable(String type, Position position) {
        if(type== "Line"){
            Line line = new Line(position);
           // dlist.add(line);
            return line;
        }else if (type== "Circle"){
            Circle circle = new Circle(position);
          //  dlist.add(circle);
            return circle;
        }
        else if (type== "Pixel"){
            Pixel pixel = new Pixel(position);
            //  dlist.add(circle);
            return pixel;
        }
        else if (type== "Rect"){
            Rectangular rect = new Rectangular(position);
            //  dlist.add(circle);
            return rect;
        }
        return null;
    }
}
