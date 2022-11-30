package com.tuempresa.cafeteria.modelo;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class MetodoDePago extends Identificable{

	@Column
	String descripcion;
}
