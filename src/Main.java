import Controlador.Controlador_PQyR;
import Modelo.BD_PQyR;
import Modelo.BD_Residencias;
import Vista.Vista_PQyR;

public class Main {
    public static void main(String[] args) {

        BD_PQyR modelo = new BD_PQyR();
        Vista_PQyR vista = new Vista_PQyR();
        Controlador_PQyR controlador= new Controlador_PQyR(modelo, vista);
        controlador.iniciar();
    }
}