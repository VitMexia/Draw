package draw.g12.li21n.poo.isel.pt.draw.Model;

public class Point {

    private float col;
    private float line;

    public Point(float line, float col){
        this.col = col;
        this.line = line;
    }

    public float getCol() {
        return col;
    }

    public float getLine() {
        return line;
    }

    public void setCol(float col) {
        this.col = col;
    }

    public void setLine(float line) {
        this.line = line;
    }


    @Override
    public String toString() {
        return "("+ Float.toString(getLine()) + ", " + Float.toString(getCol()) + ")";
    }
}