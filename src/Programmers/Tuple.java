package Programmers;



import java.util.*;

public class Tuple {

    public static void main(String[] args) {
        String s ="{{2},{2,1},{2,1,3},{2,1,3,4}}";

        List<String[]> list =new ArrayList<>();
        Set<Integer> answer =new LinkedHashSet<>();

        for(String str : s.split("},")){
            list.add(str.replaceAll("[{}]", "").split(","));
        }
        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });
        for(String [] arr : list){

            for(String n : arr){
                System.out.println("Input: "+n);
                answer.add(Integer.parseInt(n));
            }

        }

        for(int n : answer){
            System.out.println(n);
        }

    }
}
