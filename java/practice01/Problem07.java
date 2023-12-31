package practice01;

import java.util.Scanner;

public class Problem07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String retry;
            int num = (int) (Math.random() * 100) + 1;
            int inputNum;

            System.out.println("========================");
            System.out.println("    [숫자맞추기게임 시작]");
            System.out.println("========================");
            while (true) {

                System.out.print(">>");
                //사용자 입력값 받기
                inputNum = sc.nextInt();
                //입력한 값 높은지 낮은지 맞추었는지 판단
                if (inputNum > num){
                    System.err.println("더 낮게");
                } else if (inputNum < num){
                    System.out.println("더 높게");
                } else{
                    System.out.println("맞았습니다.");
                    break;
                }
            }
            sc.nextLine();

            System.out.print("게임을 종료하시겠습니까?(y/n) >>");
            retry = sc.next();
            if ("y".equals(retry)) {
                break;
            }
        }

        sc.close();

    }

}
