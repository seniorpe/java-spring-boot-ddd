package senior.pe.restful.factories;

import senior.pe.restful.domain.phone.model.Phone;

public class PhoneFactory {
    public static Phone build() {
        return new Phone(Long.valueOf(1), "+51", "1", "123456789", null);
    }
}
