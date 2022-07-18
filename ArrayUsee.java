import java.util.Scanner;

public class ArrayUsee {

    public static int[] takeinput(){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int input[] = new int[size];
        for(int i = 0 ; i < size ; i++){
            input[i] = scn.nextInt();
        }
        return input;
    }
    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length;  i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
      int arr[] = takeinput();
      print(arr);


    }


}
