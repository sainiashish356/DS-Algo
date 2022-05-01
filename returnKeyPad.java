import java.util.ArrayList;
import java.util.Arrays;

public class returnKeyPad {

    public static void main(String[] args) {
        int num = 234;
        String[] ans = returnKeypad(num);
        System.out.println(Arrays.toString(ans));

    }
    
    public static char[] numberoptions(int n){
        switch(n){
            case 2:
            char options2[] = {'a','b','c'};
            return options2; 
            case 3:
            char options3[] = {'d','e','f'};
            return options3; 
            case 4:
            char options4[] = {'g','h','i'};
            return options4; 
            default : 
            char options[] = {'\0'};
                return options;
        }
    }

    public static String[] returnKeypad(int n){

        if(n == 0){
            String ans[] = {""};
            return ans;            
        }

        int lastDigit = n % 10;
        int smallNumber = n / 10;

        String smallAns[] = returnKeypad(smallNumber);
        char options[] = numberoptions(lastDigit);
            //output array
        String ans[] = new String[smallAns.length * options.length];
        //we took pointer k for indexing for the final output array
        int k = 0;
        for(int i = 0; i < smallAns.length;i++){
            for(int j = 0; j < options.length;j++){
                ans[k] = smallAns[i] + options[j];
                k++;
            }
        }
        return ans;
    }


    //Another approach

    static String[] codes = {".;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" ,"tu" , "vwx" , "yz"};

        public static ArrayList<String> getKPC(String str){
            if(str.length() == 0){
                ArrayList<String> bres = new ArrayList<>();
                bres.add("");
                return bres;
            }
            //678
            char ch = str.charAt(0); // 6
            String ros = str.substring(1); //78 

            ArrayList<String> rres = getKPC(ros);
            ArrayList<String> mres = new ArrayList<>();//24 words for 678

            //fetch characters of first char which is 6 "pqrs"
            String codeForch = codes[ch - '0'];
            
            for(int i = 0; i < codeForch.length();i++){
                char chCode = codeForch.charAt(i);
                //now we run loop over recursion result
                for(String rstr : rres){
                    mres.add(chCode + rstr);
                }
                
            }

            return mres;
        }

}
