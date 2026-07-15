class BookSingleton {
    private String author;
    private String title;
    private static BookSingleton book;
    private static boolean isLoanedOut;

    private BookSingleton() {
        author = "Gamma, Helm, Johnson, and Vlissides";
        title = "Design Patterns";
        book = null;
        isLoanedOut = false;
    }

    public static BookSingleton borrowBook() {
        if (!isLoanedOut) {
            if (book == null) {
                book = new BookSingleton();
            }
            isLoanedOut = true;
            return book;
        }
        return null;
    }

    public void returnBook(BookSingleton bookReturned) {
        isLoanedOut = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorAndTitle() {
        return getTitle() + " by " + getAuthor();
    }
}

class BookBorrower {
    private BookSingleton borrowedBook;
    private boolean haveBook = false;

    public void borrowBook() {
        borrowedBook = BookSingleton.borrowBook();

        if (borrowedBook == null) {
            haveBook = false;
        } else {
            haveBook = true;
        }
    }

    public String getAuthorAndTitle() {
        if (haveBook) {
            return borrowedBook.getAuthorAndTitle();
        }
        return "I don't have the book";
    }

    public void returnBook() {
        borrowedBook.returnBook(borrowedBook);
    }
}

public class TestBook {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");

        BookBorrower bookBorrower1 = new BookBorrower();
        BookBorrower bookBorrower2 = new BookBorrower();

        bookBorrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book");
        System.out.println("BookBorrower1 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book");
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower2.getAuthorAndTitle());

        bookBorrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        System.out.println("END TESTING SINGLETON PATTERN");
    }
}