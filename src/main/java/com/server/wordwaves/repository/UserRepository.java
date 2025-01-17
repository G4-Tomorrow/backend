package com.server.wordwaves.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.wordwaves.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByIdAndRefreshToken(String id, String refreshToken);

    Page<User> findByFullNameContainingOrEmailContaining(String searchQuery, String searchQuery1, Pageable pageable);

    @Query("SELECT u.id FROM User u JOIN u.roles r WHERE r.name = :roleName")
    List<String> findAllUserIdsByRole(@Param("roleName") String roleName);
}
