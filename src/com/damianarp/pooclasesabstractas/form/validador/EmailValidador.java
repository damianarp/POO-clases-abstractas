package com.damianarp.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador{
    protected String mensaje = "El formato del correo no es válido";

    // Definimos una constante para la expresión regular simple.
    private final static String EMAIL_REGEX = "(.+)@(.+)$";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para validar el formato del email.
    // En este caso, usaremos una expresión regular simple. Lo ideal es usar una más compleja.
    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_REGEX);
    }
}
