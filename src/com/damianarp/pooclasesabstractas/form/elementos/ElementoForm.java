package com.damianarp.pooclasesabstractas.form.elementos;

import java.util.List;

abstract public class ElementoForm {
    protected String valor;
    protected String nombre;

    public ElementoForm() {
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    // Según la lógica del modelo no es necesario implementar el método getValor(), solo el setter.
    public void setValor(String valor) {
        this.valor = valor;
    }

    abstract public String dibujarHtml();
}
