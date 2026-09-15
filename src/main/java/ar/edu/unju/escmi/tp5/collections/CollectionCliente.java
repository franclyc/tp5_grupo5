package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {

    public static List<Cliente> clientes = new ArrayList<>();

    static {
        cargarClientes();
    }

    public static void cargarClientes() {

        clientes.add(
                new ClienteMayorista(
                        20310458,
                        "Juan",
                        "Perez",
                        "Av. Belgrano 125",
                        1001
                )
        );

        clientes.add(
                new ClienteMayorista(
                        25456789,
                        "Carlos",
                        "Gomez",
                        "Calle Alvear 450",
                        1002
                )
        );

        clientes.add(
                new ClienteMinorista(
                        30123456,
                        "Maria",
                        "Lopez",
                        "Calle Lavalle 320",
                        true
                )
        );

        clientes.add(
                new ClienteMinorista(
                        35456789,
                        "Ana",
                        "Martinez",
                        "Calle Güemes 780",
                        false
                )
        );
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static Cliente buscarClientePorDni(int dni) {

        for (Cliente cliente : clientes) {

            if (cliente.getDni() == dni) {
                return cliente;
            }
        }

        return null;
    }

    public static void mostrarClientes() {

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}