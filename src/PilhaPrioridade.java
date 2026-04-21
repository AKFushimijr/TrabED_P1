public class PilhaPrioridade {

        private PilhaProcessos urgente;
        private PilhaProcessos normal;
        private PilhaProcessos baixa;

        public PilhaPrioridade() {
            urgente = new PilhaProcessos(10);
            normal = new PilhaProcessos(10);
            baixa = new PilhaProcessos(10);
        }

        public void push(Processo p) {
            if (p.getPrioridade() == 3) {
                urgente.push(p);
            } else if (p.getPrioridade() == 2) {
                normal.push(p);
            } else {
                baixa.push(p);
            }
        }

        public Processo pop() {
            if (!urgente.isEmpty()) {
                return urgente.pop();
            }
            if (!normal.isEmpty()) {
                return normal.pop();
            }
            if (!baixa.isEmpty()) {
                return baixa.pop();
            }
            return null;
        }

        public Processo peek() {
            if (!urgente.isEmpty()) {
                return urgente.peek();
            }
            if (!normal.isEmpty()) {
                return normal.peek();
            }
            if (!baixa.isEmpty()) {
                return baixa.peek();
            }
            return null;
        }

        public int tamanho() {
            return tamanhoPilha(urgente) + tamanhoPilha(normal) + tamanhoPilha(baixa);
        }

        private int tamanhoPilha(PilhaProcessos p) {
            int count = 0;
            PilhaProcessos temp = new PilhaProcessos(10);

            while (!p.isEmpty()) {
                Processo proc = p.pop();
                temp.push(proc);
                count++;
            }

            while (!temp.isEmpty()) {
                p.push(temp.pop());
            }

            return count;
        }
        public void listar() {
            System.out.println("=== URGENTE ===");
            urgente.listar();

            System.out.println("=== NORMAL ===");
            normal.listar();

            System.out.println("=== BAIXA ===");
            baixa.listar();
        }
    }
