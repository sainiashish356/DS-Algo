import java.util.*;
public class Celebrity  {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[][] M = new int[N][N];
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j< N ; j++){
                M[i][j] = scn.nextInt();
            }
        }
        System.out.println(celebrity(M,N));
    }

     public static int celebrity(int M[][], int n) {

         Stack<Integer> stack = new Stack<>();
         for (int i = 0; i < n; i++) {
             stack.push(i);
         }
         while (stack.size() >= 2) {
             int i = stack.pop();
             int j = stack.pop();

             if (M[i][j] == 1) {
                 //here it means that i knows j so I cant be celebrity
                 stack.push(j);
             } else {
                 stack.push(i);
             }
         }
         int celeb = stack.pop();
         for (int i = 0; i < n; i++) {
             if (i != celeb) {
                 if (M[i][celeb] == 0 || M[celeb][i] == 1) {
                     return -1;
                 }
             }


         }
         return celeb;
     }
}
