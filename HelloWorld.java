import java.util.Scanner;

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("입력하세욤");
        Scanner s = new Scanner(System.in);
        
        int month = s.nextInt(); 
        int day_per_month = 0;

        System.out.println(day_per_month + "일");
    }
}