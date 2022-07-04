package org.danna.olguin.gomez.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.danna.olguin.gomez.model.Categoria;
import org.danna.olguin.gomez.model.Vacante;
import org.springframework.stereotype.Service;

@Service
public class VacanteServiceImp implements IntVacante {

	private List<Vacante> lista = null;

	public VacanteServiceImp() {
		lista = new LinkedList<Vacante>();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Analista de sistemas");
			v1.setDescripcion("Descripcione de CU");
			v1.setFecha(LocalDate.parse("26/04/2022", formato));
			v1.setSalario(1234.70);
			v1.setEstatus("Creada");
			v1.setDestacado(1);
			v1.setImagen("logo8.png");
			v1.setDetalles("<h2>Ofrecemos</h2>" + "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat1 = new Categoria();
			cat1.setId(4);
			cat1.setNombre("Programación");
			cat1.setDescripcion("");
			v1.setCategoria(cat1);

			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Cirujano");
			v2.setDescripcion("Neurocirujano con experiencia");
			v2.setFecha(LocalDate.parse("01/07/2022", formato));
			v2.setSalario(40000.50);
			v2.setEstatus("Creada");
			v2.setDestacado(1);
			v2.setImagen("logo8.png");
			v2.setDetalles("<h2>Ofrecemos</h2>" + "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat2 = new Categoria();
			cat2.setId(2);
			cat2.setNombre("Salud");
			cat2.setDescripcion("Descripción");
			v2.setCategoria(cat2);

			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Igeniero civil");
			v3.setDescripcion("Costruccio de puentes");
			v3.setFecha(LocalDate.parse("05/08/2022", formato));
			v3.setSalario(1882.00);
			v3.setEstatus("Creada");
			v3.setDestacado(1);
			v3.setImagen("logo8.png");
			v3.setDetalles("<h2>Ofrecemos</h2>" + "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat3 = new Categoria();
			cat3.setId(5);
			cat3.setNombre("Construccion");
			cat3.setDescripcion("");
			v3.setCategoria(cat3);

			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
		} catch (DateTimeParseException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	@Override
	public List<Vacante> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for (Vacante v : lista) {
			if (v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public long numeroVacantes() {
		return 0;
	}

}
