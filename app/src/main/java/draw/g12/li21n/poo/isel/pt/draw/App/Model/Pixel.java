package draw.g12.li21n.poo.isel.pt.draw.App.Model;

public class Pixel extends Figure {

    public static char LETTER = 'P';

    public Pixel() {
        super();
    }

    public Pixel(int x, int y) {
        super(x,y);
    }

    @Override
    public void setEnd(int x, int y) {
        startPoint = new Point(x, y);
    }

    protected char getLetter(){
        return LETTER;
    }

}
