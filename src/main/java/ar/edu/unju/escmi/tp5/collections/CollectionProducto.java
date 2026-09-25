package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.Clientes;
import ar.edu.unju.escmi.tp5.dominio.Productos;

public class CollectionProducto {

    public static List<Productos> Productos = new ArrayList<>();

    public static int verificarStock(int cod) {

        Productos producto = buscar(cod);

        if (producto != null) {
            return producto.getStock();
        }

        return 0;
    }

    public static Productos buscar(int codProducto) {

        for (Productos producto : Productos) {

            if (producto.getCodigo() == codProducto) {
                return producto;
            }
        }

        return null;
    }

    public static void agregar(Productos p) {

        if (p == null) {
            return;
        }

        if (buscar(p.getCodigo()) == null) {
            Productos.add(p);
        }
    }

    public static boolean comprobarStockVenta(
            Clientes c, Productos p, int cantidad) {

        if (c == null || p == null || cantidad <= 0) {
            return false;
        }

        if (buscar(p.getCodigo()) == null) {
            return false;
        }

        if (p.getStock() < cantidad) {
            return false;
        }

        if (c instanceof ClienteMayorista) {
            if (cantidad % 10 != 0) {
                return false;
            }
        }

        return true;
    }
}