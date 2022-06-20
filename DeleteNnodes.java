import java.util.Scanner;

public class DeleteNnodes {

    public static void main(String[] args) {
        Node<Integer> head = takeIp();
        head = deleteNNODES(head , 2 ,3);
        print(head);
    }

    public static Node<Integer> deleteNNODES(Node<Integer> head , int M , int N){

            Node<Integer> curr = head;
            Node<Integer> temp = null;

            while(curr != null){

                for(int i = 1 ; curr!= null && i < M ; i++){
                    curr = curr.next;
                }
                if(curr == null){
                    return head;
                }
                temp = curr.next;
                for(int i = 1; temp != null && i <= N; i++){
                    temp = temp.next;
                }
                curr.next = temp;
                curr = temp;
            }
            return  head;

    }

    public static Node<Integer> takeIp(){
        Node<Integer> head = null , tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while(data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
//                Node<Integer> temp = head;
//                while(temp.next != null){
//                    temp = temp.next;
//                }
//                temp.next = newNode;
                tail.next = newNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
