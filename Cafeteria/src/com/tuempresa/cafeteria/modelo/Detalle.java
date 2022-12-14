package com.tuempresa.cafeteria.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;

@Embeddable @Getter @Setter
public class Detalle {

	int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Bebidas bebida;
	
	
	@Money
	@Depends("precioPorUnidad,cantidad")
	public BigDecimal getImporte() {
		if (precioPorUnidad==null) return BigDecimal.ZERO;
		return new BigDecimal(cantidad).multiply(precioPorUnidad);
	}
	 
	@DefaultValueCalculator(value = CalculadorPrecioporUnidad.class, 
			properties = @PropertyValue(name = "numero", from = "bebida.numero")
	)
	
	@Money
	BigDecimal precioPorUnidad;
}
