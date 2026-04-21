public class Processo {
    private int protocolo;
    private String solicitante;
    private String tipoDeServico;
    private int prioridade;
    private int dataHora;
    private static int contador = 1;

    // Construtor;
    public Processo(String solicitante, String tipoDeServico, int prioridade) {
        this.solicitante = solicitante;
        this.tipoDeServico = tipoDeServico;
        this.prioridade = prioridade;
        this.protocolo = contador;
        contador++;
    }

    // Getters e Setters

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipodeServico) {
        this.tipoDeServico = tipodeServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }
// Metodos


    @Override
    public String toString(){


        return "[#" +  String.format("%03d",this.protocolo) +"] " + this.solicitante + " | " + this.tipoDeServico +" | "+this.prioridade;
    }
}
