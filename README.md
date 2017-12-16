<h1><u> CCValidate Java Library <u></h1>
 
<h2> Set up: </h2>
<p>
  In the bin folder in this repository is CCValidate.jar. Download this. When setting up new Java project include this in the build path.
  
</p>
<h2> Usage: </h2>
<p>
 -  To create card: Card newCard = new Card("Credit card number"); <br />
 -  To check if card is valid: newCard.isValid();<br />
 -  To check if card passes Luhn : newCard.passesLuhn();<br />
 -  To echo back card number : newCard.getCardNumber();<br />
 -  To check if card number is in correct format: newCard.correctFormat();<br />
 -  To get type of card: newCard.getCardType();<br />
 
 
</p>


