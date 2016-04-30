package com.z.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name="establecimiento")
public class Establecimiento implements Serializable {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length =11,nullable = false)
	private Integer id;

	@Column(name="nombre",length =100,nullable = true,unique = true)
	private String nombre;

	@Column(name="latitud",nullable = false)
	private float latitud;

	@Column(name="longitud",nullable = false)
	private float longitud;

	@Column(name="direccionDescripcion",length =100,nullable = false)
	private String direccionDescripcion;

	public Establecimiento(){}
	public Establecimiento(String direccionDescripcion,float latitud,float longitud,Categoria categoria,Integer id,String nombre){
		this.setDireccionDescripcion(direccionDescripcion);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setCategoria(categoria);
		this.setId(id);
		this.setNombre(nombre);
	}
	@Override
	public String toString(){
		return "DireccionDescripcion: "+this.getDireccionDescripcion()+", "+"Latitud: "+this.getLatitud()+", "+"Longitud: "+this.getLongitud()+", "+"Categoria: "+this.getCategoria().toString()+", "+"Id: "+this.getId()+", "+"Nombre: "+this.getNombre();
	}
	/******accessors*******/
	public void setDireccionDescripcion(String direccionDescripcion){
		this.direccionDescripcion=direccionDescripcion;
	}
	public String getDireccionDescripcion(){
		return this.direccionDescripcion;
	}
	public void setLatitud(float latitud){
		this.latitud=latitud;
	}
	public float getLatitud(){
		return this.latitud;
	}
	public void setLongitud(float longitud){
		this.longitud=longitud;
	}
	public float getLongitud(){
		return this.longitud;
	}
	public void setCategoria(Categoria categoria){
		this.categoria=categoria;
	}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
}