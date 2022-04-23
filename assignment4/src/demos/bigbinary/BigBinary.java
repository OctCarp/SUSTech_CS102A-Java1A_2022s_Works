package demos.bigbinary;

public class BigBinary {
    int[] bits;
    int[] re;
    boolean positive;

    public BigBinary(BigBinary bigBinary) {
        this.positive = bigBinary.positive;
        this.bits = bigBinary.bits;
    }

    public BigBinary add(BigBinary bigbinary) {
        if ((this.positive && bigbinary.positive) || (!this.positive && !bigbinary.positive)) {
            return sameSign(bigbinary);
        } else return differSign(bigbinary);
    }

    public BigBinary minus(BigBinary bigbinary) {
        if ((this.positive && !bigbinary.positive) || (!this.positive && bigbinary.positive)) {
            return sameSign(bigbinary);
        } else return differSign(bigbinary);
    }

    public static BigBinary add(BigBinary b1, BigBinary b2) {
        BigBinary newBinary = new BigBinary(b1);
        newBinary = newBinary.add(b2);
        return newBinary;
    }

    public static BigBinary minus(BigBinary b1, BigBinary b2) {
        BigBinary newBinary = new BigBinary(b1);
        newBinary = newBinary.minus(b2);
        return newBinary;
    }

    public BigBinary multiply(BigBinary bigbinary) {
        BigBinary newBigBinary = new BigBinary(new int[0], true);
        return newBigBinary;
    }

    public static BigBinary multiply(BigBinary b1, BigBinary b2) {
        BigBinary newBigBinary = new BigBinary(new int[0], true);
        return newBigBinary;
    }


    public int[] cut(int[] bits) {
        int firstOne = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                firstOne = i;
                break;
            }
        }
        int[] cutBits = new int[bits.length - firstOne];
        for (int i = firstOne; i < bits.length; i++) {
            cutBits[i - firstOne] = bits[i];
        }
        return cutBits;
    }

    public BigBinary(int[] bits, boolean positive) {
        this.bits = cut(bits);
        this.positive = positive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (bits == null || bits.length == 0) {
            return "0";
        } else {
            for (int i = 0; i < bits.length; i++) {
                int newNum = bits[i];
                sb.append(newNum);
            }
        }

        if (!positive) {
            sb.insert(0, "-");
        }
        return sb.toString();

    }

    public int[] reverse(int[] bits) {
        int[] re = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            re[re.length - 1 - i] = bits[i];
        }
        return re;
    }

    public BigBinary sameSign(BigBinary bigbinary) {
        int length = 0;
        int[] re = reverse(this.bits);
        int[] reBig = reverse(bigbinary.bits);
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        if (this.bits.length > bigbinary.bits.length) {
            length = bigbinary.bits.length;
        } else {
            length = this.bits.length;
        }
        for (int i = 0; i < length; i++) {
            int first = re[i];
            int second = reBig[i];
            int place = first + second;
            if (carry) {
                place += 1;
            }
            switch (place) {
                case 0:
                    sb.append(0);
                    carry = false;
                    break;
                case 1:
                    sb.append(1);
                    carry = false;
                    break;
                case 2:
                    sb.append(0);
                    carry = true;
                    break;
                case 3:
                    sb.append(1);
                    carry = true;
                    break;
            }
        }
        if (this.bits.length > bigbinary.bits.length) {
            for (int i = length; i < this.bits.length; i++) {
                int num = this.bits[bits.length-1-i];
                if (carry) {
                    num += 1;
                }
                switch (num) {
                    case 0:
                        sb.append(0);
                        carry = false;
                        break;
                    case 1:
                        sb.append(1);
                        carry = false;
                        break;
                    case 2:
                        sb.append(0);
                        carry = true;
                        break;
                }
            }
            if (carry) {
                sb.append(1);
            }
        } else if (this.bits.length < bigbinary.bits.length) {
            for (int i = length; i < bigbinary.bits.length; i++) {
                int num = reBig[i];
                if (carry) {
                    num += 1;
                }
                switch (num) {
                    case 0:
                        sb.append(0);
                        carry = false;
                        break;
                    case 1:
                        sb.append(1);
                        carry = false;
                        break;
                    case 2:
                        sb.append(0);
                        carry = true;
                        break;
                }
            }
            if (carry) {
                sb.append(1);
            }
        } else {
            if (carry) {
                sb.append(1);
            }
        }
        this.bits = toInts(sb);
        return this;
    }

    public BigBinary differSign(BigBinary bigbinary) {
        int length = 0;
        boolean thisBigger;
        int[] re = reverse(this.bits);
        int[] reBig = reverse(bigbinary.bits);
        StringBuilder sb = new StringBuilder();
        boolean back = false;
        if (re.length > reBig.length) {
            thisBigger = true;
            length = reBig.length;
            for (int i = 0; i < length; i++) {
                int bigger = re[i];
                int smaller = reBig[i];
                int place = bigger - smaller;
                if (back) {
                    place -= 1;
                }
                switch (place) {
                    case 1:
                        sb.append(1);
                        back = false;
                        break;

                    case 0:
                        sb.append(0);
                        back = false;
                        break;
                    case -1:
                        sb.append(1);
                        back = true;
                        break;
                    case -2:
                        sb.append(0);
                        back = true;
                        break;
                }
            }
            for (int i = length; i < re.length - 1; i++) {
                int num = re[i];
                if (back) {
                    num -= 1;
                }
                switch (num) {
                    case 1:
                        sb.append(1);
                        back = false;
                        break;
                    case 0:
                        sb.append(0);
                        back = false;
                        break;
                    case -1:
                        sb.append(1);
                        back = true;
                        break;
                }
            }
            if (!back) {
                sb.append(1);
            }
        } else if (reBig.length > re.length) {
            thisBigger = false;
            length = re.length;
            for (int i = 0; i < length; i++) {
                int bigger = reBig[i];
                int smaller = re[i];
                int place = bigger - smaller;
                if (back) {
                    place -= 1;
                }
                switch (place) {
                    case 1:
                        sb.append(1);
                        back = false;
                        break;
                    case 0:
                        sb.append(0);
                        back = false;
                        break;
                    case -1:
                        sb.append(1);
                        back = true;
                        break;
                    case -2:
                        sb.append(0);
                        back = true;
                        break;
                }
            }
            for (int i = length; i < reBig.length - 1; i++) {
                int num = reBig[i];
                if (back) {
                    num -= 1;
                }
                switch (num) {
                    case 1:
                        sb.append(1);
                        back = false;
                        break;
                    case 0:
                        sb.append(0);
                        back = false;
                        break;
                    case -1:
                        sb.append(1);
                        back = true;
                        break;
                }
            }
            if (!back) {
                sb.append(1);
            }
        } else {
            thisBigger = true;
            boolean same = true;
            length = re.length;
            int firstDiffer = 0;
            for (int i = 0; i < length; i++) {
                int one = this.bits[i];
                int two = bigbinary.bits[i];
                if (one > two) {
                    thisBigger = true;
                    same = false;
                    break;
                }
                if (one < two) {
                    thisBigger = false;
                    same = false;
                    break;
                }
            }
            if (same) {
                this.bits = new int[0];
                return this;
            } else if (thisBigger) {
                back = false;
                for (int i = 0; i < length; i++) {
                    int one = re[i];
                    int two = reBig[i];
                    int place = one - two;
                    if (back) {
                        place -= 1;
                    }
                    switch (place) {
                        case 1:
                            sb.append(1);
                            back = false;
                            break;
                        case 0:
                            sb.append(0);
                            back = false;
                            break;
                        case -1:
                            sb.append(1);
                            back = true;
                            break;
                        case -2:
                            sb.append(0);
                            back = true;
                            break;
                    }
                }
            } else {
                this.positive = false;
                back = false;
                for (int i = 0; i < length; i++) {
                    int one = reBig[i];
                    int two = re[i];
                    int place = one - two;
                    if (back) {
                        place -= 1;
                    }
                    switch (place) {
                        case 1:
                            sb.append(1);
                            back = false;
                            break;
                        case 0:
                            sb.append(0);
                            back = false;
                            break;
                        case -1:
                            sb.append(1);
                            back = true;
                            break;
                        case -2:
                            sb.append(0);
                            back = true;
                            break;
                    }
                }
            }
        }
        if (!thisBigger) {
            this.positive = !this.positive;
        }
        this.bits = toInts(sb);
        return this;
    }

    public int[] toInts(StringBuilder sb) {
        int firstOne = 0;
        for (int i = 0; i < sb.length(); i++) {
            int num = sb.charAt(sb.length() - 1 - i) - 48;
            if (num == 1) {
                firstOne = i;
                break;
            }
        }
        int[] newBits = new int[sb.length() - firstOne];
        for (int i = firstOne; i < sb.length(); i++) {
            newBits[i - firstOne] = sb.charAt(sb.length() - 1 - i) - 48;
        }
        return newBits;
    }
}
