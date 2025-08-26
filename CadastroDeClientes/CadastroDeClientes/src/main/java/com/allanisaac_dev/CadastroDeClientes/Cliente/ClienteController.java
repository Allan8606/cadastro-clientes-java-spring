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
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> listarTodosCliente(){
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/{nome}")
    public List<ClienteDTO> listaClientePorNome(@PathVariable String nome){
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
