package Programmers;

import java.util.*;
public class skt2 {
    public static void main(String[] args) {

    }

    static int [] answer =new int [5];
    static int max =0;
    public int[] solution(int[][] receive, int[][] sell) {
        int n =0;
        for(int [] r : receive){
            n++;
        }

        dfs(0, receive, sell,n, new int[n],new int[5],0);
        return answer;
    }


    //해당 재고를 살 경우, 안 살경우 경우의 수를 모두 탐색
    static public void dfs(int day, int[][] receive, int[][]sell, int n, int[]stocks, int[] ans, int sum){
        if(day ==5){
            //결과값 비교 메소드
            compareAnswer(ans,sum);
            return;
        }
        //현재 모든 재고 조사
        for(int i=0; i<n; i++){
            stocks[i] = calStock(stocks[i], receive[i][day], sell[i][day]);
            System.out.print(stocks[i]+" ");

        }
        //모든 경우의 수 체크
        for(int i=0; i<n; i++){
            int tmp = stocks[i];
            stocks[i] =0;
            ans[day] = i;
            sum += tmp;

            System.out.println();
            System.out.println(day+1+"번째날 "+i+"가게의"+tmp +" 선택후 sum:"+sum);
            dfs(day+1, receive,sell,n,stocks,ans,sum);
            sum -= tmp;
            stocks[i] = tmp;
        }
    }
    // 결과 비교 조회 메소드
    static public void compareAnswer(int[]ans, int sum ){
        if(sum > max){
            answer =ans;
            max =sum;
        }else if(sum == max){
            for(int i=0; i<5; i++){
                if(ans[i]<answer[i]){
                    answer = ans;
                    return;
                }
            }
        }else {return;}


    }

    //재고 조사 메소드
    static public int calStock(int stock ,int receive, int sell){
        int s = stock +receive -sell;
        return s<0? 0 :s;
    }
}
