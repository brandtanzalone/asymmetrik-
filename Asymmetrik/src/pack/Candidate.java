package pack;

import java.util.Comparator;

public class Candidate {
	//A candidate is an object consisting of a word and confidence
	String word;
    int confidence;
    
    //constructor
    public Candidate(String w, Integer i){
      word = w;
      confidence = i;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getConfidence(){
        return confidence;
    }
    
    //For testing
    public String toString() {
		return word + " " + confidence;
    	
    }

    //Comparator for candidates. Ordering by confidence and then alphabetically. 
    //The value returned are such that the highest confidence and the lowest alphabetical 
    //value occurs first
    public static class Comparey implements Comparator<Candidate> {
        
        public int compare(Candidate c1, Candidate c2){
            if (c1.getConfidence() < c2.getConfidence()) return 1;
            else if (c1.getConfidence() == c2.getConfidence()) {
            	if (c1.getWord().compareTo(c2.getWord()) < 0 ) return -1;
            	else if (c1.getWord().compareTo(c2.getWord()) > 0) return 1;
            	else return 0;
            }
            else return -1;
        }
        
    }
}
