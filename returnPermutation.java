public class returnPermutation {
    
    public static String[] returnPer(String str){

        if(str.length() == 0){
            String[] ans = {""};
            return ans;
        }

        String[] restofPer = returnPer(str.substring(1));
        String[] allPerm = new String[str.length()*restofPer.length];

        int k = 0;
        //iterate over recursive ans
        for(String str1 : restofPer){
            for(int i = 0; i < str1.length();i++){
                allPerm[k++] = str1.substring(0, i) + str.charAt(0)+ str1.substring(i);
            }
        }
        return allPerm;


    }

}
