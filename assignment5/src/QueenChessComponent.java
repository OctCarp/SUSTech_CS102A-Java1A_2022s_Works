import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'Q';
        } else {
            this.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
