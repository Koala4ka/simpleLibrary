package com.library.dao;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Long> {


}
