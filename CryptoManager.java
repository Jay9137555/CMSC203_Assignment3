public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean bool = true;
		// For loop. validate if the string is within the range
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) 
				bool = false;
		}
		return bool;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		char temp;
		// For loop. Encrypt a string variable by Caesar Cipher.
		for (int i = 0; i < plainText.length(); i++) {
			temp = (char)(plainText.charAt(i)+key);
			//Validate if character is not in the range
			while (temp > UPPER_BOUND) {
			    temp -= RANGE;  
		    }
			encryptedText += temp;
		}
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptText = "";
		char temp;
	    int key;
		// For loop. Encrypt a string variable by Bellaso Cipher.
		for (int i = 0; i < plainText.length(); i++) {
		    key = bellasoStr.charAt(i%bellasoStr.length());
			temp = (char)(plainText.charAt(i)+key);
			//Validate if character is not in the range
			while (temp > UPPER_BOUND) {
		        temp -= RANGE;
	        }
			encryptText += temp;
		}
		return encryptText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptText = "";
		int temp;
		// Decrypt a string variable
		for (int i = 0; i < encryptedText.length(); i++) {
			temp = encryptedText.charAt(i)-key;
			//Validate if character is not in the range
			while (temp < LOWER_BOUND) {
			    temp += RANGE;
		    }
		    decryptText += (char)temp;
		}
		return decryptText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptText = "";
		int temp;
		int key;
        // Decrypt a string variable
		for (int i = 0; i < encryptedText.length(); i++) {
		    key = bellasoStr.charAt(i%bellasoStr.length());
			temp = (encryptedText.charAt(i)-key);
			//Validate if character is not in the range
			while (temp < LOWER_BOUND) {
		        temp += RANGE;
	        }
			decryptText += (char)temp;
		}
		return decryptText;
	}
}