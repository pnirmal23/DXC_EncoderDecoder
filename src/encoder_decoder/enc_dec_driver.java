package encoder_decoder;
import java.util.*;

//Extend the EncoderDecoder class into this driver class to develop an encoder decoder application using OOP
public class enc_dec_driver extends EncoderDecoder{

	//Main driver method
	public static void main(String[] args) {
		
		//Initialize Scanner object to handle user input
		Scanner userInput = new Scanner(System.in);
		//Initialize EncoderDecoder object to encode/decode plain text String
		EncoderDecoder EncDec = new EncoderDecoder();
	    
		//Print the prompt for user to input a plain text String 
	    System.out.println("Please input the plaintext to be encoded: ");
	    //Handle String user input according to the given prompt
	    String plainText = userInput.nextLine();
	    
	    //Print the prompt for user to input an offset character
	    System.out.println("Please input the offset character: ");
	    //Handle offset character input by taking the first character being input by user
	    char offset = userInput.next().charAt(0);
	    
	    //Encode the plain text String using the offset character
	    String encodedText = EncDec .encode(plainText, offset);
	    //Decode the encoded text back to the plain text String
	    String decodedText = EncDec .decode(encodedText);
	    
	    //Print the user input plain text and offset character
	    System.out.println("Plain text: " + plainText);
	    System.out.println("Offset character: " + offset);
	    
	    //Print the encoded text
	    System.out.println("Encoded text: " + encodedText);
	    //Print the decoded plain text
	    System.out.println("Decoded text: " + decodedText);

	}

}
