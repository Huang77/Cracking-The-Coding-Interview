package CrackingTheCodingInterview;

import java.util.Arrays;
/**
 * Problem: Write a method to replace all spcaces in a string with '%20'.You may assume that the string
 * has sufficient space at the end of the string to hold the additional characters, and that you are
 * given the "true" length of the string. (Note: if implementing in Java, please use a character array 
 * so that you can perform this operation in place.)
 * @author Huang77
 *
 */


/**
 * Solution: first count the length of the new string, and then copy the string from back to end
 * to avoid copy large amount of characters every time you add a "%20"
 * @author Huang77
 */
public class ArraysAndStrings1_4 {
	public static void replaceSpace (char[] str, int len) {
		if (str == null) {
			return;
		}
		int spaceCount = 0;
		for (int i = 0; i < len; i++) {
			if (str[i]== ' ') {
				spaceCount++;
			}
		}
		
		int newLen = len + spaceCount * 2;
		int i = len - 1, j = newLen - 1;
		while (i >= 0) {
			if (str[i] != ' ') {
				str[j--] = str[i];
			} else {
				str[j--] = '0';
				str[j--] = '2';
				str[j--] = '%';
			}
			i--;
		}
	}
}
