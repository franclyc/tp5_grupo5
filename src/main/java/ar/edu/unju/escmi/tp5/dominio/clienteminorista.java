package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {

    private boolean obraSocialPAMI;

    public ClienteMinorista() {
        super();
    }

    public ClienteMinorista(int dni, String nombre, String apellido,
            String direccion, boolean obraSocialPAMI) {

        super(dni, nombre, apellido, direccion);
        this.obraSocialPAMI = obraSocialPAMI;
    }

    public boolean isObraSocialPAMI() {
        return obraSocialPAMI;
    }

    public void setObraSocialPAMI(boolean obraSocialPAMI) {
        this.obraSocialPAMI = obraSocialPAMI;
    }

    @Override
    public String toString() {
        return "ClienteMinorista{" +
                "dni=" + getDni() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", obraSocialPAMI=" + obraSocialPAMI +
                '}';
    }
}