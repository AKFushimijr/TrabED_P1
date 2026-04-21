import java.util.Scanner;

public class TesteProcesso {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PilhaProcessos pilha = new PilhaProcessos(4);
        PilhaProcessos undo = new PilhaProcessos(4);

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO ===");
            System.out.println("1 - Novo processo");
            System.out.println("2 - Atender processo (remover)");
            System.out.println("3 - Ver topo");
            System.out.println("4 - Desfazer última ação");
            System.out.println("5 - Listar processos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do solicitante: ");
                    String nome = sc.nextLine();

                    System.out.print("Tipo de serviço: ");
                    String tipo = sc.nextLine();

                    System.out.print("Prioridade (1-baixa, 2-media, 3-alta): ");
                    int prioridade = sc.nextInt();

                    Processo p = new Processo(nome, tipo, prioridade);
                    pilha.push(p);

                    System.out.println("Processo adicionado: " + p);
                    break;

                case 2:
                    if (pilha.isEmpty()) {
                        System.out.println("Não há processos para atendimento.");
                    } else {
                        Processo atendido = pilha.pop();
                        undo.push(atendido);

                        System.out.println("Processo atendido: " + atendido);
                    }
                    break;

                case 3:
                    if (pilha.isEmpty()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("Processo no topo: " + pilha.peek());
                    }
                    break;

                case 4:
                    if (undo.isEmpty()) {
                        System.out.println("Não há ações para desfazer.");
                    } else {
                        Processo restaurado = undo.pop();
                        pilha.push(restaurado);

                        System.out.println("Ação desfeita. Processo restaurado: " + restaurado);
                    }
                    break;

                case 5:
                    System.out.println("Lista de processos:");
                    pilha.listar();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}