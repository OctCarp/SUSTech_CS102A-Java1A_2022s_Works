import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    ChessComponent[][] chessboard = super.getChessboard();

    ChessboardPoint source = super.getSource();

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public EmptySlotComponent(ChessColor color) {
        super(color);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}