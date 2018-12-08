package draw.g12.li21n.poo.isel.pt.draw.App.Model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DrawModel {
    private List<Figure> figures;

    public DrawModel() {
        figures = new ArrayList<>();
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    public void save(PrintWriter out){
        for (Figure figure : figures) {
            figure.save(out);
            out.println();
        }
    }
    public void load(Scanner in) {
        for (Figure figure : figures) {
            figure.load(in);
        }
    }

    public Iterator<Figure> iterator() {
        return figures.iterator();
    }
}
