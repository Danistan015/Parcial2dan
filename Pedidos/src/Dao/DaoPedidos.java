/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.DatabaseSingleton;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */
public class DaoPedidos {

    private Connection con;

    public DaoPedidos() {
        this.con = DatabaseSingleton.getInstance().getConnection();

    }

    public void agregarPedido(Pedido pedido) throws SQLException {
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO pedidos (PedidoId,FechaPedido,Total,cliente_id) VALUES (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setString(2, pedido.getFechaPedido());
            ps.setDouble(3, pedido.getTotal());
            ps.setInt(4, pedido.getCliente_id());
            ps.execute();

        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public Pedido buscarPedidoId(int id) throws SQLException {
        Pedido pedidoEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = " WHERE PedidoId = '" + id + "'";
        String sql = "SELECT * FROM pedidos" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("FechaPedido");
                int total = rs.getInt("Total");
                int cliente_id = rs.getInt("cliente_id");
                pedidoEncontrado = new Pedido(fecha, total, id, cliente_id);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return pedidoEncontrado;
    }

    public void editarpedido(int id, String fecha, double total, int id_cliente) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE pedidos SET FechaPedido=?, Total=?, cliente_id=? WHERE PedidoId=?");
            ps.setString(1, fecha);
            ps.setDouble(2, total);
            ps.setInt(3, id_cliente);
            ps.setInt(4, id);
            ps.execute();

        } catch (SQLException ex) {
        } finally {

            if (ps != null) {
                ps.close();
            }
        }
    }

    public void eliminarPedido(int id) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM pedidos WHERE PedidoId= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public ArrayList<Pedido> lista() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT p.PedidoId, c.Nombre, p.FechaPedido, p.Total "
                    + "FROM pedidos p "
                    + "INNER JOIN clientes as c ON p.cliente_id = c.ClienteId";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PedidoId");
                String fecha = rs.getString("FechaPedido");
                int total = rs.getInt("Total");
                String nombreCliente = rs.getString("Nombre");

                Pedido pedido = new Pedido(fecha, total, id, nombreCliente);
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
        }
        System.out.println(pedidos);
        return pedidos;
    }

}
