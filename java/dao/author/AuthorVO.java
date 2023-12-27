package dao.author;

public class AuthorVO {
    private int author_id;
    private String author_name;
    private String author_desc;

    public int get_author_id() {
        return author_id;
    }

    public void set_author_id(int author_id) {
        this.author_id = author_id;
    }

    public String get_author_name() {
        return author_name;
    }

    public void set_author_name(String author_name) {
        this.author_name = author_name;
    }

    public String get_author_desc() {
        return author_desc;
    }

    public void set_author_desc(String author_desc) {
        this.author_desc = author_desc;
    }

    public AuthorVO(int author_id, String author_name, String author_desc) {
        super();
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_desc = author_desc;
    }

    @Override
    public String toString() {
        return "AuthorVO [author_id=" + author_id + ", author_name=" + author_name + ", author_desc=" + author_desc + "]";
    }
}
