package Programmers;

import java.util.*;

public class CalculataionParkingRate {
    public static void main(String[] args) {

        int [] fees = {180, 5000, 10, 600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        List<Integer> solution = solution(fees, records);
        for(int a:solution){
            System.out.print(a+" ");
        }
    }
    static int timeLimit;
    static int baseFee;
    static int perTime;
    static int surcharge;

    static public List<Integer> solution(int[] fees, String[] records) {

        timeLimit = fees[0];
        baseFee = fees[1];
        perTime = fees[2];
        surcharge = fees[3];

        HashMap<String,Integer> parking =new HashMap<>();
        TreeMap<String,Integer> feeList =new TreeMap<>();

        for(String r : records){
            StringTokenizer st = new StringTokenizer(r);
            //시간
            String [] clock = st.nextToken().split(":");
            String carNum = st.nextToken();
            String inOut = st.nextToken();

            //분으로 시간 계산.
            int time = Integer.parseInt(clock[0])*60 + Integer.parseInt(clock[1]);

            //입차라면, 차번호와 입차 시간을 parking에 저장
            if(inOut.equals("IN")){
                parking.put(carNum,time);
                System.out.println("in: "+carNum+" "+time+"mins");
            }
            //출차라면, 해당 차번호의 입차시간과 출차시간을 통해 요금 정산 후 feeList에 저장
            else if(inOut.equals("OUT")){
                int totaltime = time - parking.remove(carNum);
                //기존에 과금 리스트에 해당되어 있지 않다면, 해당 fee 저장.
                System.out.println("out: "+carNum+" "+time+"mins totaltime:"+totaltime+"mins");
                feeList.put(carNum,feeList.getOrDefault(carNum,0)+totaltime);
            }
        }
        //밤 23:59분까지 나가지 않은 차가 있다면, 요금 정산
        if(!parking.isEmpty()){
            for(String carNum: parking.keySet()){
                int totaltime =(23*60+59)-parking.get(carNum);
                feeList.put(carNum, feeList.getOrDefault(carNum,0)+totaltime);
                System.out.println("final out: "+carNum+" totaltime: "+totaltime+"mins");

            }
        }
        ArrayList<Integer> answer =new ArrayList<>();
        for(int time : feeList.values()){
            answer.add(rateCalculation(time));
        }
        return  answer;
    }

    public static int rateCalculation(int mins){
        if(mins <= timeLimit) return baseFee;
        else{ mins -=timeLimit; }

        int time = mins/10;
        if(mins%10 !=0) time++;

        return baseFee+ time*surcharge;
    }
}

