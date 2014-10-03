package CrackingTheCodingInterview;

/**
 * Problem: Implement a method to perform basic string compression using the counts of 
 * repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the 
 * "compressed" string would not become smaller than the original string, your method should
 * return the original string.
 * @author apple
 *
 */

public class ArraysAndStrings1_5 {
	public static void main (String[] args) {
		String str = "aabcccccaaa";
		System.out.println(compress(str));
	}
	public static String compress (String str) {
		if (str == null) {
			return null;
		}
		StringBuffer newStr = new StringBuffer();  // use string buffer!!!! not just string+string...
		char lastChar = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == lastChar) {
				count++;
			} else {
				newStr.append(lastChar);
				newStr.append(count);
				lastChar = str.charAt(i);
				count = 1;
			}
		}
		newStr.append(lastChar);
		newStr.append(count);
		if (newStr.length() > str.length()) {
			return str;
		} 
		return newStr.toString();
	}
}
