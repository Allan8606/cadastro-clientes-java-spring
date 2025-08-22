package com.allanisaac_dev.CadastroDeClientes.Cliente;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    //Lista todos os clientes cadastrados
    public List<ClienteModel> listarTodosClientes(){
        return clienteRepository.findAll();
    }

    //Faz uma pesquisa por nome
    public ClienteModel listaClientePorNome(String nome){
        Optional<ClienteModel> clientePorNome = clienteRepository.findByNome(nome);
        return clientePorNome.orElse(null);
    }

    //Cadastra um novo cliente
    public ClienteModel cadastrarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    //Deletar cliente
    public void deletarClientePorID(Long id){
        clienteRepository.deleteById(id);
    }

}
