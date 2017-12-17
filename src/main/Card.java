package main;

public class Card  {
	
	private String cardNumber;
	private boolean isCorrectFormat;
	private boolean passesLuhnCheck;
	private CardType cardType = CardType.UNKNOWN;

	public Card(String cardNo) {
		cardNumber = cardNo;
		CharacterCheck charCheck = new CharacterCheck(cardNo);
		isCorrectFormat = charCheck.correctForm();
		if(isCorrectFormat) {
			Luhn.Init(cardNo);		
			passesLuhnCheck = Luhn.passesLuhn();
			if(passesLuhnCheck) {
			String first = cardNumber.substring(0, 1);
			
				switch (first) {

					case "4": cardType = CardType.VISA;
					break;
					
					case "5" : cardType = CardType.MASTERCARD;
					break;
					
					case "6" : cardType = CardType.DISCOVER;
					break;
					
					default: cardType = CardType.UNKNOWN;
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
	
	public CardType getCardType() {
		return cardType;
	}


	public boolean passesLuhn() {
		return passesLuhnCheck;
	}
	
	public boolean correctFormat() {
		return isCorrectFormat;
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
