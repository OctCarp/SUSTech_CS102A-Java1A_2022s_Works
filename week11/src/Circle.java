

public class Circle extends Shape {
    private double radius;
    private static final int DEFAULT_RADIUS = 5;

    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
    }

    public Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }

    public Circle(double x, double y) {
        super(x, y);
        this.radius = DEFAULT_RADIUS;
    }


    public void checkColor() {
        if (isInBoundary()) {
            color = ShapeColor.GREEN;
        } else {
            color = ShapeColor.RED;
        }
    }

    public boolean isInBoundary() {
        if (-1 * Shape.getScreenSize() > x - this.radius || Shape.getScreenSize() < x + this.radius) {
            return false;
        }
        if (-1 * Shape.getScreenSize() > x - this.radius || Shape.getScreenSize() < x + this.radius) {
            return false;
        }
        return true;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + " x=" + x +
                ", y=" + y +
                ", color=" + color +
                "}\n";
    }

    public void draw() {
        StdDraw.setPenColor(color.getColor());
        StdDraw.filledCircle(x, y, radius);
    }
}
