package org.danna.olguin.gomez.service;

import java.util.List;

import org.danna.olguin.gomez.model.Vacante;

public interface IntVacante {
	
	public List<Vacante> obtenerTodas();
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public Vacante buscarPorId(Integer idVacante);
	public long numeroVacantes();

}
