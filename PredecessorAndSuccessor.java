public class PredecessorAndSuccessor {

    static TreeNode<Integer> predecessor;
    static TreeNode<Integer> successor;
    static int state;
    public static void predAndSucc(TreeNode<Integer> root , int data){
        if(state == 0){
              if(root.data == data){
                  state = 1;
              }else{
                  predecessor = root;
              }
        }else if(state == 1){
            successor = root;
            state = 2;
        }

        for(TreeNode<Integer> child : root.children){
            predAndSucc(child , data);
        }
    }
}
