package org.danna.olguin.gomez.service;
import java.util.List;
import org.danna.olguin.gomez.model.Categoria;

public interface IntCategoria {
	
	public List<Categoria> obtenerTodas();
	public void agregar (Categoria categoria);
	public Categoria buscarPorId (Integer idCategoria);
	public void eliminar (Integer idCategoria);
	public int totalCategorias();
	public void modificar(Integer posicion, Categoria categoria);
	public int buscarPosicion(Categoria categoria);

}
