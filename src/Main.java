import java.util.*;

public class Main {
    public static void main(String[] args)  {
        System.out.println(firstRepeat("abcddacb"));


    }
    private static Character firstRepeat(String str){
        Set<Character> set=new HashSet<>();
        for (char ch:str.toCharArray()){
            if (set.contains(ch))
                return ch;
            else
                set.add(ch);
        }
        return Character.MIN_VALUE;
    }
    private static Character nonRepeat(String str){
        Map<Integer,Character> map=new HashMap<>();
        int smallestIndex;

        for (int i=0;i<str.length();i++){
            if (map.containsValue(str.charAt(i)))
                map.remove(str.indexOf(str.charAt(i)));
            else
                map.put(i,str.charAt(i));
        }

        if (!(map.keySet().isEmpty())) {
            smallestIndex = Collections.min(map.keySet());
            return map.get(smallestIndex);
        }
        return Character.MIN_VALUE;





    }





}



