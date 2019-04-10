package q20190409;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexwalker on 4/9/19.
 *
 *  I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know. I put each word I didn't know at increasing indices in a huge list I created in memory. When I reached the end of the dictionary, I started from the beginning and did the same thing until I reached the page I started at.

 Now I have a list of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet, reach the end, and then start from the beginning of the alphabet. In other words, this is an alphabetically ordered list that has been "rotated." For example:

 words = [
 'ptolemaic',
 'retrograde',
 'supplant',
 'undulate',
 'xenoepist',
 'asymptote',  # <-- rotates here!
 'babka',
 'banoffee',
 'engender',
 'karpatka',
 'othellolagkage',
 ]

 Write a function for finding the index of the "rotation point," which is where I started working from the beginning of the dictionary. This list is huge (there are lots of words I don't know) so we want to be efficient here.
 */
public class RoatationPoint {

    public RoatationPoint() {}

    private boolean isRoatationPoint(String[] wordList, int idx) {
        int nextIdx = idx + 1;
        int prevIdx = idx - 1;
        String current = wordList[idx];
        String prev = prevIdx < 0 ? wordList[wordList.length - 1 ]  : wordList[prevIdx];
        String next = nextIdx >= (wordList.length - 1) ?  wordList[0] : wordList[nextIdx];
        int nextComp = current.compareTo(next);
        int prevComp = current.compareTo(prev);
        boolean isRotationPoint = nextComp < 0 && prevComp < 0;
        return   isRotationPoint;
    }

    public int findRoation(String[] wordList) {
        int currentIdx = 0;
        int endIdx = wordList.length -1;
        while (!isRoatationPoint(wordList, currentIdx)) {
            System.out.println("checking idx " + currentIdx + ", endIdx = " + endIdx);
            int halfwayPoint = currentIdx + Math.round(  (endIdx - currentIdx) / 2  );
            int compHalf = wordList[currentIdx].compareTo( wordList[halfwayPoint] );
            if ( compHalf < 0 ) {
                currentIdx = halfwayPoint;
            } else {
                currentIdx += 1;
                endIdx = halfwayPoint;
            }
        }

        return currentIdx;
    }

    public static void main(String[] args) {
        final String[] wordList =  { "reprehenderit", "sed", "sint", "sit", "sunt", "tempor", "ullamco", "ut", "velit",
                "veniam", "voluptate", "ad", "adipiscing", "aliqua", "aliquip", "amet", "anim", "aute", "cillum",
                "commodo", "consectetur", "consequat", "culpa", "cupidatat", "deserunt", "do", "dolor", "dolore",
                "duis", "ea", "eiusmod", "elit", "enim", "esse", "est", "et", "eu", "ex", "excepteur", "exercitation",
                "fugiat", "id", "in", "incididunt", "ipsum", "irure", "labore", "laboris", "laborum", "lorem", "magna",
                "minim", "mollit", "nisi", "non", "nostrud", "nulla", "occaecat", "officia", "pariatur", "proident",
                "qui", "quis" };
        int rPoint = new RoatationPoint().findRoation(wordList);
        System.out.println("rPoint = " + rPoint + ", word = " + wordList[rPoint]);
    }
}
