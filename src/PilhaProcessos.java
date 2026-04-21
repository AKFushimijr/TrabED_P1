public class PilhaProcessos {

    private Processo[] elementos;
    private int topo;

    public PilhaProcessos(int i) {
        elementos = new Processo[10];
        topo = -1;
    }

    public void push(Processo p) {
        elementos[++topo] = p;
    }

    public Processo pop() {
        if (topo == -1) return null;
        return elementos[topo--];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void listar() {
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }

    public Processo peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos[topo];
    }
}