public class checkAB {
    
    public static boolean check(String str){
        if(str.length() == 0){
            return true;
        }

        if(str.charAt(0) == 'a'){
            if(str.substring(1).length() > 1 && str.substring(1,3).startsWith("bb")){
                return check(str.substring(1));
            }else{
                return check(str.substring(1));
            }
        }
        return false;
    }


}
