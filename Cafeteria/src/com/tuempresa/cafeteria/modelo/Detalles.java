package com.tuempresa.cafeteria.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;

@Embeddable @Getter @Setter
public class Detalles {
int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Bebidas bebidas;
	
	
	@Money
	@Depends("precioPorUnidad,cantidad")
	public BigDecimal getImporte() {
		if (numeroBebida==null) return BigDecimal.ZERO;
		return new BigDecimal(cantidad).multiply(bebidas.getPrecio());
	}
	 
	@DefaultValueCalculator(value = CalculadorPrecioporUnidad.class, 
			properties = @PropertyValue(name = "numeroBebida", from = "bebidas.numero")
	)
	
	@Money
	BigDecimal numeroBebida;
}
