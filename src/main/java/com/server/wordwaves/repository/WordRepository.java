package com.server.wordwaves.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.wordwaves.entity.vocabulary.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    Page<Word> findByNameContainingIgnoreCase(String searchQuery, Pageable pageable);
}
