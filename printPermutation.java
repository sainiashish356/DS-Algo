import java.util.ArrayList;

public class printPermutation {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = printPer(str, "");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    

    static ArrayList<String> printPer(String str , String asf){
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> mres = new ArrayList<>();

        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);

            String lpart = str.substring(0, i);
            String rpart = str.substring(i+1);
            String ros = lpart + rpart;
            ArrayList<String> ans = printPer(ros, asf + ch);

            for(String rstr : ans){
                mres.add(rstr);
            }
        }
        return mres;
        
    }
    // static void printPer(String str , String asf){
    //     if(str.length() == 0){
    //         System.out.println(asf);
    //         return;
    //     }

    //     for(int i = 0; i < str.length();i++){
    //         char ch = str.charAt(i);

    //         String lpart = str.substring(0, i);
    //         String rpart = str.substring(i+1);
    //         String ros = lpart + rpart;
    //         printPer(ros, asf + ch);
    //     }
        
    // }
}
