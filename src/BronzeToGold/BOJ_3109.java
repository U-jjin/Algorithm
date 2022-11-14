package BronzeToGold;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class BOJ_3109 {

    static class hi implements Comparable<hi>{


        @Override
        public int compareTo(hi o) {
            return 0;
        }
    }
    public static void main(String[] args) {

        double a = 4.2345;

        System.out.println(Math.ceil(a));

        System.out.println(String.format("%.4f",a));

        Queue<String> queue =new PriorityQueue<>();
        queue.offer("jhef"
        );

        TreeSet<String> set =new TreeSet<>(new Comparator<String>(){


            @Override
            public int compare(String o1, String o2) {
                return 0;
            }


        });
    }

}
