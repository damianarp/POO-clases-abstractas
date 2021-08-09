package com.damianarp.pooclasesabstractas.form;

import com.damianarp.pooclasesabstractas.form.elementos.*;
import com.damianarp.pooclasesabstractas.form.elementos.select.Opcion;

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
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2", "Python"));
        lenguaje.addOpcion(new Opcion("3", "JavaScript"));
        lenguaje.addOpcion(new Opcion("4", "TypeScript"));
        lenguaje.addOpcion(new Opcion("5", "PHP"));

        // Agregamos valores
        username.setValor("john.doe");
        password.setValor("12345");
        email.setValor("john.doe@correo.com");
        edad.setValor("33");

        // Seleccionamos Java del SelectForm
        java.setSelected(true);
    }
}
