import java.util.*;
public class queueImplementPep {

    public static class CustomQueue{
        private int[] data;
        private int front;
        private int size;
        private int rear;

        public CustomQueue(int capacity){
            int[] data = new int[capacity];
            int front = -1;
            int size = 0;
            int rear = -1;
        }
        public int size(){
            return size;
        }

         int front() {
            if(size == 0){
                System.out.println("Queue Empty");
            }
            return data[front];
         }

         void add(int elem){
            if(size == data.length){
               doubleCapacity();
            }
            if(size == 0){
                front = 0;
            }
            rear++;
             size++;
             if(rear == data.length){
                 rear = 0;
             }
            data[rear] = elem;

         }

        private void doubleCapacity() {
            int temp[] = data;
            data = new int[2*temp.length];
            int index = 0;
            for(int i = front ; i < temp.length; i++){
                data[index] = temp[i];
                index++;
            }
            for(int i = 0; i <= front - 1;i++){
                data[index] = temp[i];
                index++;
            }
        }

        int remove(){
            if(size == 0){
                System.out.println("Stack Empty");
            }
            int temp = data[front];
            front++;
            if(front == data.length){
                front = 0;
            }

            size--;
            if(size == 0){
                rear = -1;
                front = -1;
            }
            return temp;
         }

    }


    public static void main(String[] args) {
        Queue<Integer>  que = new ArrayDeque<>();
         que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);

        System.out.println(que.remove());
        System.out.println(que);

    }
}
