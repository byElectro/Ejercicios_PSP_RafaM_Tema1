package com.rafamompo.tema01;

import java.io.IOException;

public class Hipodromo {


    static void main() {
        String[] mascotas = {"Pipo", "Rocky", "Pusky"};
        try {
            // Creación de los 3 procesos.

            // Crea un ProcessBuilder para configurar el primer proceso.
            // Ejecuta Java, indica la ruta donde buscar las clases,
            // especifica la clase Mascota y le pasa los argumentos "Pipo" y "5".
            ProcessBuilder pb0 = new ProcessBuilder("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Mascota", mascotas[0], "5");

            // Hace que la entrada, la salida y los errores del proceso
            // utilicen los mismos canales de entrada y salida que el programa actual.
            pb0.inheritIO();

            // Crea un ProcessBuilder para configurar el segundo proceso.
            // Ejecuta la clase Mascota y le pasa los argumentos "Rocky" y "2".
            ProcessBuilder pb1 = new ProcessBuilder("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Mascota", mascotas[1], "2");

            // Hace que el segundo proceso comparta la entrada, la salida
            // y los errores con el programa actual.
            pb1.inheritIO();

            // Crea un ProcessBuilder para configurar el tercer proceso.
            // Ejecuta la clase Mascota y le pasa los argumentos "Pusky" y "5".
            ProcessBuilder pb2 = new ProcessBuilder("java", "-classpath", "C:\\Users\\rafat\\IdeaProjects\\FichaAgente\\build\\classes\\java\\main", "com/rafamompo/tema01/Mascota", mascotas[2], "5");

            // Hace que el tercer proceso comparta la entrada, la salida
            // y los errores con el programa actual.
            pb2.inheritIO();

            // Inicia el primer proceso configurado en pb0.
            // Devuelve un objeto Process que permite interactuar con el proceso iniciado.
            Process p0 = pb0.start();

            // Inicia el segundo proceso configurado en pb1.
            // Guarda su referencia en p1 para poder consultar su ejecución.
            Process p1 = pb1.start();

            // Inicia el tercer proceso configurado en pb2.
            // Guarda su referencia en p2 para poder interactuar con él.
            Process p2 = pb2.start();


            // Espera a que termine el tercer proceso y obtiene su código de salida.
            // El método waitFor() bloquea el programa hasta que ese proceso finaliza.
            System.out.println("Código devuelto por " + mascotas[2] + ": " + p2.waitFor());

            // Espera a que termine el segundo proceso y obtiene su código de salida.
            System.out.println("Código devuelto por " + mascotas[1] + ": " + p1.waitFor());

            // Espera a que termine el primer proceso y obtiene su código de salida.
            System.out.println("Código devuelto por " + mascotas[0] + ": " + p0.waitFor());

        } catch (IOException ex) {
            // Registra el error si ocurre un problema al iniciar alguno de los procesos
            // o al realizar una operación de entrada/salida.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

        } catch (InterruptedException ex) {
            // Registra el error si el hilo principal es interrumpido mientras espera
            // a que termine alguno de los procesos.
            System.getLogger(InvocarOraculo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }


}