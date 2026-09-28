package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Productos;

public class CollectionStock {

    public static List<Productos> stock = new ArrayList<>();

    public static void registrar(Productos p) {
        if (p != null && buscar(p.getCodigo()) == null) {
            stock.add(p);
        }
    }

    public static Productos buscar(int codProducto) {
        for (Productos producto : stock) {
            if (producto.getCodigo() == codProducto) {
                return producto;
            }
        }
        return null;
    }

    public static int consultar(int codProducto) {
        Productos producto = buscar(codProducto);
        if (producto != null) {
            return producto.getStock();
        }
        return 0;
    }

    public static boolean hayStock(int codProducto, int cantidad) {
        return cantidad > 0 && consultar(codProducto) >= cantidad;
    }

    public static boolean descontar(int codProducto, int cantidad) {
        if (!hayStock(codProducto, cantidad)) {
            return false;
        }
        Productos producto = buscar(codProducto);
        producto.setStock(producto.getStock() - cantidad);
        return true;
    }

    public static boolean reponer(int codProducto, int cantidad) {
        Productos producto = buscar(codProducto);
        if (producto == null || cantidad <= 0) {
            return false;
        }
        producto.setStock(producto.getStock() + cantidad);
        return true;
    }
}
