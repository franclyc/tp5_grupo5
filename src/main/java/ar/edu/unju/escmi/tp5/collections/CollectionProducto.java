package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {

    public static List<Producto> productos = new ArrayList<>();

    public static void agregarProducto(Producto producto) {

        productos.add(producto);
    }

    public static Producto buscarProductoPorCodigo(int codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }

    public static void mostrarProductos() {

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}