package com.example.facultades;

import org.springframework.data.annotation.Id;

	public class Facultades{
		@Id
		private Long id;
		private String nombre;
		private String ciudad;
		private String campus;
		private String photo;
		private Long carreras;
		private Boolean wifi;
		public Facultades(Long id, String nombre, String ciudad, String campus, String photo, Long carreras,
				Boolean wifi) {
			this.id = id;
			this.nombre = nombre;
			this.ciudad = ciudad;
			this.campus = campus;
			this.photo = photo;
			this.carreras = carreras;
			this.wifi = wifi;
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
		public Boolean getWifi() {
			return wifi;
		}
		public void setWifi(Boolean wifi) {
			this.wifi = wifi;
		}
		
		
	}
/*
record  Facultades(@Id Long id, String nombre, String ciudad, String campus,
		String photo, Long carreras, Boolean wifi){

}
*/