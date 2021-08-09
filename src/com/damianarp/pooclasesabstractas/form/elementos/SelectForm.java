package com.damianarp.pooclasesabstractas.form.elementos;

import com.damianarp.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{
    private List<Opcion> opciones;

    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>(); // Debemos inicializar el List opciones como un ArrayList vacío, lo hacemos en el primer constructor,
        // en el segundo constructor no hace falta porque ya se pasó como parámetro.
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    // Por la lógica del modelo, no hace falta declarar los getters and setters.

    // Método para agregar opciones a la lista (de forma encadenada)
    public SelectForm addOpcion(Opcion opcion){
        this.opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHtml() {
        // <select name="this.nombre">
            // <option value="opcion.getValor" selected> opcion.getNombre </option>
        // </select>
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name=\"")
                .append(this.nombre)
                .append("\">");

        // Iteramos para obtener la lista de opciones
        for (Opcion opcion : this.opciones) {
            sb.append("\n<option value=\"")
                    .append(opcion.getValor())
                    .append("\"");
            if(opcion.isSelected()){
                sb.append(" selected"); // Si se selecciona un elemento se agrega este atributo al html.
                this.valor = opcion.getValor(); 
            }
            sb.append(">").append(opcion.getNombre())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
}
