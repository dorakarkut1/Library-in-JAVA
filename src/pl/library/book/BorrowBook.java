package pl.library.book;
import pl.library.book.Book;

public class BorrowBook {
    private Boolean ifBorrowed;
    private Book book;

    public BorrowBook(){
        book = new Book();
        ifBorrowed = false;
    }

    public Boolean getIfBorrowed() {
        return ifBorrowed;
    }

    public void setIfBorrowed(Boolean ifBorrowed) {
        this.ifBorrowed = ifBorrowed;
    }
}
