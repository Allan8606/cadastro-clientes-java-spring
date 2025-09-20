package com.allanisaac_dev.CadastroDeClientes.Cliente;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;



    @GetMapping("/saudacao")
    @Operation(summary = "Menssagem de boas vindas", description = "Rota para exibir uma mensagem de saudação.")
    public String saudacao() {
        return "Olá! Bem-vindo ao sistema de cadastro de clientes.";
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar cliente", description = "Rota para cadastrar um novo cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O cliente foi cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição, dados inválidos"),
    })
    public ResponseEntity<String> cadastrarCliente(
            @Parameter(description = "Dados do cliente a ser cadastrado")
            @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!" +
                " ID: " + cliente.getId() + ". Nome: " + cliente.getNome());

    }

    @GetMapping("/listar")
    @Operation(summary = "Lita todos os clientes", description = "Rota para listar todos os clientes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Lista de clientes retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não foi possível retornar a lista de clientes"),
    })
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();

        return ResponseEntity.ok(clientes);

    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista cliente pelo seu id", description = "Rota para listar um cliente pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O cliente encontrado sucesso"),
            @ApiResponse(responseCode = "400", description = "Cliente não encontrado"),
    })
    public ResponseEntity<?> listarClientePorId(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id) {
        ClienteDTO cliente =  clienteService.listarClientePorId(id);
        if (cliente != null){
            return ResponseEntity.ok(cliente);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o cliente com ID: " + id);
        }
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza cliente pelo id", description = "Rota para atualizar um cliente pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O cliente encontrado sucesso"),
            @ApiResponse(responseCode = "400", description = "Cliente não encontrado"),
    })
    public ResponseEntity<?> atualizarCliente(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do cliente a ser atualizado no corpo da requisiçao")
            @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.atualizarCliente(id, clienteDTO);

        if (cliente != null){
            return  ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível atualizar o cliente com ID: " + id);
        }
    }


    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta cliente pelo id", description = "Rota para deletar um cliente pelo seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O cliente deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Cliente não encontrado"),
    })
    public ResponseEntity<String> deletarCliente(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id) {
        if (clienteService.listarClientePorId(id) != null){
            return ResponseEntity.ok("Cliente deletado com sucesso! ID: " + id + ", Nome: " + clienteService.listarClientePorId(id).getNome());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível deletar o cliente com ID: " + id);
        }
    }
}
