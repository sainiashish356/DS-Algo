import java.util.Scanner;

public class RemoveConsecutiveDuplicates {


    public static void main(String[] args) {
        Node<Integer> head = takeIp();
        head = removeDuplicates(head);
        print(head);
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


    public static Node<Integer> removeDuplicates(Node<Integer> head){

           if(head == null || head.next == null){
               return head;
           }

           Node<Integer> prev = head;
           Node<Integer> temp = head.next;

           while(temp != null){
               if(prev.data.equals(temp.data)){
                   prev.next = temp.next;
                   temp = temp.next;
               }else{
                   prev = temp;
                   temp = temp.next;
               }
           }
            return head;
    }

}
