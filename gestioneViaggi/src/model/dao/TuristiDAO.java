package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bean.Turisti;

/**
 *
 * @author gabri
 */
public class TuristiDAO {

    public void create(Turisti t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO turisti"
                    + "(nome, cognome, data_nascita, nazionalita, email,"
                    + "documento) "
                    + "VALUES (?,?,?,?,?,?)");
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getCognome());
            stmt.setString(3, t.getDataNascita());
            stmt.setString(4, t.getNazionalita());
            stmt.setString(5, t.getEmail());
            stmt.setString(6, t.getDocumento());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Turisti> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turisti> turista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM turisti");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Turisti turisti = new Turisti();
                
                turisti.setIdTurista(rs.getInt("id_turista"));
                turisti.setNome(rs.getString("nome"));
                turisti.setCognome(rs.getString("cognome"));
                turisti.setDataNascita(rs.getString("data_nascita"));
                turisti.setNazionalita(rs.getString("nazionalita"));
                turisti.setEmail(rs.getString("email"));
                turisti.setDocumento(rs.getString("documento"));
                turista.add(turisti);
            }    
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return turista;       
    }
    
    public void update(Turisti t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE turisti SET"
                    + " nome= ?, cognome= ?, data_nascita= ?, nazionalita= ?,"
                    + " email= ?, documento= ?"
                    + " WHERE id_turista= ?");
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getCognome());
            stmt.setString(3, t.getDataNascita());
            stmt.setString(4, t.getNazionalita());
            stmt.setString(5, t.getEmail());
            stmt.setString(6, t.getDocumento());
            stmt.setInt(7, t.getIdTurista());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Turisti t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM turisti WHERE id_turista= ?");
            stmt.setInt(1, t.getIdTurista());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Turisti> readForDest(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turisti> turista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM turisti WHERE nome LIKE ?");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Turisti turisti = new Turisti();
                
                turisti.setIdTurista(rs.getInt("id_turista"));
                turisti.setNome(rs.getString("nome"));
                turisti.setCognome(rs.getString("cognome"));
                turisti.setDataNascita(rs.getString("data_nascita"));
                turisti.setNazionalita(rs.getString("nazionalita"));
                turisti.setEmail(rs.getString("email"));
                turisti.setDocumento(rs.getString("documento"));
                turista.add(turisti);
            }    
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return turista;       
    }
}
