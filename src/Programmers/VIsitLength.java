package Programmers;

public class VIsitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    static enum Line {
        ROW,COL;
    }

    static class Location{
        Line line;
        int x;
        int y;
        int lineX, lineY;

        public Location(int x, int y){
            this.x= x;
            this.y= y;
        }
        public Location(){}

        public String toString(){

            return line+" ("+x+","+y+") ("+lineX+","+lineY+")";
        }

    }
    static boolean [][] xVisited = new boolean [10][10];
    static boolean [][] yVisited = new boolean [10][10];
    public static int solution(String dirs) {
        int answer = 0;
        int x=5;
        int y=5;
        for (char dir : dirs.toCharArray()){
            Location nextLoc =new Location();
            if(dir =='R'){
                nextLoc.x= x;
                nextLoc.y= y+1;
                nextLoc.line = Line.ROW;
                nextLoc.lineX= x;
                nextLoc.lineY= y;
            }else if(dir =='L'){
                nextLoc.x= x;
                nextLoc.y= y-1;
                nextLoc.line = Line.ROW;
                nextLoc.lineX= x;
                nextLoc.lineY= y-1;
            }else if(dir =='U'){
                nextLoc.x= x-1;
                nextLoc.y= y;
                nextLoc.line = Line.COL;
                nextLoc.lineX= x-1;
                nextLoc.lineY= y;
            }else{
                nextLoc.x= x+1;
                nextLoc.y= y;
                nextLoc.line = Line.COL;
                nextLoc.lineX= x;
                nextLoc.lineY= y;
            }
            System.out.println(dir+" "+nextLoc.toString());

            if(nextLoc.x<0 ||nextLoc.y<0 || nextLoc.x>10 || nextLoc.y>10){
                continue;
            }

            if(nextLoc.line.equals(Line.ROW)){
                if(!xVisited[nextLoc.lineX][nextLoc.lineY]) answer ++;
                xVisited[nextLoc.lineX][nextLoc.lineY]=true;
            }else if(nextLoc.line.equals(Line.COL)){
                if(!yVisited[nextLoc.lineX][nextLoc.lineY]) answer ++;
                yVisited[nextLoc.lineX][nextLoc.lineY]=true;
            }
            x= nextLoc.x;
            y= nextLoc.y;
            System.out.println(answer+" ("+x+","+y+")");
        }


        return answer;
    }
}

