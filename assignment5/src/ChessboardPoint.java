public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        int a = x + dx;
        int b = y + dy;
        if (a < 0 || a > 7 || b < 0 || b > 7) {
            return null;
        } else return new ChessboardPoint(a, b);
    }

}
