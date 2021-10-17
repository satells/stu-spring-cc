package com.stu.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.CarrinhoCompras;
import com.stu.loja.model.CarrinhoItem;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private CarrinhoCompras carrinho;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
		System.out.println("carrinho");
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
		carrinho.add(carrinhoItem);

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView itens() {
		return new ModelAndView("carrinho/itens");
	}

	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDao.find(produtoId);

		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
		return carrinhoItem;
	}

	@RequestMapping("/remover")
	public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco) {

		carrinho.remover(produtoId, tipoPreco);
		return new ModelAndView("redirect:/carrinho");

	}
}
