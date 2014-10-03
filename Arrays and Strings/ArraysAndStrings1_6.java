package CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * Problem: Given and image represented by an N*N matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees, and do this in place.
 * @author apple
 *
 */
/*
 * Solution: copy the values one layer by one layer, and each layer, first keep the value of
 * the top, and then copy left to top, bottom to left, right to bottom and finally top to right.
 * 
 */
public class ArraysAndStrings1_6 {
	public static void main (String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		rotateImage(matrix);
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
	}
	public static void rotateImage (int[][] matrix) {
		int first, last;
		int offset;
		int topValue;
		
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			first = layer;
			last = matrix.length - first - 1;
			for (int j = 0; j < last - first; j++) {
				offset = j - first;
				topValue = matrix[first][j];
				matrix[first][j] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[first + j][last];
				matrix[first + j][last] = topValue;
			}
		}
	}
}
