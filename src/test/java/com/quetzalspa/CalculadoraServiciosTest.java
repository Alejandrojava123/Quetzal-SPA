package com.quetzalspa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraServiciosTest {

    @Test
    void calcularTotalDebeMultiplicarPrecioPorCantidad() {
        CalculadoraServicios calculadora = new CalculadoraServicios();

        double resultado = calculadora.calcularTotal(500.00, 2);

        assertEquals(1000.00, resultado, 0.001);
    }

    @Test
    void calcularTotalDebeRechazarCantidadInvalida() {
        CalculadoraServicios calculadora = new CalculadoraServicios();

        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularTotal(500.00, 0)
        );
    }
}
