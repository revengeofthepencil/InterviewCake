package q20190409;

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
public class RoatationPointSolved {


    public int findRotationPoint(String[] words) {
        final String firstWord = words[0];

        int floorIndex = 0;
        int ceilingIndex = words.length - 1;

        while (floorIndex < ceilingIndex) {

            // guess a point halfway between floor and ceiling
            int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

            // if guess comes after first word or is the first word
            if (words[guessIndex].compareTo(firstWord) >= 0) {
                // go right
                floorIndex = guessIndex;
            } else {
                // go left
                ceilingIndex = guessIndex;
            }

            // if floor and ceiling have converged
            if (floorIndex + 1 == ceilingIndex) {

                // between floor and ceiling is where we flipped to the beginning
                // so ceiling is alphabetically first
                break;
            }
        }

        return ceilingIndex;
    }

    public static void main(String[] args) {
        final String[] wordList =  { "reprehenderit", "sed", "sint", "sit", "sunt", "tempor", "ullamco", "ut", "velit",
                "veniam", "voluptate", "ad", "adipiscing", "aliqua", "aliquip", "amet", "anim", "aute", "cillum",
                "commodo", "consectetur", "consequat", "culpa", "cupidatat", "deserunt", "do", "dolor", "dolore",
                "duis", "ea", "eiusmod", "elit", "enim", "esse", "est", "et", "eu", "ex", "excepteur", "exercitation",
                "fugiat", "id", "in", "incididunt", "ipsum", "irure", "labore", "laboris", "laborum", "lorem", "magna",
                "minim", "mollit", "nisi", "non", "nostrud", "nulla", "occaecat", "officia", "pariatur", "proident",
                "qui", "quis" };
        int rPoint = new RoatationPointSolved().findRotationPoint(wordList);
        System.out.println("rPoint = " + rPoint + ", word = " + wordList[rPoint]);
    }
}
