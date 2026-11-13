package co.sena.mercasena.state;

/** Interfaz de estado. */
public interface EstadoPedido {

    String nombre();

    void pagar(Pedido pedido);

    void enviar(Pedido pedido);

    void entregar(Pedido pedido);

    void cancelar(Pedido pedido);
}
