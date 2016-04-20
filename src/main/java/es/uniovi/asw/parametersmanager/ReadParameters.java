package es.uniovi.asw.parametersmanager;

import es.uniovi.asw.model.types.ElectionDateTime;
import es.uniovi.asw.util.ParametersException;

/**
 * ReadParameters
 * Created by ivan on 2/04/16.
 * 
 * Añadidos diferentes metodos, a uno sólo se le pasa la ElectionDateTime y a partir de ahi se
 * crea una Election y se le asigna todo lo correspondiente
 */
public interface ReadParameters {
	
	/*
	 * Le pasamos como parametro la ElectionDateTime y a la hora de implementar el método creamos una
	 * nueva Election con su correspondiente nombre y comentario y le asignamos esta ElectionDateTime.
	 * (REVISAR)
	 *
	 */
	public void read(ElectionDateTime edt, String name, String description) throws ParametersException;

}
