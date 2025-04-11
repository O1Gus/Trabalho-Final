import java.util.Scanner;

public class MainListaDinamiquinha {
    public static void main(String[] args) {
        ListaDinamiquinha dinamiquinha = new ListaDinamiquinha();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MENU LISTA DINÂMICA ==========");
            System.out.println("| 0  - Sair                              |");
            System.out.println("| 1  - Inserir Elemento                  |");
            System.out.println("| 2  - Inserir Sequência                 |");
            System.out.println("| 3  - Exibir Lista                      |");
            System.out.println("| 4  - Remover Elemento                  |");
            System.out.println("| 5  - Remover Sequência                 |");
            System.out.println("| 6  - Remover Todas Ocorrências         |");
            System.out.println("| 7  - Verificar se está cheia           |");
            System.out.println("| 8  - Verificar se está vazia           |");
            System.out.println("| 9  - Buscar Elemento                   |");
            System.out.println("| 10 - Ordenar em ordem crescente        |");
            System.out.println("| 11 - Ordenar em ordem decrescente      |");
            System.out.println("| 12 - Verificar quantidade de elementos |");
            System.out.println("| 13 - Editar Elemento                   |");
            System.out.println("| 14 - Limpar Lista                      |");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    sc.close();
                    System.exit(0);
                    break;

                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    String elemento = sc.nextLine();
                    dinamiquinha.inserirElemento(elemento);
                    break;

                case 2:
                    System.out.print("Digite os elementos separados por vírgula: ");
                    String entrada = sc.nextLine();
                    dinamiquinha.inserirSequencia(entrada);
                    break;

                case 3:
                    dinamiquinha.exibir();
                    break;

                case 4:
                    System.out.print("Digite o elemento a ser removido: ");
                    String remover = sc.nextLine();
                    boolean removido = dinamiquinha.removerElemento(remover);
                    System.out.println(removido ? "Elemento removido com sucesso." : "Elemento não encontrado.");
                    break;

                case 5:
                    System.out.print("Digite os elementos a serem removidos (separados por vírgula): ");
                    String removSeq = sc.nextLine();
                    dinamiquinha.removerSequencia(removSeq);
                    break;

                case 6:
                    System.out.print("Digite o elemento para remover todas as ocorrências: ");
                    String todos = sc.nextLine();
                    dinamiquinha.removerTodasOcorrencias(todos);
                    break;

                case 7:
                    System.out.println(dinamiquinha.estaCheia() ? "A lista está cheia." : "A lista não está cheia.");
                    break;

                case 8:
                    System.out.println(dinamiquinha.estaVazia() ? "A lista está vazia." : "A lista possui elementos.");
                    break;

                case 9:
                    System.out.print("Digite o elemento que deseja buscar: ");
                    String busca = sc.nextLine();
                    System.out.println(dinamiquinha.buscarElemento(busca) ? "Elemento encontrado." : "Elemento não encontrado.");
                    break;

                case 10:
                    dinamiquinha.ordenarCrescente();
                    System.out.println("Lista ordenada em ordem crescente.");
                    break;

                case 11:
                    dinamiquinha.ordenarDecrescente();
                    System.out.println("Lista ordenada em ordem decrescente.");
                    break;

                case 12:
                    System.out.println("Quantidade de elementos: " + dinamiquinha.quantidadeElementos());
                    break;

                case 13:
                    System.out.print("Digite o elemento a ser editado: ");
                    String antigo = sc.nextLine();
                    System.out.print("Digite o novo elemento: ");
                    String novo = sc.nextLine();
                    dinamiquinha.editarElemento(antigo, novo);
                    break;

                case 14:
                    dinamiquinha.limpar();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            System.out.print("\nPressione ENTER para continuar...");
            sc.nextLine();
        }
    }
}
