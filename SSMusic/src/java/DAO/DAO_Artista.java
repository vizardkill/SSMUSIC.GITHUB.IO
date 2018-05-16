/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author scardonas
 */
public class DAO_Artista implements IArtista_DAO {

    @Override
    public boolean setArtista(Artista art) {
        Connection con;
        String sql = "INSERT INTO ARTISTA"
                + "("
                + "ID_ARTISTA, "
                + "NOM_ARTISTA, "
                + "NOM_REPRESENTANTE, "
                + "DOC_REPRESENTANTE, "
                + "TEL_REPRESENTANTE, "
                + "COR_REPRESENTANTE, "
                + "ID_EMPRESA_D_ART, "
                + "FECHA_REGISTRO_ART, "
                + "SRC"
                + ") "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, 1);
                ps.setString(2, art.getNombre_art());
                ps.setString(3, art.getNom_representante());
                ps.setString(4, art.getDoc_representante());
                ps.setString(5, art.getTel_representante());
                ps.setString(6, art.getCor_representante());
                ps.setInt(7, art.getId_empresa_d_art());
                ps.setString(8, art.getFecha_registro_art());
                ps.setString(9, art.getSrc());
                ps.executeUpdate();
                ps.close();
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Artista, método registrar" + ex);
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<Artista> getArtistas() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM ARTISTA ORDER BY NOM_ARTISTA ASC";
        ArrayList<Artista> listaArtista = new ArrayList<>();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Artista art = new Artista();
                art.setId(rs.getInt("ID_ARTISTA"));
                art.setNombre_art(rs.getString("NOM_ARTISTA"));
                art.setNom_representante(rs.getString("NOM_REPRESENTANTE"));
                art.setDoc_representante(rs.getString("DOC_REPRESENTANTE"));
                art.setTel_representante(rs.getString("TEL_REPRESENTANTE"));
                art.setCor_representante(rs.getString("COR_REPRESENTANTE"));
                art.setId_empresa_d_art(rs.getInt("ID_EMPRESA_D_ART"));
                art.setFecha_registro_art(rs.getString("FECHA_REGISTRO_ART"));
                art.setSrc(rs.getString("SRC"));
                listaArtista.add(art);
            }
            stm.close();
            rs.close();
            co.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Artista, método obtener");
        }
        return listaArtista;
    }

    @Override
    public boolean deleteArtista(Artista art) {
        Connection con;

        String sql = "DELETE FROM ARTISTA WHERE ID_ARTISTA = ?";

        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, art.getId());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Artista, método eliminar");
            return false;
        }
        return true;

    }

    @Override
    public boolean updateArtista(Artista art) {
        Connection con;

        String sql = "UPDATE ARTISTA SET "
                + "NOM_ARTISTA = ?, "
                + "NOM_REPRESENTANTE = ?, "
                + "DOC_REPRESENTANTE = ?, "
                + "TEL_REPRESENTANTE = ?, "
                + "COR_REPRESENTANTE = ?, "
                + "WHERE ID_ARTISTA = ?";
        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, art.getNombre_art());
                ps.setString(2, art.getNom_representante());
                ps.setString(3, art.getDoc_representante());
                ps.setString(4, art.getTel_representante());
                ps.setString(5, art.getCor_representante());
                ps.setInt(6, art.getId());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_ARTISTA, método eliminar");
            return false;
        }
        return true;

    }

}
