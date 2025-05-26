package data.model.badgeRecord;

import data.model.Badge;
import data.model.BadgeReader;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Timbrature")
@IdClass(BadgeRecordCompositePrimaryKey.class)
public class BadgeRecord {

    @Id
    @Column(name = "DataTimbratura", nullable = false)
    private LocalDate data;

    @Id
    @Column(name = "OraTimbratura", nullable = false)
    private LocalTime ora;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdBadge", nullable = false)
    private Badge badge;

    @ManyToOne
    @JoinColumn(name = "IdTimbratrice")
    private BadgeReader timbratrice;

    public BadgeRecord() {}

    public BadgeRecord(LocalDate data, LocalTime ora, Badge badge, BadgeReader timbratrice) {
        this.data = data;
        this.ora = ora;
        this.badge = badge;
        this.timbratrice = timbratrice;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public BadgeReader getTimbratrice() {
        return timbratrice;
    }

    public void setTimbratrice(BadgeReader timbratrice) {
        this.timbratrice = timbratrice;
    }
}
