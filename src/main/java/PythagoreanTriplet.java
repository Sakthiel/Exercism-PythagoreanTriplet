/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PythagoreanTriplet {
  private int a ;
    private int b;
    private int c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static TripletsList makeTripletsList() {
        return new TripletsList();
    }
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        } else if ( o instanceof PythagoreanTriplet ) {
            PythagoreanTriplet pt = (PythagoreanTriplet) o;
            return a == pt.a && b == pt.b && c == pt.c;
        } else {
            return false;
        }
    }
}
class TripletsList{
    private int sum;
    private Integer maxFactor = null;
    private static final double PERIMETER_RATIO_LIMIT = 1 + 1 + Math.sqrt(2);
    public TripletsList withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }
    public TripletsList thatSumTo(int n) {
            this.sum = n;
            if ( maxFactor == null ) {
                maxFactor = n;
            }
            
            return this;
        }
    public List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            for (int a = 1; a <=maxFactor; a++) {
               for(int b = a ; b<=maxFactor ; b++){
                   int c = sum - a -b ;
                   if(c > maxFactor) continue;
                   if(c*c == a*a + b*b){
                       triplets.add(new PythagoreanTriplet(a, b, c));
                   }
               }
            }
            
        return triplets;
    }
}


