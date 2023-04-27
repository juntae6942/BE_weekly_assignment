package week1;

import java.util.HashMap;
import java.util.Scanner;

public class likelion_201902679_KHJ_01 {
    private class Pair{
        String menu;
        int price;
        Pair(String menu, int price){
            this.menu = menu;
            this.price =price;
        }
    }

    static Scanner sc = new Scanner(System.in);
    private int change = 10000;

    private HashMap<Integer, Pair > menuList = new HashMap<>(){{
        put(1, new Pair("파워에이드",1400));
        put(2, new Pair("초코라떼",900));
        put(3, new Pair("쫄병",1300));
        put(4, new Pair("초코파이",700));
        put(5, new Pair("초코송이",1500));
    }};

    private boolean start(){

        while (true){
            System.out.printf("당신은 지금 %d원을 갖고 있습니다\n",change);
            System.out.print("메뉴 고르기를 선택하시겠습니까? y or n :");
            String userInput = sc.nextLine();

            switch (userInput){
                case "y" : return true;
                case "n" : return false;
                default:
                    System.out.print("\n***제대로 확인해주세요***\n\n");
                    continue;
            }
        }
    }

    private int showMenu(){
        int userInput =-1;
        while (true){
            System.out.printf("1) %s %d\n",menuList.get(1).menu,menuList.get(1).price);
            System.out.printf("2) %s %d\n",menuList.get(2).menu,menuList.get(2).price);
            System.out.printf("3) %s %d\n",menuList.get(3).menu,menuList.get(3).price);
            System.out.printf("4) %s %d\n",menuList.get(4).menu,menuList.get(4).price);
            System.out.printf("5) %s %d\n",menuList.get(5).menu,menuList.get(5).price);
            System.out.println("메뉴의 번호를 정수 형태로 입력해주세요 (메뉴는 하나만 고를 수 있습니다)  :");

            userInput = sc.nextInt();

            if(userInput>=1 & userInput<=5){
                return userInput;
            }else{ System.out.println("***메뉴 번호를 확인해주세요***\n"); continue;}
        }
    }


    private boolean checkBuying(int productNum){
        String menu=menuList.get(productNum).menu;

        while (true){

            System.out.printf("[%s]를 구매하시겠습니까? y or n :",menu);
            String userInput =  sc.nextLine();

            switch (userInput){
                case "y" : return true;
                case "n" : return false;
                default:
                    System.out.print("\n***조건을 잘 확인하세요***\n\n");
                    continue;
            }
        }
    }

    private boolean checkChange(int menuNum){

        int price = menuList.get(menuNum).price;

        if(change-price>=0){
            change-=price;
            return true;
        }else{
            return false;
        }
    }

    private void stop(){
        System.out.println("\n자판기를 종료합니다.");
        System.exit(0);
    }



    public static void main(String[] args) {

        likelion_201902679_KHJ_01 h1 = new likelion_201902679_KHJ_01();

        System.out.println("-----자판기에 오신 것을 환영합니다-----\n");

        while (true){
            if( h1.start()){
                int menuNum = h1.showMenu();
                if(h1.checkBuying(menuNum)){
                    if(h1.checkChange(menuNum)) continue;
                    else {
                        System.out.println("예산이 부족합니다.");
                        h1.stop();
                    }
                }else continue;
            }else{
                h1.stop();
            }
        }
    }
}
