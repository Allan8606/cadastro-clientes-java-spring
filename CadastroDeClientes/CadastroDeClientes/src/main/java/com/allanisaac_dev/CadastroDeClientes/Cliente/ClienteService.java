package com.allanisaac_dev.CadastroDeClientes.Cliente;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    //Lista todos os clientes cadastrados
    public List<ClienteDTO> listarTodosClientes(){
        List<ClienteModel> clienteModel =clienteRepository.findAll();
        return clienteModel.stream()
                .map(clienteMapper::map).collect(Collectors.toList());
    }

    //Faz uma pesquisa por nome
    public List<ClienteDTO> listaClientePorNome(String nome){
        List<ClienteModel> clientePorNome = clienteRepository.findByNome(nome);
        return clientePorNome.stream()
                .map(clienteMapper::map).collect(Collectors.toList());
    }

    //Cadastra um novo cliente
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        clienteModel = clienteRepository.save(clienteModel);
        return clienteMapper.map(clienteModel);
    }

    //Deletar cliente
    public void deletarClientePorID(Long id){
        clienteRepository.deleteById(id);
    }

}
