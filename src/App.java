
import DAO.ProdutoDAO;
import entity.Produtos;
import java.util.Scanner;
// Importe corrigido para 'dao'

public class App {

    public static void main(String[] args) {
        Scanner pesquisa = new Scanner(System.in);

        try {
            // Instancia o DAO para manipulação de produtos
            ProdutoDAO produtoDAO = new ProdutoDAO();
            String opcao;

            do {
                // Menu de opções
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Cadastrar Produto");
                System.out.println("2 - Buscar Produto");
                System.out.println("3 - Remover Produto");
                System.out.println("4 - Sair");
                System.out.print("Opção: ");
                opcao = pesquisa.nextLine();  // Lê a opção escolhida pelo usuário

                switch (opcao) {
                    case "1":
                        cadastrarProduto(pesquisa, produtoDAO);
                        // Chama o método para cadastrar um produto
                        break;
                    case "2":
                        buscarProduto(pesquisa, produtoDAO);
                        // Chama o método para buscar um produto
                        break;
                    case "3":
                        removerProduto(pesquisa, produtoDAO);
                        // Chama o método para remover um produto
                        break;
                    case "4":
                        System.out.println("Saindo...");
                        // Mensagem de saída
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                    // Mensagem para opção inválida
                }

            } while (!opcao.equals("4"));
            // Fica em loop ate a opcao sair ser selecionada

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            pesquisa.close();
            // Fecha o Scanner ao finalizar o programa
        }
    }

    private static void cadastrarProduto(Scanner pesquisa, ProdutoDAO produtoDAO) {
        try {

            System.out.println("Informe o nome do produto: ");
            String nomeProduto = pesquisa.nextLine();

            int qntd;
            do {

                System.out.println("Informe a quantidade do produto: ");
                while (!pesquisa.hasNextInt()) {
                    System.out.println("Quantidade inválida.");
                    pesquisa.next();
                }
                qntd = pesquisa.nextInt();
            } while (qntd < 0);

            pesquisa.nextLine();

            // Cria um objeto Produto e define os atributos
            Produtos produto = new Produtos();
            produto.setNomeProd(nomeProduto);
            produto.setQntdProd(qntd);

            produtoDAO.cadastrarProduto(produto);
            // Chama o DAO para cadastrar o produto

            System.out.println("Produto cadastrado com sucesso!");
            System.out.println("Nome: " + produto.getNomeProd());
            System.out.println("Quantidade: " + produto.getQntdProd());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao cadastrar o produto: " + e.getMessage());
            // Exibe mensagem de erro
        }
    }

    private static void buscarProduto(Scanner pesquisa, ProdutoDAO produtoDAO) {
        try {
            System.out.println("Informe o nome do produto que deseja buscar: ");
            String nomeProduto = pesquisa.nextLine();

            // Busca o produto no DAO
            Produtos produto = produtoDAO.buscarProduto(nomeProduto);

            if (produto != null) {
                // Exibe informações do produto encontrado
                System.out.println("Produto encontrado:");
                System.out.println("Nome: " + produto.getNomeProd());
                System.out.println("Quantidade: " + produto.getQntdProd());
            } else {
                System.out.println("Produto não encontrado.");  
                // Mensagem se o produto não for encontrado
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao buscar o produto: " + e.getMessage()); 
             // Exibe mensagem de erro
        }
    }

    private static void removerProduto(Scanner pesquisa, ProdutoDAO produtoDAO) {
        try {
           
            System.out.println("Informe o nome do produto que deseja remover: ");
            String nomeProduto = pesquisa.nextLine();

            System.out.println("Informe a quantidade que deseja remover: ");
            int qntd = pesquisa.nextInt();
            pesquisa.nextLine(); 

            // Cria um objeto Produto e define os atributos para remoção
            Produtos produto = new Produtos();
            produto.setNomeProd(nomeProduto);
            produto.setQntdProd(qntd);

            produtoDAO.removerProduto(nomeProduto, qntd);  
            // Chama o DAO para remover o produto

            System.out.println("Produto removido com sucesso!"); 

        } catch (Exception e) {
            // Exibe mensagem de erro, se houver
            System.out.println("Ocorreu um erro ao remover o produto: " + e.getMessage());
        }
    }

}
