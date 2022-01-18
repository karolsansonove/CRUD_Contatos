package br.com.crudcontatos;

import java.util.List;
import java.util.Scanner;
import br.com.crudcontatos.dao.ContatoDAO;
import br.com.crudcontatos.model.Contato;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ContatoDAO contatoDAO = new ContatoDAO();

    public static void main(String[] args) {
        int op;

        while (true) {
            System.out.println("\nEscolha uma opção:"
                    + "\n1 - Cadastrar novo contato"
                    + "\n2 - Remover contato por ID"
                    + "\n3 - Atualizar contato"
                    + "\n4 - Listar todos os contatos"
                    + "\n5 - Sair");
            op = scan.nextInt();
            scan.nextLine();

            switch(op) {
                case 1:
                    cadastrarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    atualizarContato();
                    break;
                case 4:
                    listarContatos();
                    break;
                case 5:
                    System.out.println(">>> Aplicação encerrada <<<");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    private static void cadastrarContato() {
        System.out.println("============================================");
        System.out.println(">>>>>>>>>>>>>>> NOVO CONTATO <<<<<<<<<<<<<<<");
        System.out.println("============================================");
        System.out.println("Informe os dados solicitados abaixo:");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        contatoDAO.save(new Contato(nome, telefone));
    }

    private static void removerContato() {
        System.out.println("============================================");
        System.out.println(">>>>>>>>>>>>> REMOVER CONTATO <<<<<<<<<<<<<<");
        System.out.println("============================================");
        System.out.print("Informe o ID do contato a ser removido: ");
        int id = scan.nextInt();
        scan.nextLine();
        contatoDAO.removeById(id);
    }

    private static void atualizarContato() {
        System.out.println("============================================");
        System.out.println(">>>>>>>>>>>> ATUALIZAR CONTATO <<<<<<<<<<<<<");
        System.out.println("============================================");
        System.out.println("Informe os dados solicitados abaixo:");
        System.out.print("ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();

        contatoDAO.update(new Contato(id, nome, telefone));
    }

    private static void listarContatos() {
        System.out.println("============================================");
        System.out.println(">>>>>>>>>>>> LISTA DE CONTATOS <<<<<<<<<<<<<");
        System.out.println("============================================");

        List<Contato> contatos = contatoDAO.getListaContatos();

        for (Contato c : contatos) {
            System.out.println("ID: " + c.getId()
                    + "\nNome: " + c.getNome()
                    + "\nTelefone: " + c.getTelefone()
                    + "\nData de cadastro: " + c.getDataCadastro()
                    + "\n============================");
        }

        if (contatos.size() == 0) {
            System.out.println("\nA lista de contatos está vazia!");
        }
    }
}