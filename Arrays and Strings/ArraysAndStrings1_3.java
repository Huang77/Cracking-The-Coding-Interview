package CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * Problem: Given two strings, write a method to decide if one is a permutation of the other.
 * @author apple
 *
 */


public class ArraysAndStrings1_3 {
	public static void main (String[] args) {
		String str1 = "abcd";
		String str2 = "acdd";
		System.out.println(solution1(str1, str2));
		System.out.println(solution2(str1, str2));
	}
	/*
	 * Solution1: sort the two strings, and compare whether they are the same.
	 */
	public static boolean solution1 (String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		int i1 = 0, i2 = 0;
		while (i1 < chars1.length && i2 < chars2.length) {
			if (chars1[i1++] != chars2[i2++]) {
				return false;
			}
		}
		return true;
	}
	public static boolean solution2 (String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] counts = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			counts[str1.charAt(i)]++;
			counts[str2.charAt(i)]--;
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
