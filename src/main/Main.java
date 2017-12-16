/**
* This java library allows users to check if a card is valid
* @author  Alex Friend
* @version 1.0 
*/

package main;

public class Main {

	public static void main(String[] args) {
		Card card1 = new Card("4436032137006663");
		System.out.println(card1.getCardType());
		
		//Types visa , mastercard or discover
		generateCards test = new generateCards(4,"visa");
		System.out.println(test.getCards());
	}
	

}
