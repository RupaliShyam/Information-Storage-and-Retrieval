package PreProcessData;
import Classes.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileReader;
import java.util.Set;

public class StopWordRemover {
	// Essential private methods or variables can be added.
    private Set<String> stopwordset;

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public StopWordRemover( ) throws IOException {
		// Load and store the stop words from the fileinputstream with appropriate data structure.
		// NT: address of stopword.txt is Path.StopwordDir
            //try{
            String word;
                FileReader fr = new FileReader(Path.StopwordDir);
                BufferedReader r = new BufferedReader(fr);
                // Using HashSet for fast search of strings
                stopwordset = new HashSet<>();
                //Until end of file
                while ((word = r.readLine()) != null)
                    stopwordset.add(word);
                    
            //}
            //catch(Exception e){
            //    System.out.println("File not found");
            //}
        }

	// YOU SHOULD IMPLEMENT THIS METHOD.
	public boolean isStopword( char[] word ) {
	// checking if word is present in stop word list
            String w = String.valueOf(word);
            return stopwordset.contains(w);
        }
        
}
