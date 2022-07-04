package org.danna.olguin.gomez.controller;
import java.util.List;

import javax.validation.Valid;

import org.danna.olguin.gomez.model.Categoria;
import org.danna.olguin.gomez.service.IntCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categoria")
public class CategoriasController {

	@Autowired
	private IntCategoria categoriaService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriaService.obtenerTodas();	
		for(Categoria c : lista) {
		}
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	//***********************************************************
	@GetMapping("/crear")
	public String nuevaCategoria(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	//***********************************************************
	/* @PostMapping("/guardar")
	public String guardarCategoria(
			@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			Model model) {
		
		Categoria c = new CategoriaerToda();
		c.setId(categoriaService.obtens().size()+1);
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		//System.out.println(c);
		categoriaService.agregar(c);
		

		/*List<Categori> lista = categoriaService.obtenerTodas();
		 * model.addAttribute("categorias", lista);
		 * model.addAttribute("total", categoriaService.obtenerTodas().size());
		 
		return "redirect:/categoria/index";
	*/
	@PostMapping("/guardar")
	public String guardar(
			@Valid
			Categoria categoria, 
			BindingResult result,
			RedirectAttributes model) {
		if(result.hasErrors()) {
			System.out.println("Error");
			return "categorias/formCategoria";
		}else {
	
		if ( categoria.getId() == null) {
			int index = categoriaService.obtenerTodas().size()-1;
			Categoria aux = categoriaService.obtenerTodas().get(index);
			categoria.setId(aux.getId()+1);
			model.addFlashAttribute("msg", "Se guardo la categoría");
			categoriaService.agregar(categoria);
		}else {
			int posicion = categoriaService.buscarPosicion(categoria);
			//System.out.println(posicion);
			model.addFlashAttribute("msg", "Se modificó la categoría");
			categoriaService.modificar(posicion, categoria);
		}
		
		return "redirect:/categoria/index";
	}
	}
	@GetMapping("/eliminar")
	public String eliminar(
			@RequestParam("id") int idCategoria,
			RedirectAttributes model) {
		categoriaService.eliminar(idCategoria);
		model.addFlashAttribute("msg", "Categoría eliminada");
		return "redirect:/categoria/index";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = categoriaService.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}

}
