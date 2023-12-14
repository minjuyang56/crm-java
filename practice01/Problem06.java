package practice01;

import java.util.Scanner;

public class Problem06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		int i;
		int sum = 0 ;
		
		if (num % 2 == 0){
			for(i=2; i<=num; i+=2){
				sum += i;
			}
		}else{
			for(i=1; i<=num; i+=2){	
				sum += i;
			}
		}
		
		System.out.println("결과값: " + sum);
		sc.close();
	}
}
