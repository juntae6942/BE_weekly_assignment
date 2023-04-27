package week2.assignment_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class likelion_201902679_KHJ_02_set {

    public static Set<Integer> getRandomNum(int num){
        Set<Integer> randomNum = new HashSet<>();

        while(randomNum.size()<num){
            int randomInteger = (int)(Math.random()*45)+1;
            randomNum.add(randomInteger);
        }
        return randomNum;
    }
    public static void printrandomNum(Set<Integer> set){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("생성된 로또번호: [");

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            int numInSet = iterator.next();
            stringBuilder.append(numInSet);
            if(iterator.hasNext()) stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Set<Integer> randomNumSet;

        System.out.print("로또 번호를 몇개 생성하시겠습니까? ");
        int inputNum = sc.nextInt();
        randomNumSet = getRandomNum(inputNum);
        printrandomNum(randomNumSet);
    }
}
