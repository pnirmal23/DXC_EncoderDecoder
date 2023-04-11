package encoder_decoder;
import java.util.*;

//EncoderDecoder class which contains the 2 methods to encode the plain text String and decode the encoded String back to plain text
public class EncoderDecoder {

	//Initialize the Reference Table with alphanumeric characters and symbols 
	 private static final String REFERENCE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

	 //Method to encode the plain text String using a given offset character
     public String encode(String plainText, char offset) {
        
    	 //Calculate the shift of the Reference Table based on the position of the offset character in the Reference Table
         int shift = REFERENCE_TABLE.indexOf(offset);
         //Initialize the String builder object using the StringBuilder class to build the final obfuscated String
         StringBuilder final_obfsc = new StringBuilder();
         
         //Append the offset character as the start of the encoded String
         final_obfsc.append(offset);
         
         //Iterate through each letter as a character variable in the plain text String
         for (char c : plainText.toCharArray()) {
        	 //Initialize the encoded character variable to be appended to the encoded String later
             char appending_char = ' ';
             //Get the index of character in the plain text String
             int originalIndex = REFERENCE_TABLE.indexOf(c);
             //If the character index is not negative
             if (originalIndex >= 0) {
            	 //Calculate the new encoded index based on the shift value of the offset character
                 int newIndex = (originalIndex - shift) % REFERENCE_TABLE.length();
                 /**If the calculated new index is negative, calculate a revised character index which loops back through the reference table to count backwards 
                 from the end of the Reference Table. Else maintain the calculated character index**/
                 if (newIndex < 0) {
                   appending_char = REFERENCE_TABLE.charAt(REFERENCE_TABLE.length() + newIndex);
                 }else{
                   appending_char = REFERENCE_TABLE.charAt(newIndex);
                 }
                 //Append the character at the calculated character index
                 final_obfsc.append(appending_char);
             } else {
            	 //If no encoding character can be found in the Reference Table, simply append back the original character in the plain text String
            	 final_obfsc.append(c);
             }
         }
         //Return the appended encoded characters as an encoded String
         return final_obfsc.toString();
         
     }

    //Method to decode the encoded String using a given offset character
    public String decode(String encodedText) {
    	
    	//Initialize the offset character as the letter in the beginning of the encoded text
        char offset = encodedText.charAt(0);
        //Calculate the shift of the Reference Table based on the position of the offset character in the Reference Table
        int shift = REFERENCE_TABLE.indexOf(offset);
        //Initialize the String builder object using the StringBuilder class to build the final decoded 
        StringBuilder decoded_plaintext = new StringBuilder();
        
        //Iterate through each letter as a character variable from the second letter of the encoded String
        for (char c : encodedText.substring(1).toCharArray()) {
        	//Get the index of the character in the encoded String
            int encodedIndex = REFERENCE_TABLE.indexOf(c);
            //If the character index is not negative
            if (encodedIndex >= 0) {
                /**Calculate the decoded character index based on the offset character and the encoded index relative to the 
            	position of the characters in the Reference Table**/
            	int decodedIndex = (encodedIndex + shift + REFERENCE_TABLE.length()) % REFERENCE_TABLE.length();
                //Initialize the character to be appended according to the index position in the Reference Table
            	char appending_char = REFERENCE_TABLE.charAt(decodedIndex);
                //Append the character at the calculated decoded index to the decoded String builder object
            	decoded_plaintext.append(appending_char);
            } else {
            	//If no decoded character can be found in the Reference Table, simply append back the encoded character found in the encoded text String
            	decoded_plaintext.append(c);
            }
        }
        //Return the appended decoded characters as an decoded String which should reflect the initial plain text String
        return decoded_plaintext.toString();
        
    }
}





