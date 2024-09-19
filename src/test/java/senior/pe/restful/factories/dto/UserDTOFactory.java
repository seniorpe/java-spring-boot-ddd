package senior.pe.restful.factories.dto;

import senior.pe.restful.domain.user.model.UserDTO;

import java.util.UUID;

public class UserDTOFactory {
    public static UserDTO build() {
        return UserDTO.builder()
                .id(UUID.randomUUID())
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("Hunter2Password10")
                .phones(null)
                .build();
    }
}
