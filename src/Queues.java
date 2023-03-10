import java.util.Arrays;

public class Queues {
    private int[] array;
    private int front;
    private int back;
    private int count;
    public Queues(int size){
        array=new int[size];
    }
    public void enqueue(int item){
        array[back]=item;
        back = (back + 1) % array.length;
        count++;
    }
    public void dequeue(int item){
        array[front]=0;
        front++;
        count--;
    }
    public int peek(){
        return array[front];
    }
    public boolean isEmpty(){
        return count==0;
    }
    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(array,front,back));
    }

}
