package com.stu.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.CarrinhoCompras;
import com.stu.loja.model.CarrinhoItem;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private CarrinhoCompras carrinho;

	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
		carrinho.add(carrinhoItem);

		return mv;

	}

	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDao.find(produtoId);

		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
		return carrinhoItem;
	}
}
