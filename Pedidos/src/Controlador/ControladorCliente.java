/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoCliente;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */
public class ControladorCliente {
       private DaoCliente dao;

    public ControladorCliente() {
        this.dao = new DaoCliente();
    }
    
    public void agregarCliente(Cliente cliente) throws SQLException{
        dao.agregarCliente(cliente);
    }
    
    public Cliente buscarCliente(int id) throws SQLException{
        return dao.buscarClienteId(id);
    }
    
    public int buscarIDClienteNombre(String nombre) {
        return dao.buscarNombreCliente(nombre);
    }
    
    public void editarCliente(int id, String nombre,String email) throws SQLException{
        dao.editarCliente(id, nombre, email);
    }
    
    public void eliminarCliente(int id) throws SQLException{
        dao.eliminarCliente(id);
    }
    
    public ArrayList<Cliente> listaCliente() {
        return dao.getAllCliente();
    }
}
