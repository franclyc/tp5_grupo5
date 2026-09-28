package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class Facturas {

    private static final double DESCUENTO_PAMI = 0.10;

    private int nroFactura;
    private LocalDate fecha;
    private double total;
    private Clientes cliente;
    private List<Detalles> detalles = new ArrayList<>();

    public Facturas() {
    }

    public Facturas(int nroFactura, LocalDate fecha, Clientes cliente) {
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public boolean agregarDetalle(Productos p, int cantidad) {

        if (!CollectionProducto.comprobarStockVenta(cliente, p, cantidad)) {
            return false;
        }

        double precio = p.getPrecioUnitario();
        if (cliente instanceof ClienteMayorista) {
            precio = precio / 2;
        }

        if (!CollectionStock.descontar(p.getCodigo(), cantidad)) {
            return false;
        }

        detalles.add(new Detalles(p, cantidad, precio));
        calcularTotal();
        return true;
    }

    public double calcularTotal() {
        double suma = 0;
        for (Detalles d : detalles) {
            suma += d.calcularSubtotal();
        }

        if (cliente instanceof ClienteMinorista && ((ClienteMinorista) cliente).isTienePami()) {
            suma = suma - (suma * DESCUENTO_PAMI);
        }

        total = suma;
        return total;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Detalles> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        String texto = "==============================================\n";
        texto += "FACTURA Nro: " + nroFactura + "   Fecha: " + fecha + "\n";
        if (cliente != null) {
            texto += "Cliente: " + cliente.getApellido() + ", " + cliente.getNombre()
                    + " - " + cliente.getDireccion() + "\n";
        }
        texto += "----------------------------------------------\n";
        for (Detalles d : detalles) {
            texto += d + "\n";
        }
        texto += "----------------------------------------------\n";
        texto += "TOTAL: $" + total + "\n";
        texto += "==============================================";
        return texto;
    }
}
