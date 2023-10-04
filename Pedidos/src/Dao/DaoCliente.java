/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.DatabaseSingleton;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */
public class DaoCliente {
    private Connection con;

    public DaoCliente() {
        this.con = DatabaseSingleton.getInstance().getConnection();

    }

    public void agregarCliente(Cliente cliente) throws SQLException {
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO clientes (ClienteId,Nombre,Email) VALUES (?,?,?)";
            ps = con.prepareStatement(sql);
             ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
             ps.setString(3, cliente.getEmail());
            ps.execute();

        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public Cliente buscarClienteId(int id) throws SQLException {
        Cliente clienteEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = " WHERE ClienteId = '" + id + "'";
        String sql = "SELECT * FROM clientes" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String email = rs.getString("Email");
                clienteEncontrado = new Cliente(nombre, id, email);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return clienteEncontrado;
    }

    public int buscarNombreCliente(String nombre)  {
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = " WHERE Nombre = '" + nombre + "'";
        String sql = "SELECT * FROM clientes" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ClienteId");
            }
        } catch (SQLException ex) {
            
        }
        return id;
    }

    public void editarCliente(int id, String nombre,String email) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE clientes SET Nombre=?,Email=? WHERE ClienteId=?");
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void eliminarCliente(int id) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM clientes WHERE ClienteId= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public ArrayList<Cliente> getAllCliente() {
        ArrayList<Cliente> cliente = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM clientes";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String Name = rs.getString("Nombre");
                String email = rs.getString("Email");
                int id = rs.getInt("ClienteId");
                Cliente clientes = new Cliente(Name, id, email);
                cliente.add(clientes);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return cliente;
    }
    
}
