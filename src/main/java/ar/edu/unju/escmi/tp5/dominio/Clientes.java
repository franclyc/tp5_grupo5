package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class Clientes {

    protected String direccion;
    protected String nombre;
    protected String apellido;
    protected String contrasenia;

    public Clientes() {
    }

    public Clientes(String direccion, String nombre, String apellido, String contrasenia) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    public Object buscarFactura(int nroFactura) {
        return CollectionFactura.buscar(nroFactura);
    }

    private int obtenerCodCliente() {
        return 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}


// IMPORTANTE : Una vez se haga Facturas.java cambiar "public Object buscarFactura(int nroFactura)" por "public Facturas buscarFactura(int nroFactura)" y agregar el import corrponiente