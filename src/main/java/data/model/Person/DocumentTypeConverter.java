package data.model.Person;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, String> {
    @Override
    public String convertToDatabaseColumn(DocumentType attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public DocumentType convertToEntityAttribute(String dbData) {
        return DocumentType.fromDbValue(dbData);
    }
}
