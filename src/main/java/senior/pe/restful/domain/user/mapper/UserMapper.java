package senior.pe.restful.domain.user.mapper;

import org.mapstruct.Mapper;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.model.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}