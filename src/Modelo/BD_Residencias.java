package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class BD_Residencias {
    private HashMap<String, Residencia> residencias;

    public BD_Residencias() {

        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("residencias.json");
            Type type = new TypeToken<HashMap<String, Residencia>>(){}.getType();
            residencias = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            residencias = new HashMap<>();
        }
        updateJson();
    }

    public HashMap<String, Residencia> getResidencias() {
        return residencias;
    }


    public void agregarCasa(String casa, Residencia residencia) {
        if (residencias.containsKey(casa)) {
            JOptionPane.showMessageDialog(null, "Error... La casa "+casa+ " ya se encuentra registrada!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            residencias.put(casa, residencia);
            JOptionPane.showMessageDialog(null, "La casa " + casa + " se ha registrado exitosamente!", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
        updateJson();
    }

    public void eliminarCasa(String casa) {
        if (residencias.remove(casa) != null) {
            JOptionPane.showMessageDialog(null, "La casa " + casa + " ha sido eliminada con exito", "Eliminada exitosamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La casa " + casa + " no se encontro", "Error", JOptionPane.ERROR_MESSAGE);
        }
        updateJson();
    }



    public void updateJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("residencias.json");
            gson.toJson(this.residencias, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
