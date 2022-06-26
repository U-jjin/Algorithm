package BronzeToGold;

import java.io.*;
import java.util.StringTokenizer;

/*
 앞 뒤 무엇을 추가되는 문자는 무조건 일치하므로 신경쓰지 않아도 된다.
 A문자열이 B문자열에서 가장 차이가 적은 위치를 찾는것이 관건.
 */
public class String_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int result = A.length();
        for(int i=0; i<=B.length()-A.length(); i++){
            int num =0;
            for(int j =0; j<A.length(); j++){
                if(A.charAt(j) != B.charAt(i+j)) num ++;
            }
            result = Math.min(num,result);
        }

        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}