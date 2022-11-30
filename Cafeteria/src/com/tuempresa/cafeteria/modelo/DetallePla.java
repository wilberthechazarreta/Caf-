package com.tuempresa.cafeteria.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;

@Embeddable @Getter @Setter
public class DetallePla {
	
int cantidad;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Platillos platillos;
	
	@Money
	@Depends("precioPorUnidad,cantidad")
	public BigDecimal getImportes() {
		if (precioPorUnidad==null) return BigDecimal.ZERO;
		return new BigDecimal(cantidad).multiply(precioPorUnidad);
	}
	 
	@DefaultValueCalculator(value = CalculadorPrecioPorUnidadPlatillos.class, 
			properties = @PropertyValue(name = "numero", from = "platillos.numero")
	)
	
	@Money
	BigDecimal precioPorUnidad;

}
