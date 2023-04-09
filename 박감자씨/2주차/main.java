import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    static HashMap<String,Member> repository = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        while (true){
            try {
                int order = start();
                switch (order){
                    case 1:
                        if(login()){
                            continue;
                        };
                        break;
                    case 2:
                        memberShip();
                        break;
                    case 3:
                        SystemOff();
                        break;
                    default:
                        System.out.println("번호를 다시 확인해주세요.");
                }
            }
            catch (NumberFormatException exception){
                System.out.println("번호로 입력해주세요.");
            }
        }
    }

    static public int start() throws IOException {

        StringBuilder sb = new StringBuilder();

        sb.append("멋쟁이사자처럼 로그인 프로그램\n")
                .append("\n")
                .append("==================\n")
                .append("1. 로그인\n")
                .append("2. 회원가입\n")
                .append("3. 종료\n")
                .append("==================\n")
                .append("어떤걸 진행하시겠습니까? :");

        System.out.print(sb);

        return Integer.parseInt(br.readLine());
    }
    static public boolean login() throws IOException {
        System.out.print("아이디를 입력하세요 : ");
        String id = br.readLine();
        System.out.print("비밀번호를 입력하세요 : ");
        String password = br.readLine();
        System.out.println();

        Member member = repository.get(id);//회원 정보 가져오기

        if(member!=null){
            if(id.equals(member.id) && password.equals(member.password)){
                System.out.println(id+" 회원 성공적으로 로그인하였습니다.");
                SystemOff();
            }
            else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
        else {
            System.out.println("없는 회원입니다.\n");
        }
        return false;
    }

    static public void memberShip() throws IOException {
        while (true){

            System.out.print("아이디를 입력하세요 : ");
            String id = br.readLine();

            if(repository.get(id)!=null){
                System.out.println("이미 있는 아이디입니다.");
                System.out.println("다른 아이디로 회원가입을 계속 진행하시겠습니까? (y or n) :");
                String order = br.readLine();
                if(order.equals("y")){
                    continue;
                }
                else if (order.equals("n")) {
                    return;
                }
                else {
                    System.out.println("다시 입력해주세요.");
                }
            }

            System.out.print("비밀번호를 입력하세요 : ");
            String password = br.readLine();
            System.out.println();

            Member member = new Member(id,password);
            repository.put(id,member);
            System.out.println("정상적으로 회원가입 되었습니다.");
            break;
        }
    }
    static public void SystemOff(){
        System.out.println("프로그램이 종료됩니다.");
        System.exit(0);
    }
}
class Member{
    String id;
    String password;
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}