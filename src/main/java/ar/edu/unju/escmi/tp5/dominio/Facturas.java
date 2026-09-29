package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facturas {

    private static final double DESCUENTO_PAMI = 0.10;

    private int nroFactura;
    private LocalDate fecha;
    private double total;
    private Clientes cliente;
    private boolean presentoDni;
    private List<Detalles> detalles = new ArrayList<>();

    public Facturas() {
    }

    public Facturas(int nroFactura, LocalDate fecha, Clientes cliente) {
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.presentoDni = false;
    }

    public Facturas(int nroFactura, LocalDate fecha, Clientes cliente, boolean presentoDni) {
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.presentoDni = presentoDni;
    }

   
public boolean agregarDetalle(Productos p, int cantidad) {
    if (p == null || cliente == null || cantidad <= 0) {
        return false;
    }

    Productos producto = CollectionProducto.buscar(p.getCodigo());
    if (producto == null) {
        return false;
    }

    int unidadesReales = cantidad;
    if (cliente instanceof ClienteMayorista) {
        unidadesReales = cantidad * 10;
    }

    double precio = producto.getPrecioUnitario();
    if (cliente instanceof ClienteMayorista) {
        precio = precio / 2.0;
    }

    detalles.add(new Detalles(producto, unidadesReales, precio));
    calcularTotal();
    return true;
}
    public double calcularTotal() {
        double suma = 0;
        for (Detalles d : detalles) {
            suma += d.calcularSubtotal();
        }

        if (cliente instanceof ClienteMinorista) {
            ClienteMinorista minorista = (ClienteMinorista) cliente;
            if (presentoDni && minorista.isTienePami()) {
                suma -= suma * DESCUENTO_PAMI;
            }
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
        if (!detalles.isEmpty()) {
            return;
        }
        this.cliente = cliente;
    }

    public boolean isPresentoDni() {
        return presentoDni;
    }

    public void setPresentoDni(boolean presentoDni) {
    this.presentoDni = presentoDni;
    calcularTotal();
}

    public List<Detalles> getDetalles() {
        return new ArrayList<>(detalles);
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
