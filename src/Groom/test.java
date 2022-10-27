package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int coupon =n;
        int pizza = n;

        while(coupon>=m){
            pizza += coupon/m;
            coupon = coupon%m +coupon/m;
        }

        System.out.println(pizza);

    }
}
