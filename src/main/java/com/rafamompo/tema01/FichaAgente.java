package com.rafamompo.tema01;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FichaAgente {
    static void main(String[] args) {


        //ProcessHandle es la clase que saca informacion de un proceso.
        ProcessHandle proceso = ProcessHandle.current();
        ProcessHandle.Info informacion = proceso.info();
        //Este es mi PID actual de mi programa
        System.out.println("PID: " + proceso.pid());
        //Confirmar que esta activo.
        System.out.println("Está activo: " + proceso.isAlive());
        //EL usuario que lo ejecuta
        String usuario = informacion.user()
                //Por si acaso el proceso no tiene un usuario asignado
                .orElse("No disponible");

        //Para saber en el momento que ha sido ejecutado el proceso.
        String inicio = informacion.startInstant()
                //Instant devuelve un mapa y para acceder al valor del mapa (clave) cuya
                //clave coincida con el nombre de nuestro proceso y como el nombre es un String
                //gasto el toString (el "::" para acceder al metodo String de la clase Object).
                .map(Object::toString)
                .orElse("No disponible");

        System.out.println("Usuario: " + usuario);
        System.out.println("Inicio: " + inicio);

        //Esto es para sacar el PID del proceso padre si es que tiene.
        proceso.parent().ifPresentOrElse(
                padre -> System.out.println(
                        "PID del padre: " + padre.pid()
                ),
                () -> System.out.println(
                        "Proceso padre no disponible"
                )
        );


    }
}