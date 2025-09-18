package com.allanisaac_dev.CadastroDeClientes.Cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String cpf;
    String telefone;
    String endereco;


}
