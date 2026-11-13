package co.sena.mercasena.state;

/** Por defecto, toda acción está prohibida. Cada estado habilita solo las suyas. */
public abstract class EstadoBase implements EstadoPedido {

    private void prohibido(String accion) {
        throw new IllegalStateException("No se puede " + accion + " un pedido en estado " + nombre());
    }

    @Override
    public void pagar(Pedido pedido) {
        prohibido("pagar");
    }

    @Override
    public void enviar(Pedido pedido) {
        prohibido("enviar");
    }

    @Override
    public void entregar(Pedido pedido) {
        prohibido("entregar");
    }

    @Override
    public void cancelar(Pedido pedido) {
        prohibido("cancelar");
    }
}
