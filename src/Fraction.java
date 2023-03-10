import streams.Genre;

import java.lang.reflect.Array;

public class Fraction {
    private int numerator;

    private int denominator;
    private Genre genre;

    public Fraction(int numerator, int denominator,Genre genre) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.genre=genre;
    }
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.genre=null;
    }

    public String asFraction(){
        return String.format("%d/%d",numerator,denominator);
    }

    public String multiply(Fraction fraction){
        int newnumerator=this.numerator*fraction.numerator;
        int newdenominator=this.denominator*fraction.denominator;
        if (gcd(newnumerator,newdenominator)>1) {
            int gcd=gcd(newnumerator,newdenominator);
            newnumerator=newnumerator/gcd;
            newdenominator=newdenominator/gcd;
        }
        return new Fraction(newnumerator,newdenominator).asFraction();

    }
    public String divide(Fraction fraction){
        return multiply(new Fraction(fraction.denominator,fraction.numerator));
    }




    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int gcd(int a,int b){
        for (int i=Math.max(a,b);i>0;i--){
            if (a%i==0 && b%i==0)
                return i;
        }
        return 1;
    }
}
