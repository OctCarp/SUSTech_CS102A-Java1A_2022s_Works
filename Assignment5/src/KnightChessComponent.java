import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent {
    ChessComponent[][] chessboard;
    ChessboardPoint source = super.getSource();

    public KnightChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> can = new ArrayList<>();
        int x = source.getX(), y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(i - x) == 1 && Math.abs(j - y) == 2) ||
                        (Math.abs(i - x) == 2 && Math.abs(j - y) == 1)) {
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