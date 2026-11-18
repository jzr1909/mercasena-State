package co.sena.mercasena.state;

public class Enviado extends EstadoBase {

    @Override
    public String nombre() {
        return "ENVIADO";
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.cambiarEstado(new Entregado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("No se puede cancelar un pedido que ya se encuentra en estado ENVIADO.");
    }
}
