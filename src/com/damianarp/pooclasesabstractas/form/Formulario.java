package com.damianarp.pooclasesabstractas.form;

import com.damianarp.pooclasesabstractas.form.elementos.*;
import com.damianarp.pooclasesabstractas.form.elementos.select.Opcion;
import com.damianarp.pooclasesabstractas.form.validador.*;

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

        // Creamos un objeto saludar del tipo ElementoForm con una la clase anónima para crear un input disabled.
        // <input disabled name="this.nombre" value="this.valor">
        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name=\"" + this.nombre
                        + "\" value=\"" + this.valor
                        + "\">";
            }
        };

        // Agregamos valores a los objetos y luego sus validadores.
        username.setValor("john.doe");
        username.addValidador(new RequeridoValidador());

        password.setValor("123456");
        password.addValidador(new RequeridoValidador())
                        .addValidador(new LargoValidador(6, 12));

        email.setValor("john.doe@correo.com");
        email.addValidador(new RequeridoValidador())
                        .addValidador(new EmailValidador());

        edad.setValor("33");
        edad.addValidador(new NumeroValidador());

        experiencia.setValor("... más de 10 años de experiencia ...");
        experiencia.addValidador(new RequeridoValidador());

        lenguaje.addOpcion(new Opcion("1", "Java"))
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected()) // Seleccionamos TypeScript del SelectForm.
                .addOpcion(new Opcion("5", "PHP"));
        lenguaje.addValidador(new NoNuloValidador());

        saludar.setValor("Hola! Que tal? Este campo está deshabilitado!");

        // Creamos un List para agregar todos los objetos creados.
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        // Iteramos la lista de elementos a través de la Api Stream con una expresión lambda.
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        // Luego de dibujar el html, iteramos la lista de elementos y validamos los campos.
        elementos.forEach(e -> {
            // Si el elemento no es válido, recorremos con un foreach encadenado la lista de errores y lo imprimimos.
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println); // Atajo (método referenciado de expresión lambda). Se usa cuando el mismo argumento del foreach se utiliza en un método, equivale a err -> System.out.println(err)
            }
        });
    }
}
