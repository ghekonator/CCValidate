package main;

import java.util.ArrayList;

public class CardGenerator {

	private static final String NUMERIC_STRING = "0123456789";
	private static ArrayList<String> numbers = new ArrayList<String>();
	
	public cardGenerator(int numCards , String cardType) {
		for(int i = 0 ; i< numCards ; i++) {
			StringBuilder builder = new StringBuilder();
			int count = 16;
			while (count-- != 0) {
				int character = (int)(Math.random()*NUMERIC_STRING.length());
				builder.append(NUMERIC_STRING.charAt(character));
			}
			
			PaymentCard test = new PaymentCard(builder.toString());
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
