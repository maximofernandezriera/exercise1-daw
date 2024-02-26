import java.util.HashMap;
import java.util.Map;

public class Main {

    // Definimos un mapa estático que mapea cadenas a cadenas, aunque esto no es estrictamente necesario.
    private static final Map<String, String> CORRESPONDENCIA = new HashMap<>();

    // Inicializamos el mapa con las correspondencias requeridas.
    static {
        // Cada número del 1 al 26 se mapea a una letra específica.
        CORRESPONDENCIA.put("1", "z");
        CORRESPONDENCIA.put("2", "y");
        CORRESPONDENCIA.put("3", "x");
        CORRESPONDENCIA.put("4", "w");
        CORRESPONDENCIA.put("5", "v");
        CORRESPONDENCIA.put("6", "u");
        CORRESPONDENCIA.put("7", "t");
        CORRESPONDENCIA.put("8", "s");
        CORRESPONDENCIA.put("9", "r");
        CORRESPONDENCIA.put("10", "q");
        CORRESPONDENCIA.put("11", "p");
        CORRESPONDENCIA.put("12", "o");
        CORRESPONDENCIA.put("13", "n");
        CORRESPONDENCIA.put("14", "m");
        CORRESPONDENCIA.put("15", "l");
        CORRESPONDENCIA.put("16", "k");
        CORRESPONDENCIA.put("17", "j");
        CORRESPONDENCIA.put("18", "i");
        CORRESPONDENCIA.put("19", "h");
        CORRESPONDENCIA.put("20", "g");
        CORRESPONDENCIA.put("21", "f");
        CORRESPONDENCIA.put("22", "e");
        CORRESPONDENCIA.put("23", "d");
        CORRESPONDENCIA.put("24", "c");
        CORRESPONDENCIA.put("25", "b");
        CORRESPONDENCIA.put("26", "a");
    }

    //Una manera más elegante

    /*    static {
        for (int i = 1; i <= 26; i++) {
            CORRESPONDENCIA.put(String.valueOf(i), "");
        }
    }*/

    // Método que realiza el conteo de las maneras de decodificar.
    public static int contarManerasDecodificar(String mensaje, int indiceActual, Map<String, Integer> registroDecodificaciones) {
        // Si hemos llegado al final del mensaje, hay una sola manera de decodificar, no hacer nada.
        if (indiceActual == mensaje.length()) {
            return 1;
        }

        // Creamos un submensaje a partir del índice actual.
        String submensaje = mensaje.substring(indiceActual);
        // Si ya hemos calculado el número de maneras de decodificar este submensaje, lo retornamos.
        if (registroDecodificaciones.containsKey(submensaje)) {
            return registroDecodificaciones.get(submensaje);
        }

        // Inicializamos el contador de maneras de decodificar.
        int numeroManeras = 0;
        // Iteramos sobre los posibles tamaños de subcadenas.
        // El bucle considerará subcadenas de tamaño 1 y 2, siempre y cuando no se exceda la longitud del mensaje.
        for (int i = 1; i <= Math.min(2, mensaje.length() - indiceActual); i++) {
        // También podría ser una while (i <= ((2 < mensaje.length() - indiceActual) ? 2 : mensaje.length() - indiceActual)) {
            // Obtenemos la subcadena actual.
            String subcadena = mensaje.substring(indiceActual, indiceActual + i);
            if (CORRESPONDENCIA.containsKey(subcadena)) {// Si la subcadena está en el mapa de correspondencias
                if (CORRESPONDENCIA.containsKey(subcadena)) {
                    // Incrementamos el número de maneras de decodificar.
                    numeroManeras += contarManerasDecodificar(mensaje, indiceActual + i, registroDecodificaciones);
                }
            } else {
                // Si la subcadena no está en el mapa de correspondencias, el mensaje no es decodificable. Retornamos 0.
                return 0;
            }
        }

        // Guardamos en el registro el número de maneras de decodificar el submensaje.
        registroDecodificaciones.put(submensaje, numeroManeras);
        // Retornamos el número de maneras de decodificar.
        return numeroManeras;
    }
}