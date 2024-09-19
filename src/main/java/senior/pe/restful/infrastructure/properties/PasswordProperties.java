package senior.pe.restful.infrastructure.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PasswordProperties {

    @Value("${password.regex}")
    private String passwordRegex;

    @Value("${password.regex.message}")
    private String passwordRegexMessage;
}
