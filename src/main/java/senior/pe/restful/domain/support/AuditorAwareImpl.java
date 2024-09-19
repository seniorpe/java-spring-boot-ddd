package senior.pe.restful.domain.support;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * AuditorAwareImpl is an implementation of the AuditorAware interface
 * used to provide the current auditor (typically the username) for auditing purposes.
 *
 * In this implementation, the auditor is currently hardcoded to return "system".
 * This is a temporary placeholder and should be replaced with logic to retrieve
 * the authenticated user's username.
 *
 * Usage:
 * This class can be used in Spring Data JPA to automatically populate auditing fields
 * such as createdBy and lastModifiedBy with the current auditor.
 *
 * @Component: Marks this class as a Spring-managed component, so it can be injected where needed.
 *
 * @return Optional<String>: Returns an Optional containing the username of the current auditor.
 * Currently, it returns "system" as a placeholder.
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO: Temporary, replace with the authenticated user
        return Optional.of("system");
    }
}

