package likelion.week2.hw3;

import java.util.*;

public class loginProgram {

    static Scanner sc = new Scanner(System.in);
    HashMap<String, String> login = new HashMap<String, String>();
    String id;
    String passward;


    public void start(){

        while (true) {
            System.out.println("멋쟁이사자처럼 로그인 프로그램");
            System.out.println();
            System.out.println("============================");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            System.out.println("============================");
            System.out.println();
            System.out.print("어떤걸 진행하시겠습니까? : ");
            int num = sc.nextInt();
            switch (num){
                case 1 : login();
                case 2 : register();
                case 3 : exit();
                default:
                    System.out.println();
                    System.out.println("***번호를 다시 확인해주세요.**");
                    System.out.println();
                    continue;
            }
        }
    }

    public void login(){
        if(!login.isEmpty()){
            System.out.print("아이디를 입력하세요  :  ");
            id = sc.next();
            System.out.print("비밀번호를 입력하세요  :  ");
            passward = sc.next();
            if(!login.containsKey(id)){
                System.out.println();
                System.out.println("없는 회원입니다.");
                System.out.println();
                start();
            }else if(login.containsKey(id)&& !login.get(id).equals(passward)){
                System.out.println();
                System.out.print("비밀번호가 틀렸습니다.");
                System.out.println();
                start();
            }else if(login.containsKey(id)&& login.get(id).equals(passward)){
                System.out.println(id + " 회원 성공적으로 로그인하였습니다.");
                exit();
            }
        }else{
            System.out.println("로그인 프로그램 내에 로그인 정보가 없습니다.");
            System.out.println("회원가입 먼저 진행해주세요");
        }
    }

    public void register(){
        while (true) {
            System.out.print("아이디를 입력하세요  :  ");
            id = sc.next();
            if (!login.containsKey(id)) {
                System.out.print("비밀번호를 입력하세요  :  ");
                passward = sc.next();
                login.put(id, passward);
                System.out.println("정상적으로 회원가입 되었습니다. ");
                start();
            } else {
                System.out.println("이미 있는 아이디입니다.");
                System.out.print("다른 아이디로 회원가입을 계속 진행하시겠습니까? (y or n) : ");
                String yorn = sc.next();
                if (yorn.equals("y")) {
                    continue;
                } else if (yorn.equals("n")) {
                    start();
                }
            }
        }
    }

    public void exit(){
        System.out.println();
        System.out.println("로그인 프로그램이 종료됩니다.");
        System.exit(0);
    }


}

