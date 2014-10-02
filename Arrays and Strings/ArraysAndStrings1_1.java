package CrackingTheCodingInterview;


/**
 * Problem: Implement an algorithm to determine if a string has all 
 * unique characters. What if you cannot use additional data structures?
 *
 * @author HXX
 *
 */
public class ArraysAndStrings1_1 {
	public static void main (String[] args) {
		String str = "abcdeccc";
		System.out.println(isUnique_bitmap(str));
	}
	
	// use a hashmap to record whether the character has already existed.
	public static boolean isUnique_hashtable (String str) {
		if (str == null || str.length() <= 1) {
			return true;
		}
		if (str.length() > 52) {  // if there are more than 52 chacaters, not unique
			return false;
		}
		
		int size = 52;
		boolean[] has = new boolean[size];
		int index;
		for (int i = 0; i < str.length(); i++) {
			index = str.charAt(i) < 'a' ? str.charAt(i) - 'A' : str.charAt(i) - 'a';
			if (has[index]) {
				return false;
			} 
			has[index] = true;
		}
		return true;
	}
	// for reducing the space, we can use bitmap to record, where each bit record one charater
	// assume that in this case, we only consider lower case characters for a to z;
	public static boolean isUnique_bitmap (String str) {
		if (str == null || str.length() <= 1) {
			return true;
		}
		if (str.length() > 26) {
			return false;
		}
		int bitmap = 0;
		int offset;
		for (int i = 0; i < str.length(); i++) {
			offset = str.charAt(i) - 'a';
			if (((bitmap >> offset) & 1) == 1) {
				return false;
			}
			bitmap |= (1 << offset);
		}
		return true;
	}
}





















