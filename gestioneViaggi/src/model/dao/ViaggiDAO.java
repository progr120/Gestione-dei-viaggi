package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Viaggi;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class ViaggiDAO {

    public void create(Viaggi v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO viaggi"
                    + "(destinazione, data_partenza, data_ritorno, posti_disponibili) "
                    + "VALUES (?,?,?,?)");
            stmt.setString(1, v.getDestinazione());
            stmt.setString(2, v.getDataPartenza());
            stmt.setString(3, v.getDataRitorno());
            stmt.setInt(4, v.getPostiDisponibili());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Viaggi> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Viaggi> viaggio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM viaggi");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Viaggi viaggi = new Viaggi();

                viaggi.setIdViaggio(rs.getInt("id_viaggio"));
                viaggi.setDestinazione(rs.getString("destinazione"));
                viaggi.setDataPartenza(rs.getString("data_partenza"));
                viaggi.setDataRitorno(rs.getString("data_ritorno"));
                viaggi.setPostiDisponibili(rs.getInt("posti_disponibili"));
                viaggio.add(viaggi);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return viaggio;
    }

    public void update(Viaggi v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE viaggi SET"
                    + " destinazione= ?, data_partenza= ?, data_ritorno= ?, posti_disponibili= ?"
                    + " WHERE id_viaggio= ?");
            stmt.setString(1, v.getDestinazione());
            stmt.setString(2, v.getDataPartenza());
            stmt.setString(3, v.getDataRitorno());
            stmt.setInt(4, v.getPostiDisponibili());
            stmt.setInt(5, v.getIdViaggio());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Viaggi v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM  viaggi WHERE id_viaggio= ?");
            stmt.setInt(1, v.getIdViaggio());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Viaggi> readForDest(String dest) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Viaggi> viaggio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM viaggi WHERE destinazione LIKE ?");
            stmt.setString(1, "%" + dest + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Viaggi viaggi = new Viaggi();

                viaggi.setIdViaggio(rs.getInt("id_viaggio"));
                viaggi.setDestinazione(rs.getString("destinazione"));
                viaggi.setDataPartenza(rs.getString("data_partenza"));
                viaggi.setDataRitorno(rs.getString("data_ritorno"));
                viaggi.setPostiDisponibili(rs.getInt("posti_disponibili"));
                viaggio.add(viaggi);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return viaggio;
    }
    
}
