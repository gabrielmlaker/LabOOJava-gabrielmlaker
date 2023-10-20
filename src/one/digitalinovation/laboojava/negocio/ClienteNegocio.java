package one.digitalinovation.laboojava.negocio;

import one.digitalinovation.laboojava.basedados.Banco;
import one.digitalinovation.laboojava.entidade.Cliente;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 * 
 * @author thiago leite
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     * 
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {
        for (Cliente cliente : bancoDados.getCliente()) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
    /**
     * Cadastra um novo cliente.
     * 
     * @param cliente Novo cliente que terá acesso a aplicação
     */
    // TODO Fazer a inclusão de cliente
    public void salvar(Cliente novoCliente) {
        novoCliente = new Cliente();
        String nome = novoCliente.getNome();
        String cpf = novoCliente.getCpf();
        novoCliente.setNome(nome);
        novoCliente.setCpf(cpf);
        System.out.println("Cliente salvo com sucesso.");
        bancoDados.adicionarCliente(novoCliente);        
    }

    /**
     * Exclui um cliente específico.
     * 
     * @param cpf CPF do cliente
     */
    // TODO Fazer a exclusão de cliente
    public void excluir(String cpf) {
        int cpfExclusao = -1;

        for (int i = 0; i < bancoDados.getCliente().length; i++) {
            Cliente cliente = bancoDados.getCliente()[i];
            if (cliente.getCpf().equals(cpf)) {
                cpfExclusao = i;
                break;
            }

            if (cpfExclusao != -1) {
                bancoDados.removerCliente(cpfExclusao);
                System.out.println("Cliente excluído com sucesso.");
            } else {
                System.out.println("Cliente inexistente.");
            }
        }
    }
}
