package com.example.CrudSpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ProductService service;

	// Map to index
	@RequestMapping("/")
	public String viewHomePage(Model model) {

		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);

		return "index";

	}

	// Map to new_product
	@RequestMapping("/new")
	public String newProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";

	}

	// Map to new_product
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);

		// Redirect to the home page
		return "redirect:/";

	}

	// Map to edit
	@RequestMapping("/edit/{id}")
	public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");

		Product product = service.get(id);
		mav.addObject("product", product);

		return mav;

	}

	// Map to delete
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		// Redirect to the home page
		return "redirect:/";

	}
	@GetMapping("/403")
	public String error403() {
		return "403";
	}

}
