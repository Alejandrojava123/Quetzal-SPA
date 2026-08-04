package com.quetzalspa;

/**
 * Clase auxiliar para calcular el importe total de un servicio.
 */
public class CalculadoraServicios {

    public double calcularTotal(double precioServicio, int cantidad) {
        if (precioServicio < 0) {
            throw new IllegalArgumentException(
                    "El precio del servicio no puede ser negativo."
            );
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero."
            );
        }

        return precioServicio * cantidad;
    }
}
