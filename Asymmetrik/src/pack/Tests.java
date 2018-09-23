package pack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void test() {
		//training set specified by challenges page
		String train = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		AutoCompleteProvider.train(train);
		assertEquals(AutoCompleteProvider.getWords("th").size(),7);
		//Test for candidate object
		Candidate james = new Candidate("james", 5);
		System.out.println(james);
		//fragments from challenges page
		System.out.println(AutoCompleteProvider.getWords("thi"));
		System.out.println(AutoCompleteProvider.getWords("th"));
		System.out.println(AutoCompleteProvider.getWords("nee"));
		//training to insure hashmap is sustained in memory
		String train2 = "Well, I hate to admit it, but sometimes we just have to write test cases";
		AutoCompleteProvider.train(train2);
		System.out.println(AutoCompleteProvider.getWords("Well"));
		System.out.println(AutoCompleteProvider.getWords("emily"));
		System.out.println(AutoCompleteProvider.getWords("thi"));
	}

}
