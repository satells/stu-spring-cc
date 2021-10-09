package com.stu.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;

@Controller
public class ProdutoController {
	@Autowired
	ProdutoDao produtoDao;

	@RequestMapping("produtos/form")
	public String form() {
		return "/produtos/form";
	}

	@RequestMapping("/produtos")
	public String grava(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "/produtos/ok";
	}
}
