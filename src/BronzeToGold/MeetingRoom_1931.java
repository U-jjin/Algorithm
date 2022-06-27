package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//회의실배정
// https://www.acmicpc.net/problem/1931

public class MeetingRoom_1931 {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int  end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //끝나는 시간 순으로 오름차순 정리
        @Override
        public int compareTo(Meeting o) {
            if(this.end > o.end) return 1;
            else if (this.end < o.end) return -1;
            else return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());   // 회의 예약 갯수 입력
        Meeting [] meetarr =new Meeting[N]; // 예약 갯수 만큼 배열 생성
        for(int i =0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            meetarr[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }// 각 예약별 시작 ,끝 시간 입력
        Arrays.sort(meetarr);

        //그리디 찾기
        int st = meetarr[0].start, et =meetarr[0].end;
        int cnt =1;
        for(int i=1; i<N; i++){
            if(et>meetarr[i].start) continue;
            st = meetarr[i].start;
            et = meetarr[i].end;
            cnt ++;
        }
        System.out.println(cnt);
    }
}