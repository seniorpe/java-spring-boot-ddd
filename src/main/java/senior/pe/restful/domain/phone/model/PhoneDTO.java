package senior.pe.restful.domain.phone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private String number;

    @JsonProperty("citycode")
    private String cityCode;

    @JsonProperty("countrycode")
    private String countryCode;
}
