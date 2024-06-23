package Vista;

import Modelo.PQyR;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Vista_PQyR {

    public Vista_PQyR() {}

    public static int menu() {
        String[] opciones = {"Consultar PQyR", "Agregar PQyR", "Eliminar PQyR", "Responder PQyR", "Consultar PQyR no solucionadas", "Salir"};
        int i = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);
        return i + 1;
    }

    public static PQyR detallesPQyR() {
        String casa = null;
        String solicitud = null;

        while (true) {
            casa = JOptionPane.showInputDialog(null, "Introduce la casa:", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (casa == null || casa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... La casa no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            solicitud = JOptionPane.showInputDialog(null, "Introduce la solicitud:", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (solicitud == null || solicitud.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... La solicitud no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            break; // Salir del bucle si todo es válido
        }

        return new PQyR(casa, solicitud);
    }

    public String getString(String parametro) {
        String str;
        while (true) {
            str = JOptionPane.showInputDialog(null, "Introduce el " + parametro + ":", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (str == null || str.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... No puede haber ningún campo vacío", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
        }
        return str;
    }

    public void consultarPQyR(HashMap<String, PQyR> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes disponibles", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder resultado = new StringBuilder();
            for (Map.Entry<String, PQyR> entry : lista.entrySet()) {
                PQyR pqyr = entry.getValue();
                resultado.append(pqyr).append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString(), "Solicitudes Encontradas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void consultarPQyRNoSolucionadas(HashMap<String, PQyR> lista) {
        StringBuilder resultado = new StringBuilder();
        for (PQyR pqyr : lista.values()) {
            if (!pqyr.isSolucionado()) {
                resultado.append(pqyr).append("\n");
            }
        }
        if (resultado.length() == 0) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes no solucionadas", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, resultado.toString(), "Solicitudes No Solucionadas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getRespuesta() {
        return JOptionPane.showInputDialog(null, "Introduce la respuesta a la solicitud:", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
    }
}
