package main;

public class Luhn {
	private static String cardNoString = ""; 
	private static int[] doubledValue;
    private static boolean isLuhn;
    
    public Luhn(String cardNo) {
		setCardNoString(cardNo);
		doubledValue = new int[getCardNoString().length()/2];
        doubleCard();
    }
       
    private static void doubleCard() {		
		String valuestodouble ="";
		for(int i = getCardNoString().length()-1 ; i > 0  ; i-=2) {
			valuestodouble = valuestodouble + getCardNoString().substring(i-1, i);		
		}			
		for(int i = 0 ; i < valuestodouble.length() ; i++) {
			doubledValue[i] = 2*Integer.parseInt(valuestodouble.substring(i, i+1));
		}
		addDigits();
	}
		
    private static void addDigits() {
		for(int i = 0 ; i < doubledValue.length ; i++ ) {
			if(doubledValue[i] > 9) {
				String value = Integer.toString(doubledValue[i]);
				int digit1 = Integer.parseInt(value.substring(0,1));
				int digit2 =  Integer.parseInt(value.substring(1,2));
				int newValue = digit1+digit2;
				doubledValue[i] = newValue;			
			}
		}
		addValue();
	}
		
	private static void addValue() {
		int sum = 0;
		for(int i = getCardNoString().length() ; i > 0  ; i-=2) {
			sum += Integer.parseInt(getCardNoString().substring(i-1, i));				
		}
		for(int i = 0 ; i < doubledValue.length ; i++) {
			sum += doubledValue[i];
		}
		test(sum);
	}
	
	private static void test(int sum) {
		if(sum % 10 == 0 ) isLuhn = true;	
		else isLuhn = false;
	}
	
	public boolean passesLuhn() {
		return isLuhn;
	}

	public static String getCardNoString() {
		return cardNoString;
	}

	public static void setCardNoString(String cardNoString) {
		Luhn.cardNoString = cardNoString;
	}

}