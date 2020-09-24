package drls.nails.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import drls.nails.domain.Cliente;
import drls.nails.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarTodos());
		return "cliente/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cliente/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(Cliente cliente) {
		clienteService.salvar(cliente);
		return "redirect:/clientes/listar";
	}
	
}
