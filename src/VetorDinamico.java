public class VetorDinamico {

    private Processo[] elementos;
    private int tamanho;
    private int capacidadeInicial;

    public VetorDinamico() {
        this(4);
    }
    public int getTamanho() {
        return tamanho;
    }
    public VetorDinamico(int capacidadeInicial) {
        this.capacidadeInicial = capacidadeInicial;
        this.elementos = new Processo[capacidadeInicial];
        this.tamanho = 0;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = elementos.length * 2;
        Processo[] novo = new Processo[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }

        elementos = novo;
    }

    private void reduzirCapacidade() {
        int novaCapacidade = elementos.length / 2;

        if (novaCapacidade < capacidadeInicial) {
            novaCapacidade = capacidadeInicial;
        }

        Processo[] novo = new Processo[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }

        elementos = novo;
    }
    public void adicionar(Processo p) {
        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }

        elementos[tamanho++] = p;
    }
    public Processo remover() {
        if (tamanho == 0) {
            return null;
        }

        Processo removido = elementos[--tamanho];
        elementos[tamanho] = null;

        // reduzir se < 25%
        if (tamanho > 0 && tamanho <= elementos.length / 4) {
            reduzirCapacidade();
        }

        return removido;
    }

    public void listar() {
        if (tamanho == 0) {
            System.out.println("Nenhum processo.");
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + " - " + elementos[i]);
        }
    }

    public int buscarPorProtocolo(int protocolo) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].getProtocolo() == protocolo) {
                return i;
            }
        }
        return -1;
    }
}
