package draw.g12.li21n.poo.isel.pt.draw.App.Model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point {

    private int x, y;

    public Point(int x, int y) {
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

    public void save(PrintWriter out){
        //TODO:save
    }
    public void load(Scanner in) {
        // TODO: load
    }

}
