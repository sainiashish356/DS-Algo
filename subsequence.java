import java.util.ArrayList;

public class subsequence {

    public static void main(String[] args) {
        String up = "abc";
        printSubsequences("", up);
    }
    
    //print subsequence
    public static void printSubsequences(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        //taking the element
        char ch = up.charAt(0);
        printSubsequences(p+ch, up.substring(1));

        //ignoring the element
        printSubsequences(p, up.substring(1));
    }


        //Return Subsequence
        static ArrayList<String> subsequenceReturn(String p , String up){
            
            if(up.isEmpty()){
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }

           //taking the element
        char ch = up.charAt(0);
         ArrayList<String> left =  subsequenceReturn(p+ch, up.substring(1));

        //ignoring the element
        ArrayList<String> right = subsequenceReturn(p, up.substring(1));

        left.addAll(right);
        return left;

        }


        //if we want to return string array of string
        public static String[] returnsubseq(String str){

            if(str.isEmpty()){
                String[] ans = {""};
                return ans;
            }

            
            String[] smallAns = returnsubseq(str.substring(1));
            String[] ans = new String[2*smallAns.length];

            //now we put smallAns in our ans array
            for(int i = 0; i < smallAns.length; i++){
                ans[i] = smallAns[i];
            }

            //now we append the first chat of string to the smallAns array 
            for(int i = 0; i < smallAns.length;i++){
                ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
            }

            return ans;



        }

}
