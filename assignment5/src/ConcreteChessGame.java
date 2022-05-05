import java.util.List;

public class ConcreteChessGame implements ChessGame {


    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        chess.setChessboard(this.chessComponents);
        chess.setSource(new ChessboardPoint(source.getX(), source.getY()));
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=chessComponents[sourceX][sourceY];
        if(currentPlayer!=chess.getChessColor()){
            return false;
        }
        List<ChessboardPoint> points = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        for (int i = 0; i < points.size(); i++) {
            ChessboardPoint point = points.get(i);
            if (point.getX() == targetX && point.getY() == targetY) {
                currentPlayer=currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = chessboard.get(i).charAt(j);
                ChessComponent chess = type(c);
                chess.setSource(new ChessboardPoint(i, j));
                chessComponents[i][j] = chess;
            }
        }
        char player = chessboard.get(8).charAt(0);
        if (player == 'b') {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
        }
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getCapturedChess(ChessColor player) {
        int k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char c = chessComponents[i][j].name;
                    switch (c) {
                        case 'K':
                            k--;
                            break;
                        case 'Q':
                            q--;
                            break;
                        case 'R':
                            r--;
                            break;
                        case 'B':
                            b--;
                            break;
                        case 'N':
                            n--;
                            break;
                        case 'P':
                            p--;
                            break;

                    }
                }
            }
            if (k != 0) {
                sb.append(String.format("K %d\n", k));
            }
            if (q != 0) {
                sb.append(String.format("Q %d\n", q));
            }
            if (r != 0) {
                sb.append(String.format("R %d\n", r));
            }
            if (b != 0) {
                sb.append(String.format("B %d\n", b));
            }
            if (n != 0) {
                sb.append(String.format("N %d\n", n));
            }
            if (p != 0) {
                sb.append(String.format("P %d\n", p));
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char c = chessComponents[i][j].name;
                    switch (c) {
                        case 'k':
                            k--;
                            break;
                        case 'q':
                            q--;
                            break;
                        case 'r':
                            r--;
                            break;
                        case 'b':
                            b--;
                            break;
                        case 'n':
                            n--;
                            break;
                        case 'p':
                            p--;
                            break;

                    }
                }
            }
            if (k != 0) {
                sb.append(String.format("k %d\n", k));
            }
            if (q != 0) {
                sb.append(String.format("q %d\n", q));
            }
            if (r != 0) {
                sb.append(String.format("r %d\n", r));
            }
            if (b != 0) {
                sb.append(String.format("b %d\n", b));
            }
            if (n != 0) {
                sb.append(String.format("n %d\n", n));
            }
            if (p != 0) {
                sb.append(String.format("p %d\n", p));
            }
        }
        return sb.toString();
    }

    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            sb.append(String.format("\n"));
        }
        return sb.toString();
    }

    private ChessComponent type(char c) {
        switch (c) {
            case 'K':
                return new KingChessComponent(ChessColor.BLACK);
            case 'k':
                return new KingChessComponent(ChessColor.WHITE);
            case 'Q':
                return new QueenChessComponent(ChessColor.BLACK);
            case 'q':
                return new QueenChessComponent(ChessColor.WHITE);
            case 'R':
                return new RookChessComponent(ChessColor.BLACK);
            case 'r':
                return new RookChessComponent(ChessColor.WHITE);
            case 'B':
                return new BishopChessComponent(ChessColor.BLACK);
            case 'b':
                return new BishopChessComponent(ChessColor.WHITE);
            case 'N':
                return new KnightChessComponent(ChessColor.BLACK);
            case 'n':
                return new KnightChessComponent(ChessColor.WHITE);
            case 'P':
                return new PawnChessComponent(ChessColor.BLACK);
            case 'p':
                return new PawnChessComponent(ChessColor.WHITE);
        }
        return new EmptySlotComponent(ChessColor.NONE);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}
