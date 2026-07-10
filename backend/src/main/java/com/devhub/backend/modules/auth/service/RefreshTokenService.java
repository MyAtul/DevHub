package com.devhub.backend.modules.auth.service;

import com.devhub.backend.modules.auth.entity.RefreshToken;
import com.devhub.backend.modules.auth.entity.User;

public interface RefreshTokenService {

    String createRefreshToken(User user);

    RefreshToken verifyRefreshToken(String refreshToken);

    void revokeRefreshToken(String refreshToken);

    void revokeAllUserTokens(User user);

    void deleteExpiredTokens();
}
