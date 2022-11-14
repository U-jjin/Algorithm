package BronzeToGold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

10,000,000 = 1cm

 */
public class BOJ_3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));


        try{
            while(true){
                long x = Integer.parseInt(br.readLine())* 10000000L;
                int n = Integer.parseInt(br.readLine());

                int [] legos =new int[n];

                for(int i=0; i<n; i++){
                    legos[i] = Integer.parseInt(br.readLine());
                }

                int start =0;
                int end = n-1;
                String result = "danger";

                Arrays.sort(legos);
                while(start<end) {
                    long sum = legos[start] + legos[end];
                    if (sum < x) {
                        start++;
                    } else if (sum > x) {
                        end--;
                    } else {
                        result = "yes " + legos[start] + " " + legos[end];
                        break;
                    }
                }
                System.out.println(result);
            }
        }catch (Exception e){
            return;
        }






    }
}
