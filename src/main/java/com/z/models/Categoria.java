package com.z.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
        @JsonIgnore
	@OneToMany(mappedBy="categoria")
	private List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length =11,nullable = false)
	private Integer id;

	@Column(name="descripcion",length =50,nullable = true,unique = true)
	private String descripcion;

	public Categoria(){}
	public Categoria(String descripcion,Integer id,List<Establecimiento> establecimientos){
		this.setDescripcion(descripcion);
		this.setId(id);
		this.setEstablecimientos(establecimientos);
	}
	@Override
	public String toString(){
		return "Descripcion: "+this.getDescripcion()+", "+"Id: "+this.getId();
	}
	/******accessors*******/
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setEstablecimientos(List<Establecimiento> establecimientos){
		this.establecimientos=establecimientos;
	}
	public List<Establecimiento> getEstablecimientos(){
		return this.establecimientos;
	}
}