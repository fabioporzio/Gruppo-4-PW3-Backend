package web.model;

public class ItProvisionResponse {
    private int id;
    private String tipologia;
    private String marca;
    private Integer seriale;
    private String motivazione;

    public ItProvisionResponse(int id, String tipologia, String marca, Integer seriale, String motivazione) {
        this.id = id;
        this.tipologia = tipologia;
        this.marca = marca;
        this.seriale = seriale;
        this.motivazione = motivazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
