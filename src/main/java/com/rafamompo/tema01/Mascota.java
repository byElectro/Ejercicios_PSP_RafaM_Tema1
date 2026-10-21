// Indica el paquete al que pertenece la clase Mascota.
package com.rafamompo.tema01;

// Declara la clase pública llamada Mascota.
public class Mascota {

    static void main(String[] args) {


        String nombre = args[0];

// Convierte el segundo argumento recibido (posición 1) de texto a entero.
        int pasosAvanzar = Integer.parseInt(args[1]);

// Obtiene el identificador del proceso actual (PID) y lo guarda como long.
        long pid = ProcessHandle.current().pid();


        for (int i = 1; i <= pasosAvanzar; i++) {

// Muestra por consola el PID, el nombre recibido y el número de paso actual.
            System.out.println("PID: " + pid + "  Nombre: " + nombre + "  Paso: " + i);
        }
    }
}