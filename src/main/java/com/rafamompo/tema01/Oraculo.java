package com.rafamompo.tema01;

// Importa la clase ArrayList para poder trabajar con listas dinámicas.
// En este código no se utiliza directamente.

public class Oraculo {

    // Declara un array de cadenas de texto con las posibles respuestas del oráculo.
    static String[] respuestas = {"No lo sé", "Que te pires", "No me des la tabarra", "Correcto"};

    // Método principal del programa, que recibe los argumentos pasados al ejecutarlo.
    static void main(String[] args) {

        // Obtiene la longitud del segundo argumento recibido.
        // Calcula el resto de dividir esa longitud entre el número de respuestas disponibles.
        // El resultado se utiliza como índice para elegir una respuesta del array.
        int indiceRespuestas = args[1].length() % respuestas.length;

        // Muestra por consola el primer argumento recibido, seguido de la respuesta elegida.
        // args[0] contiene el nombre y respuestas[indiceRespuestas] contiene la respuesta.
        System.out.println(args[0] + " responde: " + respuestas[indiceRespuestas]);

    }
}