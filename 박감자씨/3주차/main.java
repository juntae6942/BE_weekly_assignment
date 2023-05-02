import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("이은경");
        list.add("이다은");
        list.add("임영우");
        list.add("김민지");
        list.add("김민성");

        for (String s : list) {
            if(s.charAt(0)=='이'){
                System.out.println(s);
            }
        }

        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("로또 번호를 몇 개 생성하시겠습니까?");
        int count  = Integer.parseInt(br.readLine());
        Random random = new Random(0);
        for(int i=0; i<count; i++){
            set.add(random.nextInt(90));
        }
        System.out.print("생성된 로또 번호: ");
        System.out.println(Arrays.toString(set.toArray()));

        Stack<Character> stack = new Stack<>();
        System.out.print("문자열을 입력하세요 :");
        String s = br.readLine();
        int len = s.length();
        for(int i=0; i<len; i++){
            stack.push(s.charAt(i));
        }
        System.out.println("거꾸로 출력합니다.");
        System.out.print("문자열 출력 : ");
        for(int i=0; i<len; i++){
            System.out.print(stack.pop());
        }
    }
}