package Softeer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Cluster {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> comList =new ArrayList<>();
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            min=Math.min(min,Integer.parseInt(st.nextToken()));
        }

        HashMap<String,String> map =new HashMap<>();
        List<String> strings = new ArrayList<>(map.keySet());
        Collections.sort(strings);

        for(String name : strings){

        }

        int plus = (int)Math.sqrt((double)B);
        System.out.println(min+plus);

    }
}
