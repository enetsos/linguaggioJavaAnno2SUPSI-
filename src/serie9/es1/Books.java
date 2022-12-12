package serie9.es1;

import java.sql.Connection;
import java.sql.Statement;

/*

REFERENCE SQL:

drop table if exist book, author;

create table author (
    first_name varchar2(20) not null,
    last_name varchar2(20) not null,
    birth_year integer,
    primary key (first_name, last_name)
);
create table book (
    title varchar2(50),
    pub_year integer,
    publisher varchar2(20),
    author_first_name varchar2(20),
    author_last_name varchar2(20),
    primary key (title),
    foreign key(author_first_name, author_last_name) references author(first_name, last_name)
);

*/
public class Books {
    private static final String DB_CONNECTION_URL = "jdbc:h2:/Scuola/SUPSI/secondo anno/Linguaggi ad oggetti/serie9/database";

    private static final String DB_USERNAME = "sa";

    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {


        insertAuthor("Stephen", "King", 1947);
        insertBook("Carrie", 1974, "Doubleday", "Stephen", "King");
        insertBook("Shining", 1977, "Doubleday", "Stephen", "King");
        insertBook("IT", 1986, "Viking", "Stephen", "King");

        insertAuthor("Herman", "Melville", 1819);
        insertBook("Moby dick", 1851, "Richard Bentley", "Herman", "Melville");

        insertAuthor("Hermann", "Hesse", 1877);
        insertBook("Siddhartha", 1922, "Suhrkamp Verlag", "Hermann", "Hesse");

        System.out.println("author(s)");
        printTable("author");

        System.out.println();
        System.out.println("book(s)");
        printTable("book");

        System.out.println();
        System.out.println("complete books list");
        printBooksFull();
    }

    /**
     * Add a new author to the database
     *
     * @param firstName
     * @param lastName
     * @param birthYear
     */
    private static void insertAuthor(String firstName, String lastName, int birthYear) {
        try (Connection connection = java.sql.DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into author values ('" + firstName + "', '" + lastName + "', " + birthYear + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new book to the database; {@code firstName} and {@code lastName} parameters must reference an existing author.
     *
     * @param title
     * @param pub_year
     * @param publisher
     * @param firstName
     * @param lastName
     */
    private static void insertBook(String title, int pub_year, String publisher, String firstName, String lastName) {
        try (Connection connection = java.sql.DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into book values ('" + title + "', " + pub_year + ", '" + publisher + "', '" + firstName + "', '" + lastName + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print all books with authors
     */
    private static void printBooksFull() {
        try (Connection connection = java.sql.DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") + " (" + resultSet.getInt("pub_year") + ") by " + resultSet.getString("author_first_name") + " " + resultSet.getString("author_last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print {@code table} contents
     *
     * @param table the table name to display
     */
    private static void printTable(String table) {
        try (Connection connection = java.sql.DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery("select * from " + table);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name") + " (" + resultSet.getInt("birth_year") + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
