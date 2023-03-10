package lambdas;

import java.util.HashMap;
import java.util.function.*;

public class LambdasDemo {
  public static void show() {
    ///connsumer
    Consumer<String> print=item->System.out.println(item);
    var mapp=new HashMap<String,Integer>();
    mapp.put("name",12);
    System.out.println(mapp);

    ///Supplier
    Supplier<Integer> getrandom=()-> (int)Math.round(Math.random() * 100);
    System.out.println(getrandom.get());

    ///Functional
    Function<String,Integer> map= String::length;
    Function<String,String> replaceColon=str->str.replace(":","=");
    Function<String,String> addBrackets=str->"{"+str+"}";
    map.apply("hah");

    //Predicate
    Predicate<String> islongerthan5=str->str.length()>5;
    islongerthan5.test("stringmorethan5");

    //BinaryOp
    BinaryOperator<Integer> add= Integer::sum; //methodRef
    BinaryOperator<Integer> add2=(a,b)-> a + b ;

    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var result = increment.andThen(square).apply(1);

  }
}
