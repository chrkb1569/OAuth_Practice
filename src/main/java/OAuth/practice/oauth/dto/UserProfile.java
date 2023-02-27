package OAuth.practice.oauth.dto;

import OAuth.practice.oauth.domain.User;
import lombok.Getter;

@Getter
public class UserProfile {
    private String username;
    private String provider;
    private String email;

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .provider(this.provider)
                .build();
    }
}
