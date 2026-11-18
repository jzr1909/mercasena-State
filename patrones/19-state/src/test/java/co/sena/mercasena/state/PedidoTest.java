package co.sena.mercasena.state;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void flujoCompleto() {
        Pedido p = new Pedido();
        p.pagar();
        p.enviar();
        assertEquals("ENVIADO", p.getEstado());
        p.entregar();
        assertEquals(List.of("PENDIENTE", "PAGADO", "ENVIADO", "ENTREGADO"), p.getHistorial());
    }

    @Test
    void cancelarPendienteNoGeneraReembolso() {
        Pedido p = new Pedido();
        p.cancelar();
        assertEquals("CANCELADO", p.getEstado());
        assertFalse(p.isReembolsoPendiente());
    }

    @Test
    void noSePuedeEnviarSinPagar() {
        assertThrows(IllegalStateException.class, () -> new Pedido().enviar());
    }

    @Test
    void entregadoEsFinal() {
        Pedido p = new Pedido();
        p.pagar();
        p.enviar();
        p.entregar();
        assertThrows(IllegalStateException.class, p::cancelar);
    }

    @Test
    void cancelarPagadoGeneraReembolsoPendiente() {
        Pedido p = new Pedido();
        p.pagar();
        p.cancelar();
        assertEquals("CANCELADO", p.getEstado());
        assertTrue(p.isReembolsoPendiente());
    }

    @Test
    void noSePuedeCancelarPedidoEnviado() {
        Pedido p = new Pedido();
        p.pagar();
        p.enviar();
        assertThrows(IllegalStateException.class, p::cancelar);
    }
}
