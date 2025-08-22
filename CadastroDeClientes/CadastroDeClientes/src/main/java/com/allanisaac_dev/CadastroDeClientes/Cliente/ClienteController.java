package com.allanisaac_dev.CadastroDeClientes.Cliente;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteModel cadastrarCliente(@RequestBody ClienteModel clienteModel){
        return clienteService.cadastrarCliente(clienteModel);
    }

    @GetMapping
    public List<ClienteModel> listarTodosCliente(){
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/{nome}")
    public ClienteModel listaClientePorNome(@PathVariable String nome){
        return  clienteService.listaClientePorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarClientePorID(@PathVariable Long id){
        clienteService.deletarClientePorID(id);
    }

    @PutMapping
    public String editarCliente(){
        return "Editando cliente!";
    }


}
