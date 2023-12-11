package practice02.com.javaex.practice;

public class Problem05 {

    public static void main(String[] args) {

        int[] no = new int[6];
        
        for(int i=0 ; i<no.length; i++){
            no[i] = (int)(Math.random()*45)+1;
            
            //중복검사
            for (int j = 0; j < i; j++){
                while(no[i] == no[j]){
                    no[i] = (int)(Math.random()*45)+1;
                }
            }
        }
        
        for(int j=0; j<no.length; j++){
            System.out.print(no[j] + "  ");
        }  
        
    }
}




