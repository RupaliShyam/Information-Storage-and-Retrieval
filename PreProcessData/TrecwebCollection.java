package PreProcessData;

import java.io.IOException;
import java.util.Map;
import Classes.Path;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * This is for INFSCI 2140 in 2018
 *
 */
public class TrecwebCollection implements DocumentCollection {
	// Essential private methods or variables can be added.
	public Iterator<Map.Entry<String, Object>> iter;
        Map <String,Object> Map1;
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public TrecwebCollection() throws IOException {
            String l, doc_number_line,doc_number="", line,  text_notag, documnet_content="";
            Map1 = new HashMap<>();
            //Reading the file
	    FileReader file = new FileReader(Path.DataWebDir);
            BufferedReader parser = new BufferedReader(file);
            //Read until end of collection file
            while((l = parser.readLine()) != null){
                //If begining of the documnent, store document number as key
                if (l.equals("<DOC>")){
                    doc_number_line = parser.readLine();
                    doc_number = doc_number_line.replaceAll("\\<[^>]*>", ""); 
                }
                //If content of each document store as value
                else if(l.equals("</DOCHDR>")){
                    while(!(line = parser.readLine()).equals("</DOC>")){
                        text_notag = line.replaceAll("\\<[^>]*>", "");  
                        documnet_content.concat(text_notag);
                    }
                    Map1.put(doc_number, documnet_content.toCharArray()); 
                    documnet_content = "";
                }
            }
            //Iterate through the map
            iter = (Iterator) Map1.entrySet().iterator();
		// NT: you cannot load the whole corpus into memory!!
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD.
	public Map<String, Object> nextDocument() throws IOException {
	    //Creating new Map and storing values by iterating through the previous map
            Map<String, Object> web_document = new HashMap<String, Object>(); 
            //Untill end of map iteration, return each key, value pair
            if(iter.hasNext()) { 
		Entry<String, Object> e = (Entry<String, Object>) iter.next();
		web_document.put(e.getKey(), e.getValue());
                return web_document;
            }
            return null;
	}
	
}
