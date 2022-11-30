package com.tuempresa.cafeteria.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.cafeteria.calculadores.*;

import lombok.*;

@Entity @Getter @Setter
public class Factura extends Identificable{
	
	@Column(length=4)
	 @DefaultValueCalculator(CurrentYearCalculator.class) 
	 int anyo;
	
	@Column (length = 8)
	@Required
	String hora;
	
	
	@ReadOnly 
	@DefaultValueCalculator(value = calculadorPedido.class, properties = @PropertyValue(name = "anyo") )
	@Column (length = 6)
	int numero;
	

	@ManyToOne
    (fetch = FetchType.LAZY,
    optional=true )
    @DescriptionsList
	MetodoDePago metodoDePago;
	
}
