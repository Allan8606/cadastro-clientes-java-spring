package com.allanisaac_dev.CadastroDeClientes.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    //Essa anotação faz injeção de dependencia, o que faz com que a gente não precise escrever construtor
    @Autowired
    private ClienteRepository clienteRepository;


    //Cadastra cliente
    public ClienteModel cadastrarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }


    //Lista todos os clientes
    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    //Lista cliente por ID
    public ClienteModel listarClientePorId(Long id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    //Editar/Atualiza cliente por ID
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteAtualizado){
        if (clienteRepository.existsById(id)){
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;

    }

    //Deleta cliente por ID
    public void deletarCliente(Long id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()){
            clienteRepository.deleteById(id);
        }else {
            System.out.println("Cliente não encontrado" );
        }

    }


}
