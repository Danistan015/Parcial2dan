/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author sotog
 */
public class Pedido {
    private String fechaPedido;
    private int total;
    private int idPedido;
    private int cliente_id;
    private String nombreCliente;

    public Pedido(String fechaPedido, int total, int idPedido, int cliente_id) {
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.idPedido = idPedido;
        this.cliente_id = cliente_id;
    }

    public Pedido(String fechaPedido, int total, int idPedido, String nombreCliente) {
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
    }
    

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }



    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}
