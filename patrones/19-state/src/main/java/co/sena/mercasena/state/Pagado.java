package co.sena.mercasena.state;

public class Pagado extends EstadoBase {

    @Override
    public String nombre() {
        return "PAGADO";
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.cambiarEstado(new Enviado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new Cancelado());
    }
}
