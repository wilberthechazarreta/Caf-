package com.tuempresa.cafeteria.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

public class CalculadorNumPlatillo implements ICalculator{

	@Getter @Setter
	int anyo;
	
	@Override
	public Object calculate() throws Exception {
		Query query = XPersistence.getManager()
				.createQuery("select max(f.numero) from Platillos f  where f.anyo = :anyo");
		query.setParameter("anyo", anyo);
		Integer ultimonum = (Integer) query.getSingleResult();
		return ultimonum == null ? 1 : ultimonum;
	}
}
