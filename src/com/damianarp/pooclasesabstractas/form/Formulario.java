package com.damianarp.pooclasesabstractas.form;

import com.damianarp.pooclasesabstractas.form.elementos.*;
import com.damianarp.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formulario {
    public static void main(String[] args) {
        // Creamos instancias de InputForm.
        InputForm username = new InputForm("username"); // el tipo por defecto es "text", por lo que no es necesario colocarlo porque ya lo definimos previamente.
        InputForm password = new InputForm("clave","password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        // Creamos una instancia de TextareaForm.
        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        // Creamos una instancia de SelectForm
        SelectForm lenguaje = new SelectForm("lenguaje");
        // Agregamos las opciones
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        // Agregamos valores
        username.setValor("john.doe");
        password.setValor("12345");
        email.setValor("john.doe@correo.com");
        edad.setValor("33");
        experiencia.setValor("... más de 10 años de experiencia ...");

        // Seleccionamos Java del SelectForm
        java.setSelected(true);

        // Creamos un List para agregar todos los objetos creados
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje);

        // Iteramos a través de la Api Stream con una expresión lambda.
        elementos.forEach( e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        // O también podemos iterar la lista con un for
        /*for (ElementoForm e : elementos) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

    }
}
