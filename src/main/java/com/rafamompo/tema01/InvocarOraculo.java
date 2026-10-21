package com.rafamompo.tema01;

import java.io.IOException;

public class InvocarOraculo {

    static void main(String[] args) {
        // Crea un ProcessBuilder para configurar la ejecución de un proceso externo.
        // Ejecuta Java, indica dónde están las clases compiladas y especifica la clase Oraculo.
        // Le pasa dos argumentos al programa: "Pepe" y "123456".
        ProcessBuilder pb = new ProcessBuilder("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Oraculo", "Pepe", "123456");

        // Hace que el proceso utilice la misma entrada, salida y salida de errores
        // que el programa actual. Así, su interacción por consola se comparte.
        pb.inheritIO();

        try {
            // Inicia el proceso externo configurado en el ProcessBuilder.
            // Devuelve un objeto Process que permite interactuar con el proceso iniciado.
            Process proceso = pb.start();

            // Espera a que el proceso termine y recoge su código de salida.
            // El método waitFor() bloquea la ejecución hasta que el proceso finaliza.
            int codigo = proceso.waitFor();

            // Muestra por consola el código de salida devuelto por el proceso.
            System.out.println("Código devuelto: " + codigo);
        } catch (IOException ex) {
            // Registra el error si se produce un problema al iniciar el proceso
            // o al realizar una operación de entrada/salida.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            // Registra el error si el hilo principal es interrumpido mientras
            // espera a que termine el proceso.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}