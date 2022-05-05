import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueenChessComponent extends ChessComponent {
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

        List<ChessboardPoint> can = new ArrayList<>();
        int x = source.getX(), y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean line = true;
                if (x == i) {
                    int row = x;
                    for (int col = Math.min(y, j) + 1;
                         col < Math.max(y, j); col++) {
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            line = false;
                            break;
                        }
                    }
                } else if (y == j) {
                    int col = y;
                    for (int row = Math.min(x, i) + 1;
                         row < Math.max(x, i); row++) {
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            line = false;
                            break;
                        }
                    }
                } else if (x - i == y - j) {
                    int initRow = Math.min(x, i);
                    int initCol = Math.min(y, j);
                    int destRow = Math.max(x, i);
                    int destCol = Math.max(y, j);
                    for (int m = initRow + 1, n = initCol + 1; m < destRow; m++, n++) {
                        if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                            line = false;
                            break;
                        }
                    }
                } else if (x - i == j - y) {
                    int initRow = Math.min(x, i);
                    int initCol = Math.min(y, j);
                    int destRow = Math.max(x, i);
                    int destCol = Math.max(y, j);
                    for (int m = initRow + 1, n = destCol - 1; m < destRow; m++, n--) {
                        if (!(chessboard[m][n] instanceof EmptySlotComponent)) {
                            line = false;
                            break;
                        }
                    }
                } else line = false;
                if (line && chessboard[i][j].getChessColor() != this.getChessColor()) {
                    can.add(source.offset(i - x, j - y));
                }
            }
        }
        can.removeIf(Objects::isNull);
        return can;
    }
}
