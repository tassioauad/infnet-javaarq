package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.PedidoRepository;
import br.edu.infnet.apppedido.model.test.AppImpressao;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public void incluir(Pedido pedido) {
		pedidoRepository.save(pedido);

		AppImpressao.relatorio("Inclusão do pedido " + pedido.getDescricao() + " realizada com sucesso!!!", pedido);
	}
	
	public Collection<Pedido> obterLista(){
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public Collection<Pedido> obterLista(Usuario usuario){
		return (Collection<Pedido>) pedidoRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id){
		pedidoRepository.deleteById(id);
	}
}