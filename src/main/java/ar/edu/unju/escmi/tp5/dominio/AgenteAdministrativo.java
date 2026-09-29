package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class AgenteAdministrativo extends Empleados {

    public AgenteAdministrativo() {
        super();
    }

    public AgenteAdministrativo(int codigo, String nombre, String contrasenia) {
        super(codigo, nombre, contrasenia);
    }

    public void agregarProducto(Productos p) {
        if (p == null) {
            System.out.println("El producto no es valido");
            return;
        }
        if (CollectionProducto.buscar(p.getCodigo()) == null) {
            CollectionProducto.agregar(p);
            System.out.println("Producto agregado correctamente");
        } else {
            System.out.println("Ya existe un producto con el codigo " + p.getCodigo());
        }
    }

    public void realizarVenta(Facturas factura) {
    if (factura == null || factura.getCliente() == null) {
        System.out.println("La factura debe tener un cliente.");
        return;
    }

    if (factura.getDetalles() == null || factura.getDetalles().isEmpty()) {
        System.out.println("La factura debe tener al menos un producto.");
        return;
    }

    if (CollectionFactura.buscar(factura.getNroFactura()) != null) {
        System.out.println("Ya existe una factura con ese numero.");
        return;
    }

    CollectionFactura.agregar(factura);
    System.out.println("Venta realizada correctamente.");
}

    @Override
    public String toString() {
        return "Agente administrativo -> " + super.toString();
    }
}