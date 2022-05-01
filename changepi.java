public class changepi{

    public static void main(String[] args) {
        String input = "xpixpi";
        String ans = replaceRec(input);
        System.out.print(ans);
    }


    static String replaceRec(String input){

        if(input.length() == 0){
            return input;
        }

        if(input.startsWith("pi")){
            return "3.14" + replaceRec(input.substring(2));
        }
        return input.substring(0,1) + replaceRec(input.substring(1));
    }


    public static String replacepi(String input){

        String output = "";
        int size = input.length();
        for(int i = 0; i < size;i++){
            if(i < size && input.charAt(i) == 'p' && input.charAt(i+1) == 'i'){
                    output += 3.14;
                    i++;
            }else{
                output += input.charAt(i);
            }

        }
        return output;


    }

}