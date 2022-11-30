package com.tuempresa.cafeteria.calculadores;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.tuempresa.cafeteria.modelo.*;

import lombok.*;

public class CalculadorPrecioPorUnidadPlatillos implements ICalculator{
	
	@Getter @Setter
	int numeroPlatillo;
	
	@Override
	public Object calculate() throws Exception {
		Platillos platillos = getManager() 
				.find(Platillos.class, numeroPlatillo);
		return platillos.getPrecio();
		 
	}
}
