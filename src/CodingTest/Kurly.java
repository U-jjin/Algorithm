package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Kurly {
    public static class Container implements Comparable<Container>{
        int size;
        int color;

        public Container(int size, int color) {
            this.size = size;
            this.color = color;
        }
        @Override
        public int compareTo(Container o) {
            return
                    this.size - o.size !=0? this.size - o.size : this.color-o.color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Container> containers =new TreeSet<>();

        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++){
            int input = Integer.parseInt(br.readLine());
            if(input>0) containers.add(new Container(input,1));
            else containers.add(new Container(Math.abs(input),-1));
        }

        int size = containers.first().size;
        int color = containers.first().color;
        int floor =1;

        for(Container c: containers){
            if(color == c.color || size == c.size) continue;

            floor ++;
            size = c.size;
            color = c.color;
        }
        System.out.println(floor);

    }
}
