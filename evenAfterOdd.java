public class evenAfterOdd {

    public static Node<Integer> EvenAfterOdd(Node<Integer> head){

           if(head == null){
               return head;
           }

           Node<Integer> EHead = null , Etail = null , OHead = null , OTail = null;

           while(head != null){

                if(head.data % 2 == 0){
                    if(EHead == null){
                        EHead = head;
                        Etail = head;
                    }else{
                        Etail.next = head;
                        Etail = Etail.next;
                    }
                }else{
                    if(OHead == null){
                        OHead = head;
                        OTail = head;
                    }else{
                        OTail.next = head;
                        OTail = OTail.next;
                    }
                }
               head = head.next;
           }
           if(OHead == null){
               return EHead;
           }
           if(EHead == null){
               return OHead;
           }
           Etail.next = OHead;
           OTail.next = null;
           return EHead;

    }
}
