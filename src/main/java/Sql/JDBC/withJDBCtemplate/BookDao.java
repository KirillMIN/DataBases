package Sql.JDBC.withJDBCtemplate;


import Entities.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookDao implements BookRepository {
    private JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Book> findAll() {
        return jdbcTemplate.query("select id, title from Book", this::mapRowToBook);
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update(
                "insert into Book (id, title) values (?, ?)");

    }

    private Book mapRowToBook(ResultSet row, int rowNum)
            throws SQLException {
        return new Book(
                row.getString("id"),
                row.getString("title"));

    }
}
