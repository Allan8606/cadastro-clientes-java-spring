package com.allanisaac_dev.CadastroDeClientes.Cliente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    Long id;
    String nome;
    String cpf;
    String telefone;
    String endereco;


}
