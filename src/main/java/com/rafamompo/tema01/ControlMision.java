package com.rafamompo.tema01;

import java.io.IOException;
import java.util.Map;

public class ControlMision {

    static void main(String[] args)
    {
        // Crea un ProcessBuilder para configurar la ejecución de un proceso externo.
        // Ejecuta Java, indica la ruta de las clases compiladas y especifica la clase Starship.
        // Le pasa el argumento "123456" al programa que se va a ejecutar.
        ProcessBuilder pb = new ProcessBuilder ("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Starship", "123456");

        // Hace que el proceso comparta la entrada, la salida y los errores
        // con el programa actual.
        pb.inheritIO();

        // Obtiene las variables de entorno que utilizará el proceso hijo.
        // El método environment() devuelve un mapa con los nombres y valores
        // de las variables de entorno configuradas para el proceso.
        Map <String, String> entorno = pb.environment();

        // Añade o modifica una variable de entorno llamada PLANETA.
        // Cuando se inicie el proceso hijo, podrá consultar esta variable
        // y obtener el valor "PLUTÓN".
        entorno.put("PLANETA", "PLUTÓN");

        try
        {
            // Inicia el proceso externo con la configuración y las variables de entorno anteriores.
            // Devuelve un objeto Process que permite interactuar con el proceso iniciado.
            Process proceso = pb.start();

            // Espera a que el proceso hijo termine y obtiene su código de salida.
            // waitFor() bloquea la ejecución hasta que el proceso finaliza.
            int codigo = proceso.waitFor();

            // Muestra por consola el código de salida devuelto por el proceso hijo.
            System.out.println ("Código devuelto: " + codigo);
        }
        catch (IOException ex)
        {
            // Registra el error si se produce un problema al iniciar el proceso
            // o al realizar una operación de entrada/salida.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        catch (InterruptedException ex)
        {
            // Registra el error si el hilo principal es interrumpido mientras
            // espera a que termine el proceso hijo.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}