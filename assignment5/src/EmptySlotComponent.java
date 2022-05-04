import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessColor color) {
        super(color);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
