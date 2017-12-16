package main;

public class Card  {
	
	private String cardNumber;
	private boolean isCorrectFormat;
	private boolean passesLuhnCheck;

	public Card(String cardNo) {
		cardNumber = cardNo;
		CharacterCheck charCheck = new CharacterCheck(cardNo);
		isCorrectFormat = charCheck.correctForm();
		if(isCorrectFormat) {
			Luhn luhnCheck = new Luhn(cardNo);		
			passesLuhnCheck = luhnCheck.passesLuhn() ;
		}
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public boolean passesLuhn() {
		return passesLuhnCheck;
	}
	
	public boolean correctFormat() {
		return isCorrectFormat;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
