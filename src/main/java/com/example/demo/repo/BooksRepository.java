package com.example.demo.repo;

import com.example.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query(nativeQuery = true,value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where a.first_name=?1 or a.second_name=?1" )
    public Iterable<Books> getBooksByAuthorName(String name);

    public Iterable<Books> findByTitle(String title);

    public Iterable<Books> findByYear(int year);

    public Iterable<Books> findByIsbn(String isbn);

    public Iterable<Books> findByGenre(String genre);

    @Query(nativeQuery = true,value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where a.first_name=?1 or a.second_name=?1" )
    public Iterable<Books> getBooksByPublisher(String publisher);


}