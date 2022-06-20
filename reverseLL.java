import java.util.Scanner;

public class reverseLL {

    public static void main(String[] args) {
        Node<Integer> head = takeIp();
        head = reverseBetter(head);
        print(head);
    }

    public static Node<Integer> reverseIterative(Node<Integer> head){

        if(head== null || head.next == null){
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> temp;

        while( curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }

    public static Node<Integer> reverseBetter(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
            Node<Integer> reverseTail = head.next;
            Node<Integer> nHead = reverseBetter(head.next);
            reverseTail.next = head;
            head.next = null;
            return nHead;
            }

    public static Node<Integer> reverseRec(Node<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> finalHead = reverseRec(head.next);
        Node<Integer> temp = finalHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return finalHead;
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
