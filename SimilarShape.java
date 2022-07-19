public class SimilarShape {

    public static boolean areSimilar(TreeNode<Integer> n1 , TreeNode<Integer> n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0 ; i < n1.children.size() ;i++){
            TreeNode<Integer> c1 = n1.children.get(i);
            TreeNode<Integer> c2 = n2.children.get(i);
            if(areSimilar(c1 ,c2) == false){
                return false;
            }
        }
        return true;
    }
}
