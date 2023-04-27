package week2.assignment_1;

import java.util.Scanner;
import java.util.Stack;

public class likelion_201902679_KHJ_03_stack {

    public static Stack<Character> stringToStack(String str){
        Stack<Character> originCharStack = new Stack<>();
        for(char c : str.toCharArray()){
            originCharStack.push(c);
        }
        return originCharStack;
    }

    public static void printReversed(Stack<Character> orgStack){
        StringBuilder stringBuilder = new StringBuilder();
        while (!orgStack.empty()){
            stringBuilder.append(orgStack.pop());
        }
        System.out.println("문자열 출력 : "+stringBuilder);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열을 입력하세요 : ");
        String inputStr =  sc.next();
        System.out.println("거꾸로 출력합니다.");
        Stack<Character> originCharStack = stringToStack(inputStr);
        printReversed(originCharStack);

    }
}
