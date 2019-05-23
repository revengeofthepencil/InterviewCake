package q20190522;


import java.util.Random;

public class NthFib {
    public int getNthFib(int fibIdx) {
        if (fibIdx <= 1) {
            return fibIdx;
        } else {
            return getNthFib(fibIdx - 1) + getNthFib(fibIdx - 2);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        final int fibIdx = rand.nextInt(30);
        NthFib nf = new NthFib();
        for (int i = 0; i <= fibIdx; i++) {
            int nthFib = nf.getNthFib(i);
            System.out.println("fibIdx = " + fibIdx + ", i = " + i + ", nthFib = " + nthFib);
        }
    }
}
