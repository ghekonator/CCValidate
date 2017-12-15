package main;

public class Card  {
	
	private String cardNumber;
	private boolean isCorrectLength;
	private boolean passesLuhnCheck;

	public Card(String cardNo) {
		cardNumber = cardNo;
		Luhn luhnCheck = new Luhn(cardNo);
		CharacterCheck charCheck = new CharacterCheck(cardNo);
		isCorrectLength = charCheck.correctLength();
		passesLuhnCheck = luhnCheck.passesLuhn() ;
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public boolean passesLuhn() {
		return passesLuhnCheck;
	}
	
	public boolean correctLength() {
		return isCorrectLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
