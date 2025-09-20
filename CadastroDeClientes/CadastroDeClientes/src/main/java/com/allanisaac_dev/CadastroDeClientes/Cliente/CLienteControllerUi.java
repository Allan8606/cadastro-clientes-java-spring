package com.allanisaac_dev.CadastroDeClientes.Cliente;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/clientes/ui")
public class CLienteControllerUi {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "cadastrarCliente.html";
    }

    @PostMapping("/cadastrar")
    public String cadastrarCliente(@ModelAttribute ClienteDTO clienteDTO, RedirectAttributes redirectAttributes) {
        clienteService.cadastrarCliente(clienteDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso! Nome: " + clienteDTO.getNome());
        return "redirect:/clientes/ui/listar";
    }



    @GetMapping("/listar")
    public String listarClientes(Model model) {
        List<ClienteDTO> listaClientes = clienteService.listarClientes();
        model.addAttribute("clientes", listaClientes);

        return "listaClientes.html";
    }


    @GetMapping("/listar/{id}")
    public String listarClientePorId(@PathVariable Long id, Model model) {
        ClienteDTO cliente =  clienteService.listarClientePorId(id);
        if (cliente != null){
            model.addAttribute("cliente", cliente);
            return "detalhesCliente.html";
        }else {
            return model.addAttribute("erro", "Não foi possível encontrar o cliente com ID: " + id).toString();
        }
    }

    @GetMapping("/atualizar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        ClienteDTO cliente = clienteService.listarClientePorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "editarCliente.html";
        } else {
            model.addAttribute("erro", "Cliente não encontrado para edição.");
            return "erro.html";
        }
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute ClienteDTO cliente, Model model) {
        cliente.setId(id);
        ClienteDTO atualizado = clienteService.atualizarCliente(id, cliente);
        if (atualizado != null) {
            return "redirect:/clientes/ui/listar/" + id;
        } else {
            model.addAttribute("erro", "Erro ao atualizar cliente.");
            return "erro.html";
        }
    }

    @PostMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id, Model model) {
        clienteService.deletarCliente(id);
        return "redirect:/clientes/ui/listar";
    }



}
