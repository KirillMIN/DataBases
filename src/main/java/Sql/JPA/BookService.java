package Sql.JPA;

import Entities.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class BookService {
    private BookRepository bookRepository;
    @Transactional
    public void testEmployeesCrudRepository() {
        Optional<Book> employeesOptional = bookRepository.findById(String.valueOf(1));
        //....
    }
}
