/**
* This java library allows users to check if a card is valid
* @author  Alex Friend
* @version 1.0 
*/

package main;

public class CharacterCheck {

	private String cardNo;
	private boolean correct;
	
	public CharacterCheck(String cardNumber) {
		cardNo = cardNumber;
		isCorrectFormat();
	}
	
	  
    /**
     * Check the card number is the correct format
     * @return void
     */
	private void isCorrectFormat() {
		if (cardNo.matches("[0-9]+") && cardNo.length() == 16) correct= true;
		else correct= false;			
	}
	
	public boolean correctForm(){
		return correct;
	}
}
