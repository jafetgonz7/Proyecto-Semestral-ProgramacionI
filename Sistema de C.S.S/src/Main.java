import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.*;

public class Main {

    static class CampoVacioException extends Exception {
        public CampoVacioException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ans = "si";
        try {
            do {
                try {

                    System.out.println("Locura del seguro social!!!");
                    /*que quieren realizar
                     * disponibilidad de medicamentos:
                     *   cuantos medicamentos hay de fecha a fecha
                     *   cuantos se han reservado
                     *   cuantos medicamentos se pondran en el programa
                     * donde se encuentran disponibles
                     *   cuantos seguros? en provincia central o a nivel nacional
                     *   incluimos division de espacio del seguro? incluyendo o no centros pequeños
                     * reservas en linea
                     *   cuantos llegan mensualmente
                     *   cuanto demora la siguiente llegada
                     *   costo o no adicional en linea?
                     *   metodo de pago? reembolsos en caso de contratiempo?
                     *   se recogeria personalmente o servicio de entrega?
                     * sistema de notificacion
                     *   se haria atravez de una aplicacion?
                     *   correo?
                     *   cuantos datos se realizarian en esta?
                     * sistema pre-orden
                     *   desde que punto estaria disponible?
                     *   como se categorizaria orden de prioridad?
                     *   serian medicinas generales?
                     *   se agregaria un sistema de envios de recetas medicas?
                     *   cuanto seria el periodo de verificacion?
                     *   se haria un acuerdo para que el doctor preacepte ciertos medicamentos?*/
                    //trabajo con tiempo
                    String nombre_usuario = validarNoVacio(reader, "ingrese su usuario: ");

                    //valor de fecha
                    Date fecha = new Date();

                    //definicion del tiempo a tiempo real
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(fecha);

                    System.out.println("Su fecha es: " + fecha);
                    int meses_entrega=4;

                    //agregacion de tiempo a la fecha esatblecida
                    calendar.add(Calendar.MONTH, meses_entrega);
                    Date dateyui = calendar.getTime();
                    System.out.println("Esta medicina estara disponible en: " + dateyui);

                    //en caso de que, sean fechas de distinto proposito se vuelve a definir la fecha
                    calendar.setTime(fecha);
                    calendar.add(Calendar.DAY_OF_WEEK, meses_entrega);

                    //fecha modificada
                    Date dateMod = calendar.getTime();

                    System.out.println("Esta medicina estara disponible en: " + dateMod);

                    /* Cosas que necesita el seguro:
                     *       tiempo  CHECK
                     *       registro u objeto
                     *       unirlo con correo
                     *       mapeo
                     * */


                    ans = validarNoVacio(reader, "¿Desea volver a repetir? (si/no): ");


                } catch (CampoVacioException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Entrada no válida. Se esperaba un número.");
                    ans = "si"; // Forzar a que pregunte de nuevo
                }

            } while (ans.equalsIgnoreCase("si"));

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el reader: " + e.getMessage());
            }
        }
    }
    // Métodos compactos de validación
    private static String validarNoVacio(BufferedReader br, String mensaje) throws CampoVacioException, IOException {
        System.out.print(mensaje);
        String input = br.readLine().trim();
        if (input.isEmpty()) throw new CampoVacioException(mensaje + "no puede estar vacío");
        return input;
    }
}