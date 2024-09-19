package senior.pe.restful.domain.shared.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import senior.pe.restful.infrastructure.properties.PasswordProperties;

/**
 * PasswordValidator is a custom implementation of the ConstraintValidator interface,
 * which validates that a given password meets the specified regular expression (regex) criteria.
 *
 * This validator checks if the password matches the pattern defined in the application's configuration.
 * The configuration values, such as the regex and error message, are injected through the
 * PasswordProperties class.
 *
 * @Autowired PasswordProperties: Injects the properties that contain the regex pattern and
 * the error message used for password validation.
 *
 * @Override initialize(ValidPassword): This method is part of the ConstraintValidator interface.
 * In this implementation, it does not perform any initialization logic.
 *
 * @Override isValid(String password, ConstraintValidatorContext context): Validates the provided password.
 *
 *  - Retrieves the regex pattern and error message from PasswordProperties.
 *  - Returns false if the password is null.
 *  - If the password doesn't match the regex pattern, it customizes the violation message by disabling
 *    the default violation and adding a custom one.
 *  - Returns true if the password is valid according to the regex, otherwise false.
 *
 * Usage:
 * This class is typically used with the @ValidPassword annotation to enforce password policies in
 * form inputs or other data sources.
 *
 * Example:
 *
 * {@code
 * @ValidPassword
 * private String password;
 * }
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Autowired
    private PasswordProperties passwordProperties;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        // No initialization required in this implementation
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        String regex = passwordProperties.getPasswordRegex();
        String message = passwordProperties.getPasswordRegexMessage();

        if (password == null) {
            return false; // Invalid if password is null
        }

        boolean isValid = password.matches(regex);

        if (!isValid) {
            // Customize violation message if the password doesn't match the regex
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }

        return isValid;
    }
}
