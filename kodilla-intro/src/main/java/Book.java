public class Book {
    private String author;
    private String title;

    public static void main(String[] args) {
        Book book = Book.of("Isaac Asimov", "The Galaxy");
        System.out.println(book.author + " " + book.title);
    }

    public static Book of(String author, String title) {
        Book newBook = new Book();
        newBook.author = author;
        newBook.title = title;
        return newBook;
    }
}
