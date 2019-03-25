package java8test.ch9;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
class Utils {
    public static void paint(List<Resizable> l) {
        l.forEach(r ->{
            r.setAbsoluteSize(42, 42);
            r.draw();
        });
    }
}