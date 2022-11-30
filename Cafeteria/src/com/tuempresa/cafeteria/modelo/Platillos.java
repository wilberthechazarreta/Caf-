package com.tuempresa.cafeteria.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;


@Entity @Getter @Setter
public class Platillos extends Identificable{
	
	@Hidden
	@DefaultValueCalculator(value = CalculadorNumPlatillo.class,
    properties = @PropertyValue(name = "anyo"))
	@Column(length = 6)
	int numero;
	
	@Hidden
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length = 4)
	int anyo;
	
	@Column
	String nombre;
	
	@Money
    BigDecimal precio;
	
	@Column (length = 50)
	String descripcion;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    CategoriaPlatillos categoriaplatillo;
	
}
