package com.rafamompo.tema01;

import java.util.Map;

public class Starship {

    static void main(String[] args)
    {
        // Obtiene todas las variables de entorno disponibles para este proceso.
        // System.getenv() devuelve un Map con los nombres y valores de esas variables.
        // En este caso, permite consultar la variable PLANETA que puede haber recibido
        // del proceso que inició este programa.
        Map<String, String> variables = System.getenv();

        // Comprueba si entre los nombres de las variables de entorno existe PLANETA.
        if (variables.keySet().contains("PLANETA"))
        {
            // Muestra el valor de la variable de entorno PLANETA y el primer argumento recibido.
            // variables.get("PLANETA") obtiene el valor asociado a esa variable.
            // args[0] contiene el primer argumento pasado al iniciar este proceso.
            System.out.println ("PLANETA: " + variables.get("PLANETA") + "  Argumento: " + args [0]);
        }
        else
        {
            // Si la variable PLANETA no existe, muestra el texto "Predeterminado"
            // junto con el primer argumento recibido por el proceso.
            System.out.println ("PLANETA: Predeterminado" + "  Argumento: " + args [0]);
        }
    }

}