package PreProcessData;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import Classes.Path;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * This is for INFSCI 2140 in 2019
 *
 */
public class TrectextCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
    public Iterator<Map.Entry<String, Object>> iter;
    Map <String,Object> Map1;
	// YOU SHOULD IMPLEMENT THIS METHOD.
    public TrectextCollection() throws IOException {
        String doc_number_line, line, doc_number="", documnet_content, l;
        String [] doclist;
        Map1 = new HashMap<>();
        //Read the file 
        FileReader file = new FileReader(Path.DataTextDir);
        BufferedReader parser = new BufferedReader(file);
            while((l = parser.readLine()) != null){
                documnet_content="";
                //Check if new documnet
                if (l.equals("<DOC>")){
                    doc_number_line = parser.readLine();
                    doclist = doc_number_line.split(" "); 
                    doc_number = doclist[1]; 
                }
                //Extracting content of the file
                else if(l.equals("<TEXT>") ){
                    while(!(line = parser.readLine()).equals("</TEXT>") )
                        documnet_content = documnet_content + line; 
                }
                //Check if end of the documnet
                else if(l.equals("</DOC>")){
                    Map1.put(doc_number, documnet_content.toCharArray()); 
                }
            }
            iter = (Iterator) Map1.entrySet().iterator(); 
        }
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
            //Creating new Map and storing values by iterating through the previous map
            Map<String, Object> text_document = new HashMap<String, Object>(); 
            //Untill end of map iteration, return each key, value pair
            if(iter.hasNext()) { 
                Entry<String, Object> entry = (Entry<String, Object>) iter.next();
		text_document.put(entry.getKey(), entry.getValue());
                return text_document;
            }
            return null;
	}
}
