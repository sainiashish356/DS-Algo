import java.util.Scanner;

public class AppendLastNtoFirst {

    public static void main(String[] args) {
        Node<Integer> head = takeIp();
        head = AppenndLasttoFirst(head , 3);
        print(head);
    }

    public static int length(Node<Integer> head){

        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }


    public static Node<Integer> AppenndLasttoFirst(Node<Integer> head , int n){
                if(n == 0 || head == null ){
                    return head;
                }

              int length = length(head);
                int skip = length - n;

                Node<Integer> prev = null;
                Node<Integer> curr = head;

                //skip starting node
                while(skip > 0){
                    prev = curr;
                    curr = curr.next;
                    skip--;
              }
                //now we separate our skipped nodes
                prev.next = null;
                Node<Integer> temphead = head;
                head = curr;

                //find last node
            while(curr.next != null){
                curr = curr.next;
            }
            //now we change append our skipped nodes at the last
            curr.next = temphead;
            return head;


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

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
