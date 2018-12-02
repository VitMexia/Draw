package draw.g12.li21n.poo.isel.pt.draw;

public class Pixel extends Drawables {
    public Pixel(Position position) {
        super(position);

    }

    @Override
    public void setEndPosition(Position pos){
        this.endPosition = pos;
        dListener.EndPositionChanged(pos);
    };
}
