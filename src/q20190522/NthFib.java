package q20190522;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NthFib {
    private Map<Integer, Integer> memoizeFib = new HashMap<Integer, Integer>();
    private int memoizeHits = 0;

    public int getNthFib(int fibIdx) {
        if (fibIdx <= 1) {
            return fibIdx;
        } else {
            return getNthFib(fibIdx - 1) + getNthFib(fibIdx - 2);
        }
    }

    public int getNthFibMemoize(int fibIdx) {
        if (fibIdx <= 1) {
            return fibIdx;
        } else if (memoizeFib.containsKey( fibIdx )) {
            memoizeHits += 1;
            return memoizeFib.get(fibIdx);
        } else {
            int fib = getNthFibMemoize(fibIdx - 1) + getNthFibMemoize(fibIdx - 2);
            memoizeFib.put(fibIdx, fib);
            return fib;
        }
    }

    public int getMemoizeHits() {
        return memoizeHits;
    }


    public Map<Integer, Integer> getMemoizeFib() {
        return memoizeFib;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        final int fibIdx = rand.nextInt(50);
        NthFib nf = new NthFib();


        for (int i = 0; i <= fibIdx; i++) {
            long ms = System.currentTimeMillis();
            int nthFib = nf.getNthFib(i);
            long runtime = System.currentTimeMillis() - ms;
            System.out.println("getNthFib, runtime = " + runtime + ", fibIdx = " + fibIdx + ", i = " + i + ", nthFib = " + nthFib);
        }

        for (int i = 0; i <= fibIdx; i++) {
            long ms = System.currentTimeMillis();
            int nthFib = nf.getNthFibMemoize(i);
            long runtime = System.currentTimeMillis() - ms;
            int memoizeHits = nf.getMemoizeHits();
            System.out.println("getNthFibMemoize, memoizeHits = " + memoizeHits + ", runtime = " + runtime + ", fibIdx = " + fibIdx + ", i = " + i + ", nthFib = " + nthFib);
        }


    }
}
