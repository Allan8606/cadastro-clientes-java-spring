package com.allanisaac_dev.CadastroDeClientes.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO){
        ClienteModel clienteModel =  new ClienteModel();

        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setCpf(clienteDTO.getCpf());
        clienteModel.setSenha(clienteDTO.getSenha());

        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel){
        ClienteDTO clienteDTO =  new ClienteDTO();

        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setCpf(clienteModel.getCpf());
        clienteDTO.setSenha(clienteModel.getSenha());

        return clienteDTO;
    }



}
