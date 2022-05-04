import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
