package Sql.JDBC.withJDBCtemplate;

import Entities.Book;

public interface BookRepository {
    public Iterable<Book> findAll();
    public void save(Book book);

}
