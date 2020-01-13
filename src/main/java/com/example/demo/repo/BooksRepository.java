package com.example.demo.repo;

import com.example.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Integer> {
	/*
    public Books findByTitle(String title);
    
    public List<Books> findByYear(int year);

    public Books findById(String book_id);
    
    @Query(value = "SELECT * FROM BOOKS WHERE genre = ?1", nativeQuery = true)
    public List<Books> findByGenre(String genre);

	 */


}