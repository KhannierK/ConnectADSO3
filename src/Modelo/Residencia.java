package Modelo;

public class Residencia {
    private String propietario;
    private boolean pago;
    private boolean residentes;
    public Residencia(){}
    public Residencia( String propietario, boolean residentes) {
        this.propietario = propietario;
        this.pago = true;
        this.residentes = residentes;
    }



    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isResidentes() {
        return residentes;
    }

    public void setResidentes(boolean residentes) {
        this.residentes = residentes;
    }

    @Override
    public String toString() {
        return "{" +
                "propietario='" + propietario + '\'' +
                ", pago=" + pago +
                ", residentes=" + residentes +
                '}';
    }
}
