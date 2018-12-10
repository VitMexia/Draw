package draw.g12.li21n.poo.isel.pt.draw.Model;

public class Rect extends Line {

    public static char LETTER = 'R';

    public Rect(int x, int y) {
        super(x,y);
    }

    public Rect() {
        super();
    }

    protected char getLetter(){
        return LETTER;
    }
}
