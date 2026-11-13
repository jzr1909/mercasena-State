package co.sena.mercasena.state;

public class Pendiente extends EstadoBase {

    @Override
    public String nombre() {
        return "PENDIENTE";
    }

    @Override
    public void pagar(Pedido pedido) {
        pedido.cambiarEstado(new Pagado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new Cancelado());
    }
}
