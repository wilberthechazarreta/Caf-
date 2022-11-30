package com.tuempresa.cafeteria.calculadores;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.tuempresa.cafeteria.modelo.*;

import lombok.*;

public class CalculadorPrecioporUnidad implements ICalculator{
	
	@Getter @Setter
	int numeroBebida;
	
	@Override
	public Object calculate() throws Exception {
		Bebidas bebidas = getManager() 
				.find(Bebidas.class, numeroBebida);
		return bebidas.getPrecio();
		 
	}
}
