package BronzeToGold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
public class BOJ_15961 {

    static int n, d, k, c;
    static int[] dishes, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 종류
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹어야 하는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호


        dishes  = new int[n];
        //스시의 종류마다 먹은 스시 개수를 저장할 배열
        visited = new int[d + 1];

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }


        int slideCnt = 0;
        int maxCnt ;

        //슬라이드 초기화
        for(int i=0; i<k; i++){
            if(visited[dishes[i]] == 0){
                slideCnt ++;
            }
            visited[dishes[i]] ++;
        }
        maxCnt = slideCnt;

        for(int i=1; i<n; i++){
            System.out.println(slideCnt+" "+maxCnt);
            if( maxCnt <=slideCnt){
                if( visited[c] == 0) maxCnt = slideCnt+1;
                else maxCnt = slideCnt;
            }

            //슬라이드 이동시에,
            //앞쪽은 빼주고,
            if(--visited[dishes[i-1]] == 0) slideCnt--;

            //뒷쪽은 더해준다
            //%n 을 통해 n-1까지는 그대로, n번째(index 0)로 돌아 갈 수 있도록

            if(visited[dishes[(i+k-1)%n]]++ == 0){
                slideCnt ++;
            }
        }

        System.out.println(maxCnt);

    }


}
