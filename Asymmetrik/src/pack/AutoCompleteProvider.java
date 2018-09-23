package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;
import java.util.stream.Collectors;

public class AutoCompleteProvider extends Candidate{
	
	public AutoCompleteProvider(String w, Integer i) {
		super(w, i);
	}

	//Structure for documenting words seen and number of times seen
    static HashMap<String,Integer> wordbank = new HashMap<String,Integer>();
    
    public static void train (String passage){
        //Replaces all instances of non characters with whitespace
    	passage = passage.toLowerCase();
        passage = passage.replaceAll("\\W"," ");
        //Creates an array of strings split at whitespace
        String[] words = passage.split("\\s");
        //Loops through word array and adds words to the word bank
        //If they have not been seen, they will simply be added to the bank,
        //Otherwise, their confidence will increase
        for (int x = 0; x < words.length; x++){
            if (!wordbank.containsKey(words[x])){
                wordbank.put(words[x],1);
            }
            else {
                wordbank.put(words[x], wordbank.get(words[x])+1);
            }
        }
    }
    
    public static List<Candidate> getWords(String fragment){
    	//Lowercases input
    	String lowerFragment = fragment.toLowerCase();
    	//Creates a new map exclusively with the keys that match the string fragment
        Map<String, Integer> matches = wordbank.entrySet()
        .stream()
        .filter(x -> x.getKey().startsWith(lowerFragment))
        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        //Initializes the return list as an empty arraylist
        List<Candidate> candidates = new ArrayList<Candidate>();
        //Adds the every entry in our filtered map to our return list
        matches.forEach((K,V) -> candidates.add(new Candidate(K,V)));
        //sorts list by comparator given in the candidate class
        Collections.sort(candidates, new Comparey());
        return candidates;
    }
    
}
