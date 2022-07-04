package org.danna.olguin.gomez.service;
import java.util.LinkedList;
import java.util.List;
import org.danna.olguin.gomez.model.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements IntCategoria {
    
	private List<Categoria> lista = null;
    
	public CategoriaServiceImp() {
		lista = new LinkedList<Categoria>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Informatica");
		c1.setDescripcion("Relación con Informática");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Salud");
		c2.setDescripcion("Relación con la medicina");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Arquitectura");
		c3.setDescripcion("Relacinado con la arquitectura ");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
	}
	
	@Override
	public List<Categoria> obtenerTodas() {
		return lista;
	}

	@Override
	public void agregar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria categoria : lista) {
			if ( categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));

	}

	@Override
	public int totalCategorias() {
		return lista.size();
	}

	@Override
	public void modificar(Integer posicion, Categoria categoria) {
		lista.set(posicion, categoria);
		
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
}

}
