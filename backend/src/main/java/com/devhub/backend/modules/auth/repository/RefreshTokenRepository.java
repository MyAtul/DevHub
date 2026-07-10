package com.devhub.backend.modules.auth.repository;

import com.devhub.backend.modules.auth.entity.RefreshToken;
import com.devhub.backend.modules.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    
    Optional<RefreshToken> findByTokenHash(String tokenHash);

    List<RefreshToken> findByUser(User user);

    List<RefreshToken> findByUserAndRevokedFalse(User user);

    List<RefreshToken> findByExpiresAtBefore(LocalDateTime now);

}
