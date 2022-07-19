public class FindElement {

    public static boolean find(TreeNode<Integer> root , int data){
        if(root.data == data){
            return true;
        }

        for(TreeNode<Integer> child : root.children){
            boolean findData = find(child , data);
            if(findData){
                return  true;
            }
        }
        return false   ;
    }
}
