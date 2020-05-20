package PreProcessData;

import Classes.*;

/**
 * This is for INFSCI 2140 in 2018
 *
 */
public class WordNormalizer {

    // Essential private methods or variables can be added.

    String input;

    // YOU MUST IMPLEMENT THIS METHOD.

    public char[] lowercase(char[] chars) {
        //Convert to string and convert to lowercase
        input = String.valueOf(chars).toLowerCase();
        return input.toCharArray();
    }

    // YOU MUST IMPLEMENT THIS METHOD.
    public String stem(char[] chars) {
        // Return the stemmed word with Stemmer in Classes package.
        Stemmer st = new Stemmer();
        st.add(chars, chars.length);
        st.stem();
        return st.toString();
    }

}
