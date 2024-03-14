package com.example.bookservice.repositorys;

import com.example.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends JpaRepository<Book, Long> {
}
