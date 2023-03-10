public class Stacks {
    private int[] array=new int[5];
    private int size;
     public void push(int num){
//         if (size == array.length)
//             throw new StackOverflowError();
         array[size++]=num;
     }
     public int pop(){
         return array[--size];

     }
}
