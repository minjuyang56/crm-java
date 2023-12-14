package practice03.book;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("대여 하고 싶은 책의 번호를 입력하세요: ");
        int input_book_num = s.nextInt();
        System.out.println("*******도서 정보 출력하기********");

        Book b1 = new Book(input_book_num, null, null);
        Book b2 = new Book(input_book_num, null, null);
        Book b3 = new Book(input_book_num, null, null);
        Book b4 = new Book(input_book_num, null, null);
    }
}
