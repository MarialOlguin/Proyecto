package org.danna.olguin.gomez.controller;
import java.util.List;
import org.danna.olguin.gomez.model.Categoria;
import org.danna.olguin.gomez.model.Vacante;
import org.danna.olguin.gomez.service.IntCategoria;
import org.danna.olguin.gomez.service.IntVacante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired 
	private IntVacante serviceVacantes;
	
	@Autowired
	private IntCategoria serviceCategorias;
	
	@GetMapping ("/home")
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.obtenerTodas();
		List<Categoria> categorias = serviceCategorias.obtenerTodas();
		model.addAttribute("vacantes",lista);
		model.addAttribute("categorias", categorias);
		return "home";
	}

}
