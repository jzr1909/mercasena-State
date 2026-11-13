package co.sena.mercasena.state;

import java.util.ArrayList;
import java.util.List;

/** Contexto: delega en su estado actual. */
public class Pedido {

    private EstadoPedido estado = new Pendiente();
    private boolean reembolsoPendiente;
    private final List<String> historial = new ArrayList<>(List.of("PENDIENTE"));

    public void pagar() {
        estado.pagar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    void cambiarEstado(EstadoPedido nuevo) {
        this.estado = nuevo;
        historial.add(nuevo.nombre());
    }

    void marcarReembolsoPendiente() {
        this.reembolsoPendiente = true;
    }

    public String getEstado() {
        return estado.nombre();
    }

    public boolean isReembolsoPendiente() {
        return reembolsoPendiente;
    }

    public List<String> getHistorial() {
        return List.copyOf(historial);
    }
}
