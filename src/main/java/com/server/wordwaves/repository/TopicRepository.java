package com.server.wordwaves.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.wordwaves.entity.vocabulary.Topic;
import com.server.wordwaves.entity.vocabulary.Word;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {

    // Tìm các từ trong một topic theo topicId và searchQuery
    @Query("SELECT w FROM Topic t JOIN t.words w WHERE t.id = :topicId AND w.name LIKE %:searchQuery%")
    Page<Word> findWordsByTopicIdAndNameContainingIgnoreCase(
            @Param("topicId") String topicId, @Param("searchQuery") String searchQuery, Pageable pageable);

    // Tìm tất cả các từ trong một topic
    @Query("SELECT w FROM Topic t JOIN t.words w WHERE t.id = :topicId")
    Page<Word> findWordsByTopicId(@Param("topicId") String topicId, Pageable pageable);

    @Query(value = "SELECT ttw.TopicId FROM TopicToWord ttw WHERE ttw.WordId = :wordId", nativeQuery = true)
    List<String> findTopicIdsByWordId(String wordId);

    Page<Topic> findByCreatedById(String userId, Pageable pageable);

    Page<Topic> findByNameContainingIgnoreCase(String searchQuery, Pageable pageable);

    Page<Topic> findByCreatedByIdAndNameContainingIgnoreCase(String userId, String searchQuery, Pageable pageable);

    @Query("SELECT t.createdById FROM Topic t WHERE t.id = :identifierId")
    String findCreatedByIdById(@Param("identifierId") String identifierId);
}
