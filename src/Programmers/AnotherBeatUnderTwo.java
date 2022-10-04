package Programmers;

import java.util.ArrayList;

public class AnotherBeatUnderTwo {
    public static void main(String[] args) {

        long [] numbers = {2,7};
        for(Long a : solution(numbers)){
            System.out.println(a);
        }


    }

    public static ArrayList<Long> solution(long[] numbers) {
        ArrayList<Long> answer =new ArrayList<>();
        String [] binarys =new String[numbers.length];

        //이진수로 변환
        for(int i=0; i<numbers.length; i++){
            binarys[i]= convertToBinary(numbers[i]);

            for(long j = numbers[i]+1; ;j++){
                String comparenum = convertToBinary(j);

                binarys[i] ="0".repeat(comparenum.length()-binarys[i].length())+binarys[i];
                System.out.println(binarys[i]+" "+comparenum);

                if(compareToBinary(binarys[i].toCharArray(),comparenum.toCharArray())<=2){
                    answer.add(j);
                    break;
                }
            }



        }


        return answer;
    }

    public static String convertToBinary(long num){
        String binary = "";

        while(num>0){
            binary = (num%2)+binary;
            num /=2;
        }
        return binary;
    }
    public static long compareToBinary(char[] target, char[] compareNum){
        long cnt =0;
        for(int i=0;i<target.length; i++){
            if(target[i] != compareNum[i]) cnt ++;
        }
        System.out.println("another beat:"+cnt);
        return cnt;

    }

}
