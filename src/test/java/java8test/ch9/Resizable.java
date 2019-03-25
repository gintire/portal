package java8test.ch9;

public interface Resizable extends Drawable{
    int getWidth();
    default int getHeight(){return 0;}
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
}
