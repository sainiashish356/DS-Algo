import java.util.Scanner;

public class printIthNode {

    public static void main(String[] args) {
    Node<Integer> head = takeIp();
        ithNode(head, 2);
    }

    public static void ithNode(Node<Integer> head , int i){

          int count = 0;
          Node<Integer> temp = head;
          while(temp != null){
              if(count == i){
                  System.out.println(temp.data + " ");
                  break;
              }
              count++;
              temp = temp.next;
          }
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
}
