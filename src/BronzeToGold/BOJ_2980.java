package BronzeToGold;

/*

https://www.acmicpc.net/problem/2980

    빨간불 신호 시간
    파란불 신호 시간
    - 무한히 반복
    - 도로 진입시, 무조건 빨간 불이며 사이클 시작.
    - 1초에 1미터 이동
    - 빨간 불일 경우, 멈추고 초롭불일때 이동

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        //신호등의 갯수
        int N = Integer.parseInt(st.nextToken());
        //도로의 길이
        int L = Integer.parseInt(st.nextToken());

        //현재 시간
        int currentTime = 0;
        //현재 위치
        int currentLocation =0;


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            //해당 신호등의 위치 :Distance
            int D = Integer.parseInt(st.nextToken());
            //빨간불 지속 시간 :Red
            int R = Integer.parseInt(st.nextToken());
            //파란불 지속 시간 :Green
            int G = Integer.parseInt(st.nextToken());

            //신호등 도착 시간
            currentTime +=(D-currentLocation);
            //형대 위치
            currentLocation = D;

            //대기해야하는 시간
            int waitingTime = R-(currentTime%(R+G));
            if(waitingTime>0){
                currentTime += waitingTime;
            }
            //맨 마지막 신호등에서 도착지까지의 시간 더하기
            if(i == N-1){
                currentTime += (L-D);
            }
        }

        System.out.println(currentTime);

    }

}
