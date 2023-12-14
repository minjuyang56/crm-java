package practice01;

public class Problem03 {
	
	public static void main(String[] args){
		
		for(int i = 1; i<10; i++){ //가로 반복조건
			for(int j = 2; j<10; j++){ //세로 반복조건
				System.out.print(j +"*"+ i + "=" + i*j);
				System.out.print("\t");
			}
			
			System.out.println("");
		}
		
	}

}
