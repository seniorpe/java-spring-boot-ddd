package senior.pe.restful.domain.phone.mapper;

import org.mapstruct.Mapper;
import senior.pe.restful.domain.phone.model.Phone;
import senior.pe.restful.domain.phone.model.PhoneDTO;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    Phone toEntity(PhoneDTO phoneDTO);

    PhoneDTO toDto(Phone phone);
}
