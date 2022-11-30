package com.tuempresa.cafeteria.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;

@Entity @Getter @Setter
public class Bebidas extends Identificable{
	
	@Hidden
	@DefaultValueCalculator(value = CalculadorNumBebidas.class,
    properties = @PropertyValue(name = "anyo"))
	@Column(length = 6)
	int numero;
	
	@Hidden
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length = 4)
	int anyo;
	
	@Column (length = 50)
	String nombre;
	
	@Money
    BigDecimal precio;
	
	@Column (length = 50)
	String descripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    CategoriaBebidas categoriabebidas;
}
