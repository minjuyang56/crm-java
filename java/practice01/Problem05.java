package practice01;

public class Problem05 {

	public static void main(String[] args) {

		for(int i=1; i<11; i++){ //가로축 반복조건
			for (int j=i; j<10+i; j++){
				System.out.print(j);
				System.out.print(' ');
			}
			System.out.println("");
		}
		
	}

}
