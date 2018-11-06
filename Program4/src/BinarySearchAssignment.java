import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;

import java.util.Scanner;

public class BinarySearchAssignment {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("BS_Nums1.txt"));
		Scanner find = new Scanner(new File("BS_Nums2.txt"));

		int[] numOne = new int[100];
		int i = 0;
		while (in.hasNextInt()) {
			numOne[i++] = in.nextInt();
		}

		// System.out.println(Arrays.toString(numOne));
		selectionSort(numOne);
		System.out.println(Arrays.toString(numOne));

		// int j = 0;
		while (find.hasNextInt()) {
			int search = find.nextInt();
			// search[j++] = find.nextInt();

			System.out
					.println("looking for number " + search + " found at index number " + binarySearch(numOne, search));
			
			// System.out.println(
			//

			// " Looking for " + search + " found at index number " +
			// Arrays.binarySearch(numOne, search));
		}
		System.out.println("negative number means not found");

	}

	public static void selectionSort(int[] a) {
		// find index of largest element
		for (int i = a.length - 1; i > 0; i--) {
			int largest = i;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > a[largest]) {
					largest = j;
				}
			}
			swap(a, i, largest);// swaps the Largest to the back
		}
	}
	public static void swap(int[] a, int i, int j) {
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	public static int binarySearch(int[] a, int target) {
		int min = 0;
		int max = a.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			if (a[mid] < target) {
				min = mid + 1;
			} else if (a[mid] > target) {
				max = mid - 1;
			} else {
				return mid; // target found
			}
		}

		return -(min + 1); // target not found
	}

}
