package serie10.es1;

import java.util.List;

import javax.persistence.*;

public class Main {
    
    final static String PERSISTENCE_UNIT_NAME = "ch.walter.serie10";
    final static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    final static EntityManager entityManager = factory.createEntityManager();
    
    public static void main(String[] args) {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setBirthYear(1970);

        Book book = new Book();
        book.setTitle("My first book");
        book.setPublisher("My publisher");
        book.setYear(2015);
        book.setAuthor(author);

        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    private static Author insertAuthor(String firstName, String lastName, int birthYear) {
        entityManager.getTransaction().begin();
        final Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBirthYear(birthYear);

        entityManager.persist(author);
        entityManager.getTransaction().commit();

        return author;
    }

    private static Book insertBook(String title, int year, String publisher, final Author author) {
        entityManager.getTransaction().begin();
        final Book book = new Book();
        book.setTitle(title);
        book.setYear(year);
        book.setPublisher(publisher);
        book.setAuthor(author);

        entityManager.persist(book);
        entityManager.getTransaction().commit();
        return book;
     }

    private static Author getAuthorById(final Long id) {
        return entityManager.find(Author.class, id);
    }

    private static Book getBookById(final Long id) {
        return entityManager.find(Book.class, id);
    }


}
