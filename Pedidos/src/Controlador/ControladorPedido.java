/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoPedidos;
import Modelo.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */
public class ControladorPedido {
    private DaoPedidos dao;

    public ControladorPedido() {
        this.dao = new DaoPedidos();
    }
    
    public Pedido buscarPedido(int id) throws SQLException{
        return dao.buscarPedidoId(id);
    }
  
  
    public void agregar(Pedido pedido) throws SQLException{
        dao.agregarPedido(pedido);
    }
    
    public void editarPedido(int id, String fecha,double total,int cliente_id) throws SQLException {
        dao.editarpedido(id, fecha, total, cliente_id);
    }
    
    public void eliminarPedido(int id) throws SQLException{
        dao.eliminarPedido(id);
    }
    
   
    
    public ArrayList<Pedido> lista () throws SQLException {
        return dao.lista();
    }
}