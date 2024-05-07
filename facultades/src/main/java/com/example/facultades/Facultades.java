package com.example.facultades;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

	@Entity
	public class Facultades{
		@jakarta.persistence.Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String nombre;
		private String ciudad;
		private String campus;
		private String photo;
		private Long carreras;
		
		
		public Facultades() {
			
		}
		
		public Facultades(Long id, String nombre, String ciudad, String campus, String photo, Long carreras) {
			this.id = id;
			this.nombre = nombre;
			this.ciudad = ciudad;
			this.campus = campus;
			this.photo = photo;
			this.carreras = carreras;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getCampus() {
			return campus;
		}
		public void setCampus(String campus) {
			this.campus = campus;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public Long getCarreras() {
			return carreras;
		}
		public void setCarreras(Long carreras) {
			this.carreras = carreras;
		}
		
		
	}
/*
record  Facultades(@Id Long id, String nombre, String ciudad, String campus,
		String photo, Long carreras, Boolean wifi){

}
*/