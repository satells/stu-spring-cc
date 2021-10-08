package com.stu.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.loja.dao.ProdutoDao;
import com.stu.loja.model.Produto;

@Controller
public class ProdutoController {

	ProdutoDao produtoDao;

	@RequestMapping("produtos/form")
	public String form() {
		return "/produtos/form";
	}

	@RequestMapping("/produtos")
	public String grava(Produto produto) {
		System.out.println(produto);
		return "/produtos/ok";
	}
}
