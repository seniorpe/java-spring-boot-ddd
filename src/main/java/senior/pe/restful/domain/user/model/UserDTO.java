package senior.pe.restful.domain.user.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import senior.pe.restful.domain.phone.model.PhoneDTO;
import senior.pe.restful.domain.shared.validation.ValidPassword;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;

    @Pattern(
            regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "El formato del correo es incorrecto."
    )
    private String email;

    @ValidPassword
    private String password;

    private LocalDateTime lastLogin;
    private Boolean isActive;
    private String token;
    private LocalDateTime created;
    private LocalDateTime modified;

    private Set<PhoneDTO> phones;
}