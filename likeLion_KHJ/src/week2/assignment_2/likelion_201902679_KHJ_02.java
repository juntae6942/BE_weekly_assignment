package week2.assignment_2;

import java.util.*;

public class likelion_201902679_KHJ_02 {

    private Map<String,String> userInfoList = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public void createNewUser(String id, String pw){ // 새로운 사용자 생성
        userInfoList.put(id,pw);
    }

    public boolean login(){ // login 기능
        String inputId;
        String inputPw;

        if(userInfoList.isEmpty()){ // 예외처리 : 회원 0명
            System.out.println("\n로그인 프로그램 내에 로그인 정보가 없습니다.");
            System.out.println("회원가입 먼저 잰행 해 주세요\n");
            return false;
        }

        System.out.print("아이디를 입력하세요 : ");
        inputId = sc.next();

        System.out.print("비밀번호를 입력하세요 : ");
        inputPw = sc.next();

        if(checkId(inputId)){ // 로그인 성공 여부 확인 : id 존재 여부 확인
            if(checkPw(inputId,inputPw)){ // 로그인 성공 여부 확인 : pw 일치 확인
                System.out.printf("\n%s 회원 성공적으로 로그인 되었습니다.",inputId);
                System.out.println("프로그램이 종료됩니다.");
                System.exit(0);
            }else{ // 로그인 성공 여부 확인 : 비밀번호 오류
                System.out.println("\n비밀번호가 틀렸습니다.\n");
            }
        }else{ // 로그인 성공 여부 확인 : id 미존재
            System.out.println("\n없는 회원입니다.\n");
        }
        return false;
    }

    public boolean checkId(String id){ // 사용자 id 존재 여부 확인
        if(userInfoList.containsKey(id)) return true;

        return false;
    }

    public boolean checkPw(String id,String pw){ // 사용자 pw 일치 여부 확인
        if(userInfoList.get(id).compareTo(pw)==0) return true;
        return false;
    }

    public boolean signUp(){ // 회원가입
        String inputId;
        String inputPw;

        while (true){
            System.out.print("아이디를 입력하세요 : ");
            inputId = sc.next();

            if(checkId(inputId)){ // id 존재 여부 확인
                System.out.println("이미 있는 아이디입니다.");
                System.out.print("다른 아이디로 회원가입을 계속 진행하시겠습니까? (y or n) :");
                String answer = sc.next();

                switch (answer){
                    case "y" : continue;
                    case "n" : return false;
                }
            }else break;

        }

        System.out.print("비밀번호를 입력하세요 : ");
        inputPw = sc.next();

        createNewUser(inputId,inputPw); // 새로운 회원 생성

        System.out.println("\n정상적으로 회원가입 되었습니다.");

        return true;
    }

    public void exit(){ // 프로그램 종료
        System.out.println("로그인 프로그램이 종료됩니다.");
        System.exit(0);
    }

    public boolean wrongInputNum(){ // 올바르지 않은 숫자 입력
        System.out.println("\n번호를 다시 확인해주세요.\n");
        return false;
    }

    public boolean getInputNum(){ // 프로그램 진행을 위한 입력 숫자 확인
        System.out.print("어떤걸 진행하시겠습니까? :");
        int inputNum = sc.nextInt();
        boolean check = false;

        switch (inputNum){
            case 1:check=login(); break;
            case 2:check=signUp(); break;
            case 3:exit(); break;
            default:wrongInputNum();
        }
        return check;
    }

    public static void printStartOption(){ // 시작 문자열 출력
        System.out.println("==============================");
        System.out.println("1. 로그인\n2. 회원가입\n3. 종료");
        System.out.println("==============================\n");
    }

    public static void main(String args[]){
        likelion_201902679_KHJ_02 assignment = new likelion_201902679_KHJ_02();

        while (true){
            System.out.println("\n멋쟁이사자처럼 로그인 프로그램\n");
            printStartOption();
            if(!assignment.getInputNum()) continue;
        }

    }
}
