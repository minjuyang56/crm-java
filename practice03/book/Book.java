package practice03.book;

public class Book {
    int bookNo;
    String title;
    String author;
    int stateCode;

    public Book(int bookNo, String title, String author){
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
    }

    public void rent(){ // 여기서 statecode 변경함 

    }

    public void print(){ // <책제목 저자 대여유무> 출력

    }

    public int getBookNo(){
        return this.bookNo;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setBookNo(int bookNo){
        this.bookNo = bookNo;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
