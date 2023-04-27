package week2.assignment_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class likelion_201902679_KHJ_01_list {
    // 이씨 성을 가진 사람을 찾는 메소드
    public static void findLees(List<String> list){
        for(String name : list){
            if(name.contains("이")){
                System.out.println(name);
            }
        }
    }


    public static void printProgramStart(){
        System.out.println("이 씨 성인 사람 찾아내는 프로그램");
        System.out.println("==============================");
        System.out.println("다섯명의 사람 이름을 한 줄씩 입력합니다.");
    }

    public static void main (String[] args){
        List<String> nameList = new ArrayList();
        Scanner sc = new Scanner(System.in);

        printProgramStart();
        for(int i=0;i<5;i++){
            String name = sc.next();
            nameList.add(name);
        }
        findLees(nameList);

    }
}
