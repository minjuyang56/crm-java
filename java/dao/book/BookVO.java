package dao.book;

// VO = Value Object
public class BookVO {
    private int book_id;
    private String book_title;
    private String book_pubs;
    private String book_pub_date;
    private int author_id;
    private String author_name;

    public int get_book_id() {
        return book_id;
    }

    public void set_book_id(int book_id) {
        this.book_id = book_id;
    }

    public String get_book_title() {
        return book_title;
    }

    public void set_book_title(String book_title) {
        this.book_title = book_title;
    }

    public String get_book_pubs() {
        return book_pubs;
    }

    public void set_book_pubs(String book_pubs) {
        this.book_pubs = book_pubs;
    }

    public String get_book_pub_date() {
        return book_pub_date;
    }

    public void set_book_pub_date(String book_pub_date) {
        this.book_pub_date = book_pub_date;
    }

    public int get_author_id() {
        return author_id;
    }

    public void set_author_id(int author_id) {
        this.author_id = author_id;
    }

    public BookVO(int book_id, String book_title, String book_pubs, String book_pub_date, int author_id) {
        super();
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_pubs = book_pubs;
        this.book_pub_date = book_pub_date;
        this.author_id = author_id;
    }

    public BookVO(int book_id, String book_title, String book_pubs, String book_pub_date, String author_name) {
        super();
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_pubs = book_pubs;
        this.book_pub_date = book_pub_date;
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "BookVO [book_id=" + author_id + ", book_title=" + book_title + ", book_pubs=" + book_pubs + ", book_pub_date=" + book_pub_date + ", author_name=" + author_name + "]";
    }
}
