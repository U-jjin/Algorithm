package Programmers;

import java.util.ArrayList;
/*
https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */

public class EnglishEndTalk {

    public static void main(String[] args) {

    solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }

    public static void solution(int n, String[] words) {
        int[] answer = {0,0};

        int cnt =1; //순서가 몇번째 인지
        ArrayList<String> checklist =new ArrayList<>();
        checklist.add(words[0]);

        char lastAlpa = words[0].charAt(words[0].length()-1);

        for(int i=1; i<words.length ;i++){
            cnt ++;
            if(lastAlpa != words[i].charAt(0) || checklist.contains(words[i])){
                answer[0] = cnt%n == 0 ? n :cnt%n;
                answer[1] = (cnt/n);
                break;
            }
            checklist.add(words[i]);
            lastAlpa = words[i].charAt(words[i].length()-1);

        }

       System.out.println(answer[0]+" "+answer[1]);
    }
}
