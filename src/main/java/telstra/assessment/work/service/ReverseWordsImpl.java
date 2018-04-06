package telstra.assessment.work.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ReverseWordsImpl {

	public String getReverseWordsfromString(String reverseWord) {
		String reversedOfString = "";
		String[] arrayOfReverse = reverseWord.split(" ");
		if(null != arrayOfReverse){
			
		for (String word : arrayOfReverse) {
			String  reversedWord = "";
			for (int i = word.length() - 1; i >= 0; i--) {
				reversedWord += word.charAt(i);
			}
			reversedOfString += reversedWord;
			reversedOfString += " ";
		
		}
		   return reversedOfString;
		}else {
			throw new IllegalArgumentException ("Wrong input: " + arrayOfReverse);
		}

}
}