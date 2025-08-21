package com.allanisaac_dev.CadastroDeClientes.Cliente;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodosClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel listaClientePorNome(String nome){
        Optional<ClienteModel> clientePorNome = clienteRepository.findByNome(nome);
        return clientePorNome.orElse(null);
    }

    public ClienteModel cadastrarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }


}
