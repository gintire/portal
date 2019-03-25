package java8test.ch8;

import java.util.Arrays;
import java.util.List;

public class testStackTrace {
     public static void main(String[] args) {
         List<Point> points = Arrays.asList(new Point(12, 2), null);
         points.stream().map(p->p.getX()).forEach(System.out::println);
     }
}

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
