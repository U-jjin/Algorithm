package CodingTest;

import java.io.*;
import java.util.*;


class burger {
    public static class Burger implements Comparable<Burger>{
        int heatingTime;
        int eatingTime;

        public Burger(int eatingTime, int heatingTime) {
            this.heatingTime = heatingTime;
            this.eatingTime = eatingTime;
        }

        @Override
        public int compareTo(Burger o) {
            if( o.eatingTime == this.eatingTime) return o.heatingTime - this.heatingTime;
            else return o.eatingTime-this.eatingTime;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        StringTokenizer eatToken =new StringTokenizer(br.readLine());
        StringTokenizer heatToken =new StringTokenizer(br.readLine());

        List <Burger> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            list.add(new Burger(Integer.parseInt(eatToken.nextToken()), Integer.parseInt(heatToken.nextToken())));
        }
        Collections.sort(list);

        int total=0;
        int canHeatTime =0;
        for(Burger b : list){
            canHeatTime += b.heatingTime;
            total = Math.max(total, canHeatTime + b.eatingTime);
        }
        System.out.println(total);
    }
}