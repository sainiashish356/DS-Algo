public class abbreviation {

    public static void main(String[] args) {
        String str = "pep";
        abbrev(str , "" , 0 ,0);
    }

    public static void abbrev(String str , String asf , int count , int pos){

        if(pos == str.length()){
            if(count == 0){
                System.out.println(asf);
            }else{
                System.out.println(asf + count);
            }
                        return;
        }

        if(count > 0) {
            abbrev(str, asf + count + str.charAt(pos), count, pos + 1);
        }else{
            abbrev(str, asf + str.charAt(pos), count, pos + 1);
        }
        abbrev(str , asf  , count+1 , pos +1 );
    }
}
