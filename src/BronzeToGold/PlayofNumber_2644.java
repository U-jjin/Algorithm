package BronzeToGold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
숫자놀이
https://www.acmicpc.net/problem/1755


 */

public class PlayofNumber_2644 {
    static class alpaNum implements Comparable<alpaNum>{
        int num;
        String alpa;

        public alpaNum(int num){
            this.num = num;
            int tens = num/10;
            int ones = num%10;

            String str ="";
            if(tens != 0) str +=convertAlpa(tens)+" ";
            str+=convertAlpa(ones);

            alpa = str;
        }
        @Override
        public int compareTo(alpaNum o) {
            return this.alpa.compareTo(o.alpa);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer (br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<alpaNum> list =new ArrayList<>();
        for(int i=M; i<=N; i++){
            list.add(new alpaNum(i));
        }

        Collections.sort(list);


        for(int i=0; i<list.size();i++){
            bw.write(list.get(i).num+" ");
            if((i+1)%10 == 0) bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public String convertAlpa(int num){
        return switch (num) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "siz";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }
}