package model.bean;

/**
 *
 * @author gabri
 */

public class Viaggi {
    
    private int idViaggio;
    private String destinazione;
    private String dataPartenza;
    private String dataRitorno;
    private int postiDisponibili;

    public int getIdViaggio() {
        return idViaggio;
    }

    public void setIdViaggio(int idViaggio) {
        this.idViaggio = idViaggio;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(String dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public String getDataRitorno() {
        return dataRitorno;
    }

    public void setDataRitorno(String dataRitorno) {
        this.dataRitorno = dataRitorno;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    
}
