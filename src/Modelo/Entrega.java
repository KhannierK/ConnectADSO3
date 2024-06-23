package Modelo;

public class Entrega {
    private String referencia;
    private String casa;
    private String tipo;
    private String descripcion;
    private boolean recogido;

    public Entrega(String referencia,String casa, String tipo, String descripcion) {
        this.referencia = referencia;
        this.casa = casa;
        this.tipo = tipo;
        this.descripcion = descripcion;
        recogido = false;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCasa() { return casa; }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRecogido() {
        return recogido;
    }

    public void setRecogido(boolean recogido) {
        this.recogido = recogido;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "referencia='" + referencia + '\'' +
                ", casa='" + casa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", recogido=" + recogido +
                '}';
    }
}
