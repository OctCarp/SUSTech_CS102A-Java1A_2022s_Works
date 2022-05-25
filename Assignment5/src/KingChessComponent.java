import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KingChessComponent extends ChessComponent {
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
        List<ChessboardPoint> can = new ArrayList<>();
        int x = source.getX(), y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(i - x) == 1 && Math.abs(j - y) == 1) ||
                        (Math.abs(i - x) == 0 && Math.abs(j - y) == 1) ||
                        (Math.abs(i - x) == 1 && Math.abs(j - y) == 0)) {
                    if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                        can.add(source.offset(i - x, j - y));
                    }
                }
            }
        }
        can.removeIf(Objects::isNull);
        return can;
    }
}