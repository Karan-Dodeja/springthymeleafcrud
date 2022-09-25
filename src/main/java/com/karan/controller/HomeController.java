package com.karan.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.karan.entity.Products;
import com.karan.repository.ProductRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProductRepository produRepo;
	
	@GetMapping("/")
	public String Home(Model m) {
		
		List<Products> list =  produRepo.findAll();
		m.addAttribute("all_products",list);
		return "index";
	}
	
	@GetMapping("/load_form")
	public String loadform() {
		return "add";
	}
	
	@PostMapping("/update_products")
	public String updateProducts(@ModelAttribute Products products,HttpSession session){
		produRepo.save(products);
		session.setAttribute("msg", "Product Updated Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit_form/{id}")
	public String editform(@PathVariable(value = "id") long id, Model m) {
		Optional<Products> product = produRepo.findById(id);
		Products pro = product.get();
		m.addAttribute("product",pro);
		return "edit";
	}
	
	@PostMapping("/save_products")
	public String saveProducts(@ModelAttribute Products products,HttpSession session) {
		produRepo.save(products);
		session.setAttribute("msg", "Product Added Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")	
	public String deleteProduct(@PathVariable(value  = "id") long id, HttpSession session ) {
		produRepo.deleteById(id);
		session.setAttribute("msg", "Deleted Sucessfully...");
		return "redirect:/";
	}
	
}
