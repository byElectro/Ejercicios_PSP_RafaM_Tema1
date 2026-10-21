package com.rafamompo.tema01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


public class Traductor {
    static void main() {
        // Configura un proceso externo que ejecutará la clase Robot.
        // Indica la ruta de las clases compiladas y pasa los argumentos "Pepe" y "123456".
        ProcessBuilder pb = new ProcessBuilder("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Robot", "Pepe", "123456");

        try {
            // Inicia el proceso hijo y devuelve un objeto Process para poder comunicarse con él.
            Process proceso = pb.start();

            // Envío al proceso hijo de 3 mensajes.

            // Obtiene la entrada del proceso hijo para poder enviarle texto.
            // getOutputStream() permite al proceso padre escribir datos que recibirá el hijo.
            // OutputStreamWriter convierte los caracteres en bytes usando UTF-8.
            // BufferedWriter facilita la escritura de texto.
            BufferedWriter entradaHijo = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream(), StandardCharsets.UTF_8));

            // Envía el texto "Traduce" a la entrada estándar del proceso hijo.
            entradaHijo.write("Traduce");

            // Envía un salto de línea para que el proceso hijo pueda leer esta línea completa.
            entradaHijo.newLine();

            // Envía el segundo mensaje al proceso hijo.
            entradaHijo.write("estas frases");

            // Añade un salto de línea para separar el segundo mensaje del siguiente.
            entradaHijo.newLine();

            // Envía el tercer mensaje al proceso hijo.
            entradaHijo.write("en mayusculas.");

            // Añade un salto de línea al final del tercer mensaje.
            entradaHijo.newLine();

            // Fuerza el envío de los datos almacenados temporalmente en el búfer.
            entradaHijo.flush();

            // Cierra la entrada del proceso hijo para indicar que ya no se enviará más texto.
            // Esto permite que el hijo detecte el final de la entrada cuando termine de leer.
            entradaHijo.close();


            // Lectura de las respuestas.

            // Obtiene la salida estándar del proceso hijo para leer lo que este escriba.
            // getInputStream() permite al proceso padre recibir la salida del hijo.
            // InputStreamReader convierte los bytes recibidos en caracteres usando UTF-8.
            // BufferedReader facilita la lectura del texto línea por línea.
            BufferedReader salidaHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8));

            // Lee la primera línea de la salida del proceso hijo.
            // Si el hijo no tiene más texto que enviar, readLine() devuelve null.
            String linea = salidaHijo.readLine();

            while (linea != null) {
                System.out.println(linea);

                // Lee la siguiente línea que ha escrito el proceso hijo.
                linea = salidaHijo.readLine();
            }

            // Cierra el lector de la salida del proceso hijo cuando termina la lectura.
            salidaHijo.close();


            // Espera a que el proceso hijo termine y obtiene su código de salida.
            // waitFor() bloquea el proceso padre hasta que el hijo finaliza.
            int codigo = proceso.waitFor();

            // Muestra el código de salida devuelto por el proceso hijo.
            System.out.println("Código devuelto: " + codigo);
        } catch (IOException ex) {
            // Registra el error si ocurre un problema al iniciar el proceso
            // o al enviar o recibir datos mediante sus flujos de entrada y salida.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            // Registra el error si el proceso padre es interrumpido mientras espera
            // a que termine el proceso hijo.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}