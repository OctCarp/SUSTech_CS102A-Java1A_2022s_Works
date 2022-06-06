public class Shape {
    protected double x;
    protected double y;
    protected ShapeColor color = ShapeColor.GRAY;
    private static int screenSize = 10;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public ShapeColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return " x=" + x + ", y=" + y + ", color=" + color;
    }

}
