import java.util.Scanner;

public class HelloWorld{
    public static void main(String[] args){
        // System.out.println("입력하세욤");
        Scanner s = new Scanner(System.in);
    
        int day_per_month = 0;

        for (int i = 1; i<=5; i++){
            for (int j= 1; j<=i; j++){
                day_per_month++;
            }
        }

        // User u1 = new User("dd", "d");
        // User u2 = new User("dd", "d");
        // System.out.println(u1 == u2);
        // User u3 = u1;

        // System.out.println(u2 == u1 || u1.equals(u2));


        System.out.println(day_per_month + "일");
        s.close();
    }

    
}
