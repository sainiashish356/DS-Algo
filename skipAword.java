public class skipAword {



    //another case if we want to remove "app" only but that word shouldn't belong to any word
    // if(up.startsWith("app") && !up.startsWith("apple"))
    
static String skip(String up){
    if(up.isEmpty()){
        return "";
    }

    if(up.startsWith("apple")){
        return skip(up.substring(5));
    }else{
        return up.charAt(0) + skip(up.substring(1));
    }
}

}
