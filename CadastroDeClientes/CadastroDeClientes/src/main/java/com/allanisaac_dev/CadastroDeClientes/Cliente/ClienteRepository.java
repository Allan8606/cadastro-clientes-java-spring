package com.allanisaac_dev.CadastroDeClientes.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    public Optional<ClienteModel> findByNome(String nome);

}
