package draw.g12.li21n.poo.isel.pt.draw.Model;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DrawProvider implements DrawType {

    @Override
    public Drawables getDrawable(String type, Position position) {
        type = this.getClass().getPackage().getName() + "." + type; // convert to canonical name

        Constructor<?> constructor = null;
        try {
            constructor = Class.forName(type).getConstructor(position.getClass());
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            Log.e("Draw", "Error loading constructor for class " + type, e);
        }
        Object obj = null;
        try {
            obj = constructor.newInstance(position);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("Draw", "Error instantiating " + type, e);
        }
        return (Drawables) obj;
    }
}
