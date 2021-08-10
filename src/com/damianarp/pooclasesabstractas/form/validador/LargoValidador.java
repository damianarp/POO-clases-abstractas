package com.damianarp.pooclasesabstractas.form.validador;

public class LargoValidador extends Validador{
    protected String mensaje = "El campo debe tener mínimo %d caracteres y máximo %d caracteres";
    private int min; // Por defecto, es 0.
    private int max = Integer.MAX_VALUE; // Máximo valor que soporta un Integer.

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // Por la lógica del modelo, solo utilizaremos los setters para asignar el min y max de caracteres.
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para validar la cantidad de caracteres.
    @Override
    public boolean esValido(String valor) {
        this.mensaje = String.format(this.mensaje, this.min, this.max); // Formateamos el mensaje y le pasamos los valores min y max para que sea más personalizado.
        if (valor == null){
            return true; // Retornamos true ya que utilizaremos el NoNuloValidador para validar si el campo es null o no. De esta manera evitamos el NullPointerException en este método.
        }
        int largo = valor.length();
        return (largo >= min && largo <= max);
    }
}
