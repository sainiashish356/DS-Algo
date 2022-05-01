public class staircase {
    
    public static int countStaircase(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        return countStaircase(n-1) + countStaircase(n-2) + countStaircase(n - 3);
    }

    public static void main(String[] args) {
        int n = 4;
        int ans = countStaircase(n);
        System.out.println(ans);
    }

}
