package draw.g12.li21n.poo.isel.pt.draw.App.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawModel {
    private List<Figure> figures;

    public DrawModel() {
        figures = new ArrayList<>();
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    // TODO: save
    // TODO: load

    public Iterator<Figure> iterator() {
        // TODO: iterator
        return null;
    }
}
