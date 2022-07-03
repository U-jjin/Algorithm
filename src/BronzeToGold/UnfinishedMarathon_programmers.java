package BronzeToGold;

import java.io.*;
import java.util.HashMap;

//프로그래머스 완주하지 못한 선수
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class UnfinishedMarathon_programmers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int i=0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(String name : participant){
                map.put(name,map.getOrDefault(name,0)+1);
        }

        for(String com: completion){
            map.put(com,map.get(com)-1);
        }
        for(String result: participant){
            if(map.get(result) >0) {
                answer =result;
                break;
            }
        }
        return answer;
    }
}