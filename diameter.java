public class diameter {

    static int dia = 0;
    public static int calcDiameter(TreeNode<Integer> root){
        int deepestChildheight = -1;
        int secDeepChild = -1;
        
        for(TreeNode<Integer> child : root.children){
            int ch = calcDiameter(child);
            if(ch > deepestChildheight){
                secDeepChild = deepestChildheight;
                deepestChildheight = ch;
                
            } else if (ch > secDeepChild) {
                    secDeepChild = ch;
            }
        }

        int currCount = deepestChildheight + secDeepChild + 2;

        if(currCount > dia){
            dia = deepestChildheight + secDeepChild + 2;
        }
            deepestChildheight += 1;
        return deepestChildheight;
    }
}
