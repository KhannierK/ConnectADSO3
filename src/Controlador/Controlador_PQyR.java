package Controlador;

import Modelo.BD_PQyR;
import Modelo.PQyR;
import Vista.Vista_PQyR;

import javax.swing.*;
import java.util.HashMap;

public class Controlador_PQyR {
    BD_PQyR modelo;
    Vista_PQyR vista;

    public Controlador_PQyR(BD_PQyR modelo, Vista_PQyR vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int op;
        while (true) {
            op = Vista_PQyR.menu();
            switch (op) {
                case 1:
                    String casaConsulta = vista.getString("casa para consultar solicitudes");
                    vista.consultarPQyR(modelo.consultarPQyR(casaConsulta));
                    break;
                case 2:
                    PQyR pqyr = Vista_PQyR.detallesPQyR();
                    modelo.agregarPQyR(pqyr);
                    vista.mostrarMensaje("Solicitud agregada exitosamente");
                    break;
                case 3:
                    String referenciaEliminar = vista.getString("referencia de la solicitud a eliminar");
                    if (referenciaEliminar != null) {
                        modelo.eliminarPQyR(referenciaEliminar);
                    }
                    break;
                case 4:
                    String referenciaResponder = vista.getString("referencia de la solicitud a responder");
                    PQyR pqyrResponder = modelo.validarPQyRString(referenciaResponder);
                    if (pqyrResponder != null) {
                        String respuesta = vista.getRespuesta();
                        if (respuesta != null && !respuesta.isEmpty()) {
                            pqyrResponder.setRespuesta(respuesta);
                            pqyrResponder.setSolucionado(true);
                            modelo.updateJson();
                            vista.mostrarMensaje("Solicitud respondida y marcada como solucionada");
                        } else {
                            vista.mostrarMensaje("La respuesta no puede estar vacía");
                        }
                    } else {
                        vista.mostrarMensaje("No se encontró una solicitud con esa referencia");
                    }
                    break;
                case 5:
                    vista.consultarPQyRNoSolucionadas(modelo.getPqyrMap());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Error... Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
