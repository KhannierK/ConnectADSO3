package Modelo;

public class PQyR {
    private String referencia;
    private String casa;
    private String solicitud;
    private String respuesta;
    private boolean solucionado;
    public PQyR(String casa, String solicitud){
        this.casa = casa;
        this.solicitud = solicitud;
        this.respuesta = "";
        this.solucionado = false;
        this.referencia = "";
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    @Override
    public String toString() {
        return "PQyR{" +
                "referencia='" + referencia + '\'' +
                ", casa='" + casa + '\'' +
                ", solicitud='" + solicitud + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", solucionado=" + solucionado +
                '}';
    }
}
