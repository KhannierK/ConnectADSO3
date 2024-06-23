package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class BD_Entregas {
    private HashMap<String, Entrega> entregas;

    public BD_Entregas() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("entregas.json");
            Type type = new TypeToken<HashMap<String, Entrega>>(){}.getType();
            entregas = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            entregas = new HashMap<>();
            // Si el archivo no se encuentra, inicializar entregas vacío.
        }
        updateJson();
    }

    public HashMap<String, Entrega> getEntregas() {
        return entregas;
    }

    public boolean validarEntregaInstancia(Entrega entrega) {
        return entregas.containsKey(entrega.getReferencia());
    }

    public Entrega validarEntregaString(String referencia) {
        return entregas.get(referencia);
    }

    public void agregarEntrega(Entrega entrega) {
        if (validarEntregaInstancia(entrega)) {
            System.out.println("La entrega con referencia " + entrega.getReferencia() + " ya existe");
        } else {
            entregas.put(entrega.getReferencia(), entrega);
            System.out.println("La entrega con referencia " + entrega.getReferencia() + " se ha agregado correctamente");
        }
        updateJson();
    }

    public void eliminarEntrega(String referencia) {
        if (entregas.remove(referencia) != null) {
            System.out.println("La entrega con referencia " + referencia + " se ha eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado un paquete con referencia " + referencia);
        }
        updateJson();
    }

    public void updateJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("entregas.json");
            gson.toJson(this.entregas, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
