package draw.g12.li21n.poo.isel.pt.draw.Model;

public class Point {

    private int x, y;

    public Point(int x, int col) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + Float.toString(getX()) + ", " + Float.toString(getY()) + ")";
    }

    // TODO: save
    // TODO: load
}
