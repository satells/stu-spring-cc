package com.stu.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;
import com.stu.loja.model.TipoPreco;

@Controller
public class ProdutoController {
	@Autowired
	ProdutoDao produtoDao;

	@RequestMapping("produtos/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("/produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView; // "/produtos/form";
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public String grava(Produto produto) {

		produtoDao.gravar(produto);

		return "/produtos/ok";
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("/produtos/lista");
		List<Produto> produtos = produtoDao.listar();

		modelAndView.addObject("produtos", produtos);

		return modelAndView;

	}

}
