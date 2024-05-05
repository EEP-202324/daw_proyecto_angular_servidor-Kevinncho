package com.example.facultades;
import 
org.springframework.data.annotation.Id;

record  Facultades(@Id Long id, String nombre, String ciudad, String campus,
		String photo, Long carreras, Boolean wifi){

}
