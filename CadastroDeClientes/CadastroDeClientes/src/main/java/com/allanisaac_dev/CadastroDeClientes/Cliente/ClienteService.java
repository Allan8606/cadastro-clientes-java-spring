package com.allanisaac_dev.CadastroDeClientes.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {


    //Essa anotação faz injeção de dependencia, o que faz com que a gente não precise escrever construtor
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    //Cadastra cliente
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        clienteModel = clienteRepository.save(clienteModel);
        return clienteMapper.map(clienteModel);
    }


    //Lista todos os clientes
    public List<ClienteDTO> listarClientes(){
        List<ClienteModel> clientesModel = clienteRepository.findAll();
        return clientesModel.stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    //Lista cliente por ID
    public ClienteDTO listarClientePorId(Long id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        return cliente.map(clienteMapper::map).orElse(null);
    }

    //Editar/Atualiza cliente por ID
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()){
            ClienteModel clienteModel = clienteMapper.map(clienteDTO);
            clienteModel.setId(id);
            ClienteModel clienteSalvo = clienteRepository.save(clienteModel);
            return clienteMapper.map(clienteSalvo);
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
