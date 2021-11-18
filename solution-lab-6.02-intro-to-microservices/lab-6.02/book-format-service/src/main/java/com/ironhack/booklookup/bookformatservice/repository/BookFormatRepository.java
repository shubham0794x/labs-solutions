package com.ironhack.booklookup.bookformatservice.repository;

import com.ironhack.booklookup.bookformatservice.model.BookFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookFormatRepository extends JpaRepository<BookFormat, Long> {
    @Query("SELECT format FROM BookFormat b WHERE isbn = :isbn")
    List<String> findFormatsByIsbn(Long isbn);
}
