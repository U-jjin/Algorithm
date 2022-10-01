package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compression {
    static ArrayList<Integer> answer =new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<String> dictList =new ArrayList<>();
        for(char c='A'; c<='Z'; c++){
            dictList.add(c+"");
        }

        LZW(dictList,"KAKAO");

        for(int a : answer){
            System.out.print(a+" ");
        }
    }
    static  public void LZW(List<String> dictList, String str) {
        System.out.println();
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {

            String subStr = str.substring(0, i + 1);


            // 만약 사전에 없다면 사전에 등록하기 그리고 현재 문자 or 문자열 인덱스 값 출력,
            // 현재 문자 or 문자열 다음의 문자에서 다시 시작
            if (!dictList.contains(subStr)){
                dictList.add(subStr);
                answer.add(dictList.indexOf(str.substring(0,i))+1);
                LZW(dictList, str.substring(i));
                break;
            }else{
                //맨 마지막 인덱스라면 더해주고 끝내기
                if(i+1 == str.length()){
                    answer.add(dictList.indexOf(subStr)+1);
                }
                System.out.println(dictList.indexOf(subStr)+" "+subStr);
            }
        }
    }
}

