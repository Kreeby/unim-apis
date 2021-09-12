package com.unim.unimapis.models.converters;

import com.unim.unimapis.models.enums.DegreeType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DegreeTypeJPAConverter implements AttributeConverter<DegreeType, String> {

  @Override
  public String convertToDatabaseColumn(DegreeType genderType) {
    if(genderType == null) {
      return null;
    }
    return genderType.getValue();
  }

  @Override
  public DegreeType convertToEntityAttribute(String label) {
    if(label == null) {
      return null;
    }
    return DegreeType.fromValue(label);
  }
}
