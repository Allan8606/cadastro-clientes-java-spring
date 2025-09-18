package com.allanisaac_dev.CadastroDeClientes.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;



    @GetMapping("/saudacao")
    public String saudacao() {
        return "Olá! Bem-vindo ao sistema de cadastro de clientes.";
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrarCliente(@RequestBody ClienteModel clienteModel) {
        return clienteService.cadastrarCliente(clienteModel);
    }

    @GetMapping("/listar")
    public List<ClienteModel> listarClientes() {
        return clienteService.listarClientes();

    }

    @GetMapping("/listar/{id}")
    public ClienteModel listarClientePorId(@PathVariable Long id) {
        return clienteService.listarClientePorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public ClienteModel atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteAtualizado){
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
