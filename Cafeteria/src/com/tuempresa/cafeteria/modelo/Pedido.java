package com.tuempresa.cafeteria.modelo;
 

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Pedido extends Identificable{
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    Mesa mesa;

	@ElementCollection
	@ListProperties("bebida.nombre, cantidad, precioPorUnidad," +
			"importe+[" +
			"pedido.porcentajeIVA," +
			"pedido.iva," +
			"pedido.importeTotal" +
		 "]")
	Collection<Detalle>detalles;
	
	
	@ElementCollection
	@ListProperties("platillos.nombre, cantidad, precioPorUnidad," +
			"importes+[" +
			"pedido.porcentajeIVA," +
			"pedido.iva," +
			"pedido.importeTotal" +
		 "]")
	Collection<DetallePla>detallepla;
	
	@Digits(integer = 2, fraction = 0)
	BigDecimal porcentajeIVA;
	
	@Digits(integer = 2, fraction = 0)
	BigDecimal PorcentajeIVA;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detalles.importe)")
	BigDecimal totalBebida;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detallepla.importes)")
	//@Calculation("sum(detallepla.importes)")
	BigDecimal totalPlatillo;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detalles.importe)*porcentajeIVA/100")
	BigDecimal iva;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detalles.importe)+iva")
	BigDecimal importeTotal;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detallepla.importes)*porcentajeIVA/100")
	BigDecimal Iva;
	
	@ReadOnly
	@Stereotype("DINERO")
	@Calculation("sum(detallepla.importes)+Iva")
	BigDecimal ImporteTotal;
}
