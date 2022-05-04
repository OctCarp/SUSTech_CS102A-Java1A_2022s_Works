import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'R';
        } else {
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
