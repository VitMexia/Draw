package draw.g12.li21n.poo.isel.pt.draw;


import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public abstract class Drawables {

    public interface DrawableListener {
        void EndPositionChanged(Position endPos);
        void PointCreated(Position position);
    }
    protected DrawableListener dListener;

    protected Position startPosition;
    protected Position endPosition;
    protected float radius;


    public Drawables(Position position){
        if (position == null)
            throw new IllegalArgumentException();
        this.startPosition = position;
        this.endPosition = position;
    }


    public void setListener(DrawableListener drawableListener) {
        this.dListener = drawableListener ;
        dListener.PointCreated(startPosition);
    }

    public void setEndPosition(Position pos){
        this.endPosition = pos;
        dListener.EndPositionChanged(pos);
    };

    public void setStartPosition(Position pos) {
        this.startPosition = pos;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public Position getStartPosition(){
        return startPosition;
    }

    public float getRadius(){
        float xlength = abs(startPosition.getLine() - endPosition.getLine());
        float ylength = abs(startPosition.getCol() - endPosition.getCol());

        this.radius = (float)sqrt(xlength*xlength + ylength*ylength);
        return radius;
    }
}
