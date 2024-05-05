package com.example.facultades;

import java.util.Optional; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facultades")
public class FacultadesController {
	private static final String URL_FACU_DERECHO= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg";
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Facultades> findById(@PathVariable Long requestedId) {
			
		if (requestedId.equals(0L)) {
			Facultades facultad = new Facultades(0L, "Facultad de Derecho", "México","JurisPraeceptum",URL_FACU_DERECHO,
					 4L,true);
			return ResponseEntity.ok(facultad);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
