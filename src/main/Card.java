package main;

public class Card  {
	
	private String cardNumber;
	private boolean isCorrectFormat;
	private boolean passesLuhnCheck;
	private String cardType = "Card not recognised";

	public Card(String cardNo) {
		cardNumber = cardNo;
		CharacterCheck charCheck = new CharacterCheck(cardNo);
		isCorrectFormat = charCheck.correctForm();
		if(isCorrectFormat) {
			Luhn luhnCheck = new Luhn(cardNo);		
			passesLuhnCheck = luhnCheck.passesLuhn() ;
			if(passesLuhnCheck) {
			String first = cardNumber.substring(0, 1);
			
				switch (first) {

					case "4": cardType = "visa";
					break;
					
					case "5" : cardType = "mastercard";
					break;
					
					case "6" : cardType = "discover";
					break;
					
					default: cardType = "Unknown";
					break;
				}
			}
		}
		else {
			cardNumber = "Not a recognised card number";
		}
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getCardType() {
		return cardType;
	}


	
	public boolean isValid() {
		if(isCorrectFormat && passesLuhnCheck) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
