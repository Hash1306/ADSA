// Merge Sort Implementation in Java

import java.util.Scanner;

 

public class MergeSort {

   

   // Function to merge two halves

   void merge(int arr[], int left, int mid, int right) {

       int n1 = mid - left + 1;

       int n2 = right - mid;

 

       int L[] = new int[n1];

       int R[] = new int[n2];

 

       // Copy data into temp arrays

       for (int i = 0; i < n1; i++)

           L[i] = arr[left + i];

       for (int j = 0; j < n2; j++)

           R[j] = arr[mid + 1 + j];

 

       int i = 0, j = 0, k = left;

 

       // Merge the temp arrays

       while (i < n1 && j < n2) {

           if (L[i] <= R[j])

               arr[k++] = L[i++];

           else

               arr[k++] = R[j++];

       }

 

       // Copy remaining elements (if any)

       while (i < n1) arr[k++] = L[i++];

       while (j < n2) arr[k++] = R[j++];

   }

 

   // Recursive function to divide array

   void sort(int arr[], int left, int right) {

       if (left < right) {

           int mid = (left + right) / 2;

           sort(arr, left, mid);       // Sort left half

           sort(arr, mid + 1, right);  // Sort right half

           merge(arr, left, mid, right); // Merge halves

       }

   }

 

   // Main function

   public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       System.out.print("Enter number of elements: ");

       int n = sc.nextInt();

       int arr[] = new int[n];

 

       System.out.println("Enter elements:");

       for (int i = 0; i < n; i++)

           arr[i] = sc.nextInt();

 

       MergeSort ms = new MergeSort();

       ms.sort(arr, 0, n - 1);

 

       System.out.println("Sorted array:");

       for (int x : arr)

           System.out.print(x + " ");

   }

}
