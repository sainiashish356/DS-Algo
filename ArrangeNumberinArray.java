import java.util.Scanner;

public class ArrangeNumberinArray {

    //input = 5


    public static void Arrange(int[] arr ,int n){
        int left = 0;
        int right = n-1;
        int val = 1;

        while(left <= right){
            if(val % 2 == 1){
                arr[left] = val;
                left++;
                val++;
            }else{
                arr[right] = val;
                right--;
                val++;
            }
        }

    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[n];
        Arrange(arr , n);
        printArray(arr);
    }

}
