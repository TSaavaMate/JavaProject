import java.util.Arrays;
import java.util.stream.IntStream;

public class Array {
    private int[] items;
    private int counter;
    public Array(int size){
        items=new int[size];
    }
    public void add(int item){
        if (counter==items.length) throw new IllegalCallerException("ilegal");
        items[counter++]=item;
    }
    public void reverse(){
        var newItems=new int[counter];
        for (int i=0;i<counter;i++){
            newItems[i]=items[items.length-i-1];
        }
        items=newItems;
    }

    public int max(){
        int maxNum=0;
        for (int num:items){
            if (num>maxNum) num=maxNum;
        }
        return maxNum;
    }

    public int indexOf(int item){
        int index=-1;
        for (int i=0;i<items.length;i++)
            if (items[i]==item) index=i;
        return index;
    }
    public void removeAt(int index){
        for (int i=index;i<items.length;i++)
            items[i]=items[i+1];

        counter--;

    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
