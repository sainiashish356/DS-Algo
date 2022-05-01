public class printEncoding {

    public static void main(String[] args) {
        String str = "123";
        printAllPossibility(str);
    }
    
       public static char getChar(int n){
        return (char)(n+96);
    }

    public static void printAllPossibility(String str){
        printAllPossibility(str , "");
    }

    public static void printAllPossibility(String str, String ans) {
        
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        int firstdigit = str.charAt(0) - '0';
        printAllPossibility(str.substring(1) , ans + getChar(firstdigit));

        if(str.length() > 1){

            int firsttwodigit = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
            if(firsttwodigit >= 10 && firsttwodigit <= 26){
                printAllPossibility(str.substring(2) , ans + getChar(firsttwodigit));
            }

        }

    }

}
