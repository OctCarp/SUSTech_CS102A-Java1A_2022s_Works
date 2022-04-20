package demos.bigbinary;

public class BigBinary {
    int[] bits;
    boolean positive;
    boolean isZero;

    public static void main(String[] args) {
    }

    public BigBinary(int[] bits, boolean positive) {
        this.bits = bits;
        this.positive = positive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        final boolean zeros;
        if (bits == null) {
            isZero = true;
        } else {
            for (int i = 0; i < bits.length; i++) {
                int newNum = bits[i];
                if (!(sb.length()==0 && newNum == 0)) {
                    sb.append(newNum);
                }
            }
        }
        if (sb.length()==0) {
            return "0";
        } else {
            if (!positive) {
                sb.insert(0, "-");
            }
            return sb.toString();
        }
    }
}
