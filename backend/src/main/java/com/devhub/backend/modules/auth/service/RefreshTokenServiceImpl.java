package com.devhub.backend.modules.auth.service;

import com.devhub.backend.common.util.RandomTokenGenerator;
import com.devhub.backend.common.util.TokenHashUtil;
import com.devhub.backend.modules.auth.config.JwtProperties;
import com.devhub.backend.modules.auth.entity.RefreshToken;
import com.devhub.backend.modules.auth.entity.User;
import com.devhub.backend.modules.auth.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, JwtProperties jwtProperties) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtProperties = jwtProperties;
    }

    @Override
    public String createRefreshToken(User user) {

        String rawToken = RandomTokenGenerator.generateToken();
        System.out.println(rawToken);

        String hashToken = TokenHashUtil.hash(rawToken);
        System.out.println(hashToken);

        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setTokenHash(hashToken);
        refreshToken.setUser(user);

        refreshToken.setCreatedAt(LocalDateTime.now());
        refreshToken.setUpdatedAt(LocalDateTime.now());


        LocalDateTime expireAt =
                LocalDateTime.now()
                        .plusSeconds(
                                jwtProperties.getRefreshTokenExpiration()/1000
                        );

        refreshToken.setExpiresAt(expireAt);

        refreshTokenRepository.save(refreshToken);

        return rawToken;
    }

    @Override
    public RefreshToken verifyRefreshToken(String refreshToken) {
        return null;
    }

    @Override
    public void revokeRefreshToken(String refreshToken) {

    }

    @Override
    public void revokeAllUserTokens(User user) {

    }

    @Override
    public void deleteExpiredTokens() {

    }
}
