package drls.nails.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import drls.nails.domain.Cliente;
import drls.nails.service.ClienteService;

@Component
public class StringToClienteConverter implements Converter<String, Cliente> {
	
	@Autowired
	private ClienteService clienteService;
	
	@Override
	public Cliente convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return clienteService.buscarPorId(id);
	}
}