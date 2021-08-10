package com.damianarp.pooclasesabstractas.form;

import com.damianarp.pooclasesabstractas.form.elementos.*;
import com.damianarp.pooclasesabstractas.form.elementos.select.Opcion;

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
        // Agregamos las opciones.
        lenguaje.addOpcion(new Opcion("1", "Java"))
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected()) // Seleccionamos TypeScript del SelectForm.
                .addOpcion(new Opcion("5", "PHP"));

        // Creamos un objeto saludar del tipo ElementoForm con una la clase anónima para crear un input disabled.
        // <input disabled name="this.nombre" value="this.valor">
        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name=\"" + this.nombre
                        + "\" value=\"" + this.valor
                        + "\"";
            }
        };

        // Agregamos valores.
        username.setValor("john.doe");
        password.setValor("12345");
        email.setValor("john.doe@correo.com");
        edad.setValor("33");
        experiencia.setValor("... más de 10 años de experiencia ...");
        saludar.setValor("Hola! Que tal? Este campo está deshabilitado!");

        // Creamos un List para agregar todos los objetos creados.
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        // Iteramos a través de la Api Stream con una expresión lambda.
        elementos.forEach( e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });
    }
}
