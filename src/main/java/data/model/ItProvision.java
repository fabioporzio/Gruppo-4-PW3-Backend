package data.model;


import jakarta.persistence.*;

@Entity
@Table(name = "MaterialeInformatico")
public class ItProvision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Tipologia", nullable = false)
    private String tipologia;

    @Column(name = "Marca", nullable = false)
    private String marca;

    @Column(name = "Seriale", nullable = false)
    private Integer seriale;

    @Column(name = "Motivazione", columnDefinition = "text", nullable = false)
    private String motivazione;

    public ItProvision() {}

    public ItProvision(String tipologia, String marca, Integer seriale, String motivazione) {
        this.tipologia = tipologia;
        this.marca = marca;
        this.seriale = seriale;
        this.motivazione = motivazione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getSeriale() {
        return seriale;
    }

    public void setSeriale(Integer seriale) {
        this.seriale = seriale;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }
}
