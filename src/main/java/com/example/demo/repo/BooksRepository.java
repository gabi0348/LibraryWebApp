package com.example.demo.repo;

import com.example.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where a.first_name=?1 or a.second_name=?1")
    public Iterable<Books> getBooksByAuthorName(String name);

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where b.title=?1 ")

    public Iterable<Books> findByTitle(String title);

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where b.year=?1 ")

    public Iterable<Books> findByYear(int year);


    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where b.isbn=?1 ")

    public Iterable<Books> findByIsbn(String isbn);

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where b.genre=?1 ")

    public Iterable<Books> findByGenre(String genre);

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join publishers p on (p.publisher_id=b.publisher_id)\n" +
            "where p.name=?1 ")
    public Iterable<Books> getBooksByPublisher(String publisher);



    @Query(nativeQuery = true, value = " SELECT *\n" +
        "FROM books \n" +
        "WHERE stock< \n" +
            "(SELECT AVG(stock)\n" +
            "FROM books)\n" +
            "ORDER BY stock ASC")
    public Iterable<Books> getSalesBooks();


    @Query(nativeQuery = true, value = " select * \n" +
            "FROM books\n" +
            "WHERE genre='Sanatate'\n" +
            "AND price<\n" +
                "(SELECT AVG(price) \n" +
                " FROM books \n" +
                "WHERE genre='Sanatate') ")
    public Iterable<Books> getSanatateBooks();

   // @Query(nativeQuery = true, value = " select * \n" +


 //   public Iterable<Books> getTopAuthorBooks();

    @Query(nativeQuery = true, value = "SELECT * \n" +
            "FROM books b \n" +
            "INNER JOIN publishers p ON (b.publisher_id=p.publisher_id)  \n" +
            "ORDER BY p.name ASC")

    public Iterable<Books> getOrderPublisherBooks();


    @Query(nativeQuery = true, value = "SELECT * \n" +
        "FROM " +
            "(select top 5 * " +
            "from books b \n" +
            "where b.genre='Antreprenoriat' \n" +
            "order by b.stock ) as I  \n" +
        "WHERE I.price>10")

    public Iterable<Books> getTopAntreprenoriatBooks();

    @Query(nativeQuery = true, value = "SELECT * \n" +
            "FROM " +
                "(select top 5 * " +
                "from books b \n" +
                "where b.year='2019' \n" +
                "order by b.stock ) as I ")

    public Iterable<Books> getBestSellerBooks();

    @Query(nativeQuery = true, value = "select * \n" +
            "from books b inner join books_authors ba on (b.book_id=ba.book_id)\n" +
            "inner join authors a on (a.author_id=ba.author_id)\n" +
            "where a.first_name=?1 or a.second_name=?1 or b.title=?1 or b.genre=?1")

    public Iterable<Books>getAllSearchBooks();


}