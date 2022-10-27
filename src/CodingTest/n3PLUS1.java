package CodingTest;
import java.io.*;
import java.util.StringTokenizer;

public class n3PLUS1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st =new StringTokenizer(br.readLine());
        int start =Integer.parseInt(st.nextToken());
        int  end = Integer.parseInt(st.nextToken());

        int max =0;

        for(int i =start; i<= end; i++){
            max = Math.max(max,findCycle(i,1));
        }


        System.out.println(max);

    }

    public static int findCycle(int n, int cnt){
        if(n==1)return cnt;
        if(n%2==0) return findCycle(n/2,cnt+1);
        else  return findCycle(n*3+1,cnt+1);
    }
}
