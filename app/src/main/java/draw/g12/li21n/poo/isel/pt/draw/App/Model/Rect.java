package draw.g12.li21n.poo.isel.pt.draw.App.Model;


public class Rect extends Line {

    public static char LETTER = 'R';

    public Rect(int x, int y) {
        super(x,y);
    }

    protected char getLetter(){
        return LETTER;
    }

}
