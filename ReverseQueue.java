import java.util.Queue;

public class ReverseQueue {


    public static void reverseQueue(Queue<Integer> input){
        if(input.size() <= 1){
            return;
        }
            //storing first element
            int temp = input.poll();

            reverseQueue(input);

            input.add(temp);
    }

}
