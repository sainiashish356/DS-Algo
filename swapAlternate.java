import java.util.Scanner;

public class swapAlternate {
    public static void swap(int[] arr){
        for(int i = 0 ; i < arr.length -1 ; i = i+2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        swap(arr);
        printArray(arr);
    }
}
