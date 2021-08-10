package com.damianarp.pooclasesabstractas.form.validador;

public class NoNuloValidador extends Validador{
    protected String mensaje = "El campo %s no puede ser nulo";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para validar que el campo no sea nulo.
    @Override
    public boolean esValido(String valor) {
        return (valor != null);
    }
}
