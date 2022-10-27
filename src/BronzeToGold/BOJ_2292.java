package BronzeToGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt =1;
        int check = 1;
        while(true){
            if( n<= check) break;

            check +=cnt*6;
            cnt++;
//            System.out.println(cnt+" "+check);
        }

        System.out.println(cnt);
    }
}
