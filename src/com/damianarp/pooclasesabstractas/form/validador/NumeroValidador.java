package com.damianarp.pooclasesabstractas.form.validador;

public class NumeroValidador extends Validador{
    protected String mensaje = "El campo debe ser numérico";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para validar que el campo sea numérico.
    @Override
    public boolean esValido(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
