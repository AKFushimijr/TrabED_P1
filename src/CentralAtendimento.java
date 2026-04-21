public class CentralAtendimento {

    private PilhaProcessos principal; // atendimentos pendentes
    private PilhaProcessos historico; // processos atendidos (para desfazer)

    public CentralAtendimento() {
        principal = new PilhaProcessos(2);
        historico = new PilhaProcessos(2);
    }

    public void abrirProcessos(Processo p) {
        principal.push(p);

        // limpa histórico (nova ação invalida desfazer)
        while (!historico.isEmpty()) {
            historico.pop();
        }
    }

    public Processo atenderProximo() {
        if (principal.isEmpty()) {
            System.out.println("Nenhum processo pendente.");
            return null;
        }

        Processo atendido = principal.pop();
        historico.push(atendido);

        return atendido;
    }

    public void desfazerUltimoAtendimento() {
        if (historico.isEmpty()) {
            System.out.println("Nenhum atendimento para desfazer.");
            return;
        }

        Processo p = historico.pop();
        principal.push(p);
    }

    public void listarPendentes() {
        if (principal.isEmpty()) {
            System.out.println("Nenhum processo pendente.");
        } else {
            principal.listar();
        }
    }

    public void listarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhum processo atendido.");
        } else {
            historico.listar();
        }
    }
}