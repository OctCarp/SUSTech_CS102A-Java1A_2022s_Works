import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent {
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

    public PawnChessComponent(ChessColor color) {
        super(color);
        if (color == ChessColor.BLACK) {
            this.name = 'P';
        } else {
            this.name = 'p';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> can = new ArrayList<>();
        int x = source.getX(), y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean move = true;
                if (this.getChessColor() == ChessColor.BLACK) {
                    if (x == 1 && y == j) {
                        if (i == 2) {
                            if (!(chessboard[2][j] instanceof EmptySlotComponent)) {
                                move = false;
                            }
                        } else if (i == 3) {
                            if (!(chessboard[2][j] instanceof EmptySlotComponent) &&
                                    !(chessboard[3][j] instanceof EmptySlotComponent)) {
                                move = false;
                            }
                        } else move = false;
                    } else if (x != 1 && y == j && i - x == 1) {
                        if (!(chessboard[i][j] instanceof EmptySlotComponent)) {
                            move = false;
                        }
                    } else if (i - x == 1 && Math.abs(j - y) == 1) {
                        if (chessboard[i][j] instanceof EmptySlotComponent) {
                            move = false;
                        }
                    } else move = false;
                } else {
                    if (x == 6 && y == j) {
                        if (i == 5) {
                            if (!(chessboard[5][j] instanceof EmptySlotComponent)) {
                                move = false;
                            }
                        } else if (i == 4) {
                            if (!(chessboard[5][j] instanceof EmptySlotComponent) &&
                                    !(chessboard[4][j] instanceof EmptySlotComponent)) {
                                move = false;
                            }
                        } else move = false;
                    } else if (x != 7 && y == j && i - x == -1) {
                        if (!(chessboard[i][j] instanceof EmptySlotComponent)) {
                            move = false;
                        }
                    } else if (i - x == -1 && Math.abs(j - y) == 1) {
                        if (chessboard[i][j] instanceof EmptySlotComponent) {
                            move = false;
                        }
                    } else move = false;
                }
                if (move && chessboard[i][j].getChessColor() != this.getChessColor()) {
                    can.add(source.offset(i - x, j - y));
                }
            }
        }
        can.removeIf(Objects::isNull);
        return can;
    }
}