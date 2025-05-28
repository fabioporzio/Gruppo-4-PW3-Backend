package data.model.Person;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
    CI("C.I."),
    PATENTE("PATENTE"),
    PASSAPORTO("PASSAPORTO");


    private final String dbValue;

    DocumentType(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static DocumentType fromDbValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        for (DocumentType dt : values()) {
            if (dt.dbValue.equalsIgnoreCase(value.trim()) || dt.name().equalsIgnoreCase(value.trim())) {
                return dt;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentType value: " + value);
    }

    @JsonCreator
    public static DocumentType fromJson(String value) {
        return fromDbValue(value);
    }

    @JsonValue
    public String toJson() {
        return this.dbValue;
    }
}
