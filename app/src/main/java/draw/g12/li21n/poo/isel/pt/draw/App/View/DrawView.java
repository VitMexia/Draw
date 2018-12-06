package draw.g12.li21n.poo.isel.pt.draw.App.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import draw.g12.li21n.poo.isel.pt.draw.App.DrawController_old;

public class DrawView extends View {

    DrawView(DrawController_old drawController){
        super(drawController);

    }

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
