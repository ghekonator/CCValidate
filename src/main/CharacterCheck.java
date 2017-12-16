package main;

public class CharacterCheck {

	private String cardNo;
	private boolean correct;
	public CharacterCheck(String cardNumber) {
		cardNo = cardNumber;
		isCorrectFormat();
	}
	
	private void isCorrectFormat() {
		if (cardNo.matches("[0-9]+") && cardNo.length() == 16) correct= true;
		else correct= false;			
	}
	
	public boolean correctForm(){
		return correct;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
