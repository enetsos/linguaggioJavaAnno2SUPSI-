package es1;

public class Main {
    
    public static void main(String[] args) {
        insertAuthor("Stephen", "King", 1947);
        insertAuthor("Herman", "Melville", 1819);
        insertAuthor("Hermann", "Hesse", 1877);
        
        insertBook("Carrie", 1974, "Doubleday");
        insertBook("Shining", 1977, "Doubleday");
        insertBook("IT", 1986, "Viking");
        insertBook("Moby dick", 1851, "Richard Bentley");
        insertBook("Siddhartha", 1922, "Suhrkamp Verlag");

        System.out.println("author(s)");
        for (int i = 1; i < 5; i++)
            System.out.println(getAuthorById(Long.valueOf(i)));

        System.out.println();
        System.out.println("book(s)");
        for (int i = 1; i < 5; i++)
            System.out.println(getBookById(Long.valueOf(i)));
    }

    /**
     * Add a new author to the database
     * 
     * @param firstName
     * @param lastName
     * @param birthYear
     */
    private static Author insertAuthor(String firstName, String lastName, int birthYear) {
        // FIXME to implement
        return null;
    }

    /**
     * Add a new book to the database 
     * 
     * @param title
     * @param year
     * @param publisher
     */
    private static Book insertBook(String title, int year, String publisher) {
        // FIXME to implement
        return null;
    }

    /**
     * Returns Author for given id
     * @param id
     * @return
     */
    private static Author getAuthorById(final Long id) {
        // FIXME to implement
        return null;
    }

    /**
     * Returns Book for given id
     * @param id
     * @return
     */
    private static Book getBookById(final Long id) {
        // FIXME to implement
        return null;
    }
}
