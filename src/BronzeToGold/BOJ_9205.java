package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205 {
    public static class loc{
        int x;
        int y;

        public loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<caseCnt; i++){
            int storeCnt = Integer.parseInt(br.readLine());

            StringTokenizer st =new StringTokenizer(br.readLine());
            loc home =new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            loc [] stores =new loc[storeCnt];

            for(int j=0; j<storeCnt; j++){
                st =new StringTokenizer(br.readLine());
                stores[j] = new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            st =new StringTokenizer(br.readLine());
            loc festival = new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            for(int j=0; j<storeCnt; j++) {
                int distance;
                int cnt;
                if (j == 0) {
                    distance = Math.abs(stores[j].x - home.x) + Math.abs(stores[j].y - home.y);
                }
                if (j == storeCnt - 1) {
                    distance = Math.abs(stores[j].x - festival.x) + Math.abs(stores[j].y - festival.y);
                }
                distance = Math.abs(stores[j].x - stores[j - 1].x) + Math.abs(stores[j].y - stores[j - 1].y);


            }

        }
    }
//    static public int findDistance(loc start, loc end){
//        int distance;
//
//        return Math.abs(stores[j].x - home.x) + Math.abs(stores[j].y - home.y);
//
//    }
}
