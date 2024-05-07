/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author gabri
 */
public class Partecipanti {

    private int idPartecipanti;
    private int idViaggio;
    private int idTurista;
    private String statoPrenatazione;

    public int getIdPartecipanti() {
        return idPartecipanti;
    }

    public void setIdPartecipanti(int idPartecipanti) {
        this.idPartecipanti = idPartecipanti;
    }

    public int getIdViaggio() {
        return idViaggio;
    }

    public void setIdViaggio(int idViaggio) {
        this.idViaggio = idViaggio;
    }

    public int getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(int idTurista) {
        this.idTurista = idTurista;
    }

    public String getStatoPrenatazione() {
        return statoPrenatazione;
    }

    public void setStatoPrenatazione(String statoPrenatazione) {
        this.statoPrenatazione = statoPrenatazione;
    }

}
