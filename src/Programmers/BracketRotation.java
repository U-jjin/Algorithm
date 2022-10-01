package Programmers;

import java.util.*;
import java.util.stream.Stream;

public class BracketRotation {

    public static void main(String[] args) {

        String str = "{[()()]}";

        for(int i=0; i<str.length(); i++){
         str = str.substring(1)+str.charAt(0);
         System.out.println(str);
        }

    }

    static public boolean checkBracket(String str){
        Stack<Character> stack =new Stack<>();

        for(char s : str.toCharArray()){
            if(s == '(' || s=='{' || s=='['){
                stack.push(s);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            char c = stack.peek();
            if(c=='(' &&  s==')'){
                stack.pop();
            }else if(s == '}' && c =='{'){
                stack.pop();
            }else if(s == ']' && c =='['){
                stack.pop();
            }else{
                return false;
            }

        }
        return stack.isEmpty();
    }



}

