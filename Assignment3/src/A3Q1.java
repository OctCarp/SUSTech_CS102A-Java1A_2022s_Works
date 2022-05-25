import java.util.Scanner;

public class A3Q1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String fCipher= input.nextLine();
        String cCipher= input.nextLine();
        int caesarN= input.nextInt();
        int M= input.nextInt();
        String answer=getAnswer(fCipher,cCipher,caesarN,M);
        System.out.println(answer);
    }

    public static String getAnswer(String fenceCipher, String caesarCipher, int caesarN, int M) {
        StringBuilder answer = new StringBuilder();
        String fence = getFence(fenceCipher);
        String caesar = getCaesar(caesarCipher, caesarN);
        String key = getKey(fence, caesar, M);
        int letter = 1;
        for (int i = 0; i < caesar.length(); i++) {
            char row = caesar.charAt(i);
            if ((row > 64 && row < 91)) {
                String str = caesar.substring(i, i + 1);
                char col = key.charAt(letter-1);
                int shift = 0;
                if (col > 64 && col < 91) {
                    shift = col - 65;
                } else if (col > 96 && col < 123) {
                    shift = col - 97;
                }
                String add = getCaesar(str, shift);
                answer.append(add);
                letter++;
            } else{answer.append(row);}
        }
        String answerStr = answer.toString();
        return answerStr;
    }

    public static String getFence(String cipher) {
        int totalLength = cipher.length();
        int letterLength = totalLength - 1;
        StringBuilder sb = new StringBuilder(letterLength);
        int groupLength = cipher.charAt(totalLength - 1) - 48;
        StringBuilder code = new StringBuilder(cipher);
        code.deleteCharAt(totalLength - 1);
        String cipherLetter = code.toString();
        for (int i = 0; i < groupLength; i++) {
            for (int j = i; j < letterLength; j += groupLength) {
                char chars = cipherLetter.charAt(j);
                sb.append(chars);
            }
        }
        String fence = sb.toString();
        return fence;
    }

    public static String getCaesar(String cipher, int N) {
        int length = cipher.length();
        int shift = N;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char chars = cipher.charAt(i);
            int charCode = chars;
            int newCode = chars + shift;
            char add;
            if (charCode > 64 && charCode < 91) {
                if (newCode > 90) {
                    add = (char) (newCode - 26);
                } else {
                    add = (char) newCode;
                }
            } else if (charCode > 96 && charCode < 123) {
                if (newCode > 122) {
                    add = (char) (newCode - 26 - 32);
                } else {
                    add = (char) (newCode - 32);
                }
            } else {
                add = chars;
            }
            sb.append(add);
        }
        String caesar = sb.toString();
        return caesar;
    }

    public static String getKey(String fence, String caesar, int M) {
        int letterNumber = 0;
        for (int i = 0; i < caesar.length(); i++) {
            int a = caesar.charAt(i);
            if ((a > 64 && a < 91) || (a > 96 && a < 123)) {
                letterNumber++;
            }
        }
        String str = fence.substring(0, M);
        StringBuilder fenceBuilder = new StringBuilder();
        int groupNumber = letterNumber / M;
        for (int i = 0; i <= groupNumber; i++) {
            fenceBuilder.append(str);
        }
        String builder = fenceBuilder.toString();
        String key = builder.substring(0, letterNumber);
        return key;
    }
}
