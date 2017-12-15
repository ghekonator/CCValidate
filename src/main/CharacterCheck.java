package main;

public class CharacterCheck {

	private String cardNo;
	private boolean correct;
	public CharacterCheck(String cardNumber) {
		cardNo = cardNumber;
		isCorrectLength();
	}
	
	private void isCorrectLength() {
		if(cardNo.length() == 16) correct= true;
		else correct= false;			
	}
	
	public boolean correctLength(){
		return correct;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
