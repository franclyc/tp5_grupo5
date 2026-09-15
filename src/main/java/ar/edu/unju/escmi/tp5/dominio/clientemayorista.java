package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {

    private int codigoCliente;

    public ClienteMayorista() {
        super();
    }

    public ClienteMayorista(int dni, String nombre, String apellido,
            String direccion, int codigoCliente) {

        super(dni, nombre, apellido, direccion);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "ClienteMayorista{" +
                "dni=" + getDni() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", codigoCliente=" + codigoCliente +
                '}';
    }
}