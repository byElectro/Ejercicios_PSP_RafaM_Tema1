package com.rafamompo.tema01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Robot {
    static void main(String[] args) {
        try {
            // Crea un BufferedReader para leer texto de la entrada estándar del proceso.
            // System.in representa la entrada estándar, que normalmente es el teclado
            // o la entrada que reciba el proceso desde otro programa.
            // InputStreamReader convierte los bytes recibidos en caracteres usando UTF-8.
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

            // Lee una línea de texto de la entrada estándar y la guarda en linea.
            // readLine() devuelve null cuando se alcanza el final de la entrada.
            String linea = entrada.readLine();

            while (linea != null) {
                System.out.println(linea.toUpperCase() + "  --> " + linea.length());

                // Lee la siguiente línea de la entrada estándar.
                // Esto permite al programa seguir procesando el texto que va recibiendo.
                linea = entrada.readLine();
            }

            // Cierra el lector cuando ya no quedan líneas por leer.
            entrada.close();
        } catch (IOException ex) {
            // Muestra el mensaje del error si se produce un problema al leer o cerrar la entrada.
            System.out.println(ex.getMessage());
        }
    }

}