package com.tuempresa.cafeteria.modelo;
 

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Pedido extends Identificable{
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    Mesa mesa;

	@ElementCollection
	@ListProperties("bebida.numero, bebida.nombre, cantidad, precioPorUnidad, importe")
	Collection<Detalle>detalles;
	
}
