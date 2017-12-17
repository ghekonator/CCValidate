package main;

import java.util.ArrayList;

public class CardGenerator {

	private static final String NUMERIC_STRING = "0123456789";
	private static ArrayList<String> numbers = new ArrayList<String>();
	
	public CardGenerator(int numCards , CardType cardType) {
		for(int i = 0 ; i< numCards ; i++) {
			StringBuilder builder = new StringBuilder();
			int count = 16;
			while (count-- != 0) {
				int character = (int)(Math.random()*NUMERIC_STRING.length());
				builder.append(NUMERIC_STRING.charAt(character));
			}
			
			Card test = new Card(builder.toString());
			if(test.isValid() == false || test.getCardType() != cardType) {
				numCards ++;
			}
			else {
				numbers.add(builder.toString());
			}
		}
	}
	
	public String getCards() {
		String list = "";
		for(int i = 0 ; i< numbers.size() ; i++) {
			list = list + numbers.get(i) + "\n";
		}
		return list;
	}
}
