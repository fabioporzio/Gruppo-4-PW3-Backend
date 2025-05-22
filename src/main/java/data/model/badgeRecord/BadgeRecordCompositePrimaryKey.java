package data.model.badgeRecord;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class BadgeRecordCompositePrimaryKey implements Serializable {
    public LocalDate data;
    public LocalTime ora;
    public Integer badge;

    public BadgeRecordCompositePrimaryKey() {}

    public BadgeRecordCompositePrimaryKey(LocalDate data, LocalTime ora, Integer badge) {
        this.data = data;
        this.ora = ora;
        this.badge = badge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadgeRecordCompositePrimaryKey)) return false;
        BadgeRecordCompositePrimaryKey that = (BadgeRecordCompositePrimaryKey) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(ora, that.ora) &&
                Objects.equals(badge, that.badge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, ora, badge);
    }
}
