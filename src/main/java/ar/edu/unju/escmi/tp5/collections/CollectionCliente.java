package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
import ar.edu.unju.escmi.tp5.dominio.Clientes;

public class CollectionCliente {

    public static List<Clientes> Clientes = new ArrayList<>();

    public static boolean autenticacion(int cod, String contrasenia) {

        for (Clientes cliente : Clientes) {

            int codigoCliente = 0;

            if (cliente instanceof ClienteMayorista) {
                codigoCliente = ((ClienteMayorista) cliente).getCodCliente();
            } else if (cliente instanceof ClienteMinorista) {
                codigoCliente = ((ClienteMinorista) cliente).getDni();
            }

            if (codigoCliente == cod &&
                    cliente.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }

        return false;
    }

    public static void precargarCliente() {

        Clientes.clear();

        Clientes.add(new ClienteMayorista(
                "Av. Belgrano 123",
                "Juan",
                "Perez",
                "1234",
                1001
        ));

        Clientes.add(new ClienteMinorista(
                "San Martin 456",
                "Maria",
                "Gomez",
                "5678",
                20310458,
                true
        ));

        Clientes.add(new ClienteMinorista(
                "Alvear 789",
                "Carlos",
                "Lopez",
                "abcd",
                25123456,
                false
        ));
    }

    public static Clientes buscarCliente(int cod) {

        for (Clientes cliente : Clientes) {

            if (cliente instanceof ClienteMayorista) {

                ClienteMayorista mayorista =
                        (ClienteMayorista) cliente;

                if (mayorista.getCodCliente() == cod) {
                    return mayorista;
                }

            } else if (cliente instanceof ClienteMinorista) {

                ClienteMinorista minorista =
                        (ClienteMinorista) cliente;

                if (minorista.getDni() == cod) {
                    return minorista;
                }
            }
        }

        return null;
    }
}