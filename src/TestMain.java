import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
public class TestMain {

    @Test
    public void testContarManerasDecodificar() {
        String mensaje = "111";
        int resultadoEsperado = 3; // El número de maneras de decodificar "111" es 3.
        assertEquals(resultadoEsperado, Main.contarManerasDecodificar(mensaje, 0, new HashMap<>()));
    }

    @Test
    public void testContarManerasDecodificarConMensajeVacio() {
        String mensaje = "";
        int resultadoEsperado = 1; // El número de maneras de decodificar una cadena vacía es 1.
        assertEquals(resultadoEsperado, Main.contarManerasDecodificar(mensaje, 0, new HashMap<>()));
    }

    @Test
    public void testContarManerasDecodificarConMensajeNoDecodificable() {
        String mensaje = "001"; // "001" no se puede decodificar porque no hay ninguna correspondencia para "27".
        int resultadoEsperado = 0;
        assertEquals(resultadoEsperado, Main.contarManerasDecodificar(mensaje, 0, new HashMap<>()));
    }
}