package com.tuempresa.cafeteria.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

public class CalculadorNumBebidas implements ICalculator{

	@Getter @Setter
	int anyo;
	
	@Override
	public Object calculate() throws Exception {
		Query query = XPersistence.getManager()
				.createQuery("select max(f.numero) from Bebidas f  where f.anyo = :anyo");
		query.setParameter("anyo", anyo);
		Integer ultimonumero = (Integer) query.getSingleResult();
		return ultimonumero == null ? 1 : ultimonumero;
	}
}
