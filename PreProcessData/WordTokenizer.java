package PreProcessData;

/**
 * This is for INFSCI 2140 in 2019
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	// Essential private methods or variables can be added.
	private String [] words;
        private int count=0;
	// YOU MUST IMPLEMENT THIS METHOD.
	public WordTokenizer( char[] texts ) {
            //Tokenizing the content of the document
            String doc = String.valueOf(texts);
             String doc1 = new String(doc).replaceAll("([[^0-9]&&[^a-z]&&[^A-Z]]+)", " ")
        .replaceAll("(\\')|(\\.)|(\t)", "").replaceAll("( )+", " ");
            words = doc1.split(" "); 
        }
	
	// YOU MUST IMPLEMENT THIS METHOD.
	public char[] nextWord() {
            //Returning each tokenized word from content
            while(count < words.length)
		return words[count++].toCharArray(); 
            return null;
	}
	
}
