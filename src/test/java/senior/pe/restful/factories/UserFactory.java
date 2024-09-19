package senior.pe.restful.factories;

import senior.pe.restful.domain.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UserFactory {
    public static User build() {
        return new User(UUID.randomUUID(),
                "Geroge Bush",
                generateRandomEmail(),
                "StrongPass10",
                LocalDateTime.now(),
                Boolean.TRUE,
                "token",
                List.of(PhoneFactory.build()));
    }

    public static String generateRandomEmail() {
        String localPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

        String[] domains = {"example.com", "test.com", "email.com"};
        String domain = domains[new Random().nextInt(domains.length)];

        return localPart + "@" + domain;
    }
}
