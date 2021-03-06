package com.damianarp.pooclasesabstractas.form.elementos;

import com.damianarp.pooclasesabstractas.form.validador.Validador;
import com.damianarp.pooclasesabstractas.form.validador.mensaje.IMensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {
    protected String valor;
    protected String nombre;

    // Creamos un atributo para la lista de validadores.
    private List<Validador> validadores;

    // Creamos un atributo para la lista de mensajes de error.
    private List<String> errores;

    // Inicializamos la lista de validadores y la lista de errores en el constructor vacío.
    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    // Según la lógica del modelo no es necesario implementar el método getValor(), solo el setter.
    public void setValor(String valor) {
        this.valor = valor;
    }

    // Implementamos el getter de errores para que podamos leer el mensaje de error de la validación desde afuera.
    public List<String> getErrores() {
        return errores;
    }

    // Método para agregar validadores desde afuera de la clase.
    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    // Método para validar el campo con los diferentes validadores.
    public boolean esValido() {
        // Iteramos la lista de validadores
        for (Validador v : this.validadores) {
            // Si no es válido, se muestra el mensaje de error de cada validador.
            if (!v.esValido(this.valor )){
                // Si el validador es instancia de la interface IMensajeFormateable mostramos invocamos el método de la interface y mostramos el mensaje formateado, si no mostramos los otros mensajes.
                if (v instanceof IMensajeFormateable){
                    this.errores.add(((IMensajeFormateable) v).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }
        }
        return this.errores.isEmpty(); // Si la lista de errores está vacía, quiere decir que esValido es true, por lo que retornamos true.
    }

    abstract public String dibujarHtml(); // Los métodos abstractos van al final.
}
