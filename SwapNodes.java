public class SwapNodes {

    public static Node<Integer> swap(Node<Integer> head, int i , int j){

        if(i == j){
            return head;
        }
        Node<Integer> currNode = head , prev = null;
        Node<Integer> curr1 = null , curr2 = null , prev1 = null , prev2 = null;

        int pos=0;
        //firstly we have to put our 4 pointer at their desired position
        while(currNode != null){

            if(pos == i){
                prev1 = null;
                curr1 = currNode;
            }else if( pos == j){
                prev2 = null;
                curr2 = currNode;
            }
            prev = currNode;
            currNode = currNode.next;
            pos+=1;
        }

        if(prev1 != null){ //means two nodes are adjacent each other
            prev1.next = curr2;
        }else{ //means i = 0;
            head = curr1;
        }

        if(prev2 != null){ //means normal case all pointer at their desired position
            prev2.next = curr1;
        }else{
            head = curr1;
        }

        Node<Integer> temp;
        temp = curr2.next;
        curr2.next = curr1.next;
        curr1.next = temp;

        return head;
    }
}
