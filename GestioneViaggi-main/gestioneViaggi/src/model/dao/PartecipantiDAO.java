package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bean.Partecipanti;

/**
 *
 * @author gabri
 */
public class PartecipantiDAO {

    public void create(Partecipanti p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO partecipanti"
                    + "(id_viaggio, id_turista, stato_prenotazione) VALUES (?,?,?)");
            stmt.setInt(1, p.getIdViaggio());
            stmt.setInt(2, p.getIdTurista());
            stmt.setString(3, p.getStatoPrenatazione());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Partecipanti> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Partecipanti> partecipanti = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM partecipanti");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Partecipanti partecipante = new Partecipanti();

                partecipante.setIdPartecipanti(rs.getInt("id_partecipante"));
                partecipante.setIdViaggio(rs.getInt("id_viaggio"));
                partecipante.setIdTurista(rs.getInt("id_turista"));
                partecipante.setStatoPrenatazione(rs.getString("stato_prenotazione"));

                partecipanti.add(partecipante);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return partecipanti;
    }

    public void update(Partecipanti p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE partecipanti SET"
                    + " id_viaggio= ?, id_turista=?, stato_prenotazione= ?"
                    + " WHERE id_turista= ?");

            stmt.setInt(1, p.getIdViaggio());
            stmt.setInt(2, p.getIdTurista());
            stmt.setString(3, p.getStatoPrenatazione());
            stmt.setInt(4, p.getIdPartecipanti());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Partecipanti p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM partecipanti WHERE id_partecipante= ?");
            stmt.setInt(1, p.getIdPartecipanti());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Partecipanti> readForStato(String stato) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Partecipanti> partecipanti = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM partecipanti WHERE stato_prenotazione LIKE ?");
            stmt.setString(1, "%" + stato + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Partecipanti partecipante = new Partecipanti();

                partecipante.setIdPartecipanti(rs.getInt("id_partecipante"));
                partecipante.setIdViaggio(rs.getInt("id_viaggio"));
                partecipante.setIdTurista(rs.getInt("id_turista"));
                partecipante.setStatoPrenatazione(rs.getString("stato_prenotazione"));
                partecipanti.add(partecipante);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return partecipanti;
    }

    public ResultSet join() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        
        try {
            String query = "SELECT p.id_partecipante, v.destinazione, v.data_partenza, v.data_ritorno, "
                    + "t.nome, t.cognome, t.data_nascita, t.nazionalita, t.email, t.documento, p.stato_prenotazione "
                    + "FROM partecipanti p "
                    + "JOIN viaggi v ON p.id_viaggio = v.id_viaggio "
                    + "JOIN turisti t ON p.id_turista = t.id_turista";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar com join: " + ex);
        } 
        
        return rs;
    }
}
