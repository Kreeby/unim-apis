package com.unim.unimapis.models.converters;

import com.unim.unimapis.models.enums.GenderType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderTypeJPAConverter implements AttributeConverter<GenderType, String> {

  @Override
  public String convertToDatabaseColumn(GenderType genderType) {
    if(genderType == null) {
      return null;
    }
    return genderType.getValue();
  }

  @Override
  public GenderType convertToEntityAttribute(String label) {
    if(label == null) {
      return null;
    }
    return GenderType.fromValue(label);
  }
}
