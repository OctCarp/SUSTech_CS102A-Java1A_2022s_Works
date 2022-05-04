import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'P';
        } else {
            this.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
