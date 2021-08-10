package com.damianarp.pooclasesabstractas.form.validador;

public class RequeridoValidador extends Validador{
    protected String mensaje = "Este campo %s es obligatorio";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para validar que el campo sea requerido.
    @Override
    public boolean esValido(String valor) {
        return (valor != null && valor.length() > 0);
    }
}
