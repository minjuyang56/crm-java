package practice03.cal;

import java.util.Scanner;

public class CalcApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true){
            String input = s.nextLine();
            if ("/q".equals(input)){
                System.out.println("종료합니다.");
                break;
            }

            String[] inputArr = input.split(" ");
            
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[2]);
            String operator = inputArr[1];
            
            if ("+".equals(operator)){
                Add addCalc = new Add();
                addCalc.setValue(a, b);
                System.out.println(addCalc.calculate()); 
            }else if ("-".equals(operator)){
                Sub subCalc = new Sub(); 
                subCalc.setValue(a, b);  
                System.out.println(subCalc.calculate());
            }else if ("*".equals(operator)){
                Mul mulCalc = new Mul();
                mulCalc.setValue(a, b);
                System.out.println(mulCalc.calculate());
            }else if ("/".equals(operator)){
                Div divCalc = new Div(); 
                divCalc.setValue(a, b);
                System.out.println(divCalc.calculate());
            }else{
                System.out.println("알 수 없는 연산입니다.");
            }
            
        }
        s.close();
    }
}
