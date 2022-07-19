public class isSymmetric {

    public static boolean areMirror(TreeNode<Integer> n1 ,TreeNode<Integer> n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0 ; i < n1.children.size() ;i++){
            //getting the right most child of n2 tree
            int j = n1.children.size() - 1 - i;
            TreeNode<Integer> c1 = n1.children.get(i);
            TreeNode<Integer> c2 = n2.children.get(j);
            if(areMirror(c1 ,c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean treeSymmetric(TreeNode<Integer> root){
        return areMirror(root , root);
    }
}
