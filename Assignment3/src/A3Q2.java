import java.io.*;
import java.util.*;

public class A3Q2 {
    static ArrayList<String> stm = new ArrayList<>();
    static boolean wasNegative = false;
    static long matchNum = 0;
    static long influenceGauge;
    static long sumM=0;
    static int aMax=0;
    static long sumB=0;
    static HashMap<String, Integer> stmMap = new HashMap<>();
    static QReader in = new QReader();
    static QWriter out = new QWriter();

    public static void main(String[] args) {
        long n = in.nextLong();
        influenceGauge = in.nextLong();
        for (int i = 0; i < n; i++) {
            long m = in.nextLong();
            sumM += m;
        }
        for (int i = 0; i < n ; i++) {
            int type = in.nextInt();
            if (type == 1) {
                String s = in.next();
                typeOne(s);
                if(counterStatements()>aMax){
                    aMax=counterStatements();
                }
            }
            if (type == 2) {
                String s = in.next();
                typeTwo(s);
                out.println(counterStatements());
            }
            if (type == 3) {
                typeThree();
            }
        }
        int judge=Integer.signum(aMax)*Long.signum(sumM);
        if(wasNegative||judge<0){
            out.println("Fail");
        }else {out.println("Qi Fei");}
        out.close();
    }

    public static int counterStatements() {
        if (stm == null) {
            return 0;
        } else {
            return getMedian();
        }
    }

    public static void typeOne(String s) {
        stm.add(s);
        if (stmMap.containsKey(s)) {
            int i = stmMap.get(s);
            stmMap.replace(s, i + 1);
        } else {
            stmMap.put(s, 1);
        }
    }

    public static void typeTwo(String tb) {
        influenceGauge++;
        if (stm != null) {
            long L = getMedian();
            if (influenceGauge < L) {
                influenceGauge -= stm.size();
            }
            if (influenceGauge < 0) {
                wasNegative = true;
            }
        }

        if (stmMap.containsKey(tb)) {
            matchNum += stmMap.get(tb);
        }
    }

    public static void typeThree() {
        out.println(matchNum);
    }

    public static int getMedian() {
        MaxHeap heap1 = new MaxHeap();
        MinHeap heap2 = new MinHeap();
        for (int i = 0; i < stm.size(); i++) {
            int k = stm.get(i).length();
            if (heap1.size() == 0 || heap1.getMax() > k) {
                heap1.push(k);
                if (heap1.size() > heap2.size() + 1) {
                    heap2.push(heap1.getMax());
                    heap1.pop();
                }
            } else {
                heap2.push(k);
                if (heap1.size() < heap2.size()) {
                    heap1.push(heap2.getMin());
                    heap2.pop();
                }
            }
        }
        return heap1.getMax();
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

class MinHeap {
    private static final int MAXSIZE = 10010;
    private int[] a = new int[MAXSIZE];

    private void swap(int x, int y) {
        a[x] = a[x] ^ a[y];
        a[y] = a[y] ^ a[x];
        a[x] = a[x] ^ a[y];
    }

    private void up() {
        int p = a[0];
        while (p > 1) {
            if (a[p] < a[p / 2]) {
                swap(p, p / 2);
                p = p / 2;
            } else
                break;
        }
    }

    public void push(int k) {
        a[++a[0]] = k;
        up();
    }

    public void pop() {
        int s = 2, t = 1;
        a[1] = a[a[0]--];
        while (s <= a[0]) {
            if (s <= a[0] - 1 && a[s + 1] < a[s])
                ++s;
            if (a[s] < a[t]) {
                swap(s, t);
                t = s;
                s *= 2;
            } else
                break;
        }
    }

    public int getMin() {
        return a[1];
    }

    public int size() {
        return a[0];
    }
}

class MaxHeap {
    private static final int MAXSIZE = 10010;
    private int[] a = new int[MAXSIZE];

    private void swap(int x, int y) {
        a[x] = a[x] ^ a[y];
        a[y] = a[y] ^ a[x];
        a[x] = a[x] ^ a[y];
    }

    private void up() {
        int p = a[0];
        while (p > 1) {
            if (a[p] > a[p / 2]) {
                swap(p, p / 2);
                p = p / 2;
            } else
                break;
        }
    }

    public void push(int k) {
        a[++a[0]] = k;
        up();
    }

    public void pop() {
        int s = 2, t = 1;
        a[1] = a[a[0]--];
        while (s <= a[0]) {
            if (s <= a[0] - 1 && a[s + 1] > a[s])
                ++s;
            if (a[s] > a[t]) {
                swap(s, t);
                t = s;
                s *= 2;
            } else
                break;
        }
    }

    public int getMax() {
        return a[1];
    }

    public int size() {
        return a[0];
    }
}