package com.example.facultades;

import java.util.Optional; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facultades")
 class FacultadesController {
	private static final String URL_FACU_DERECHO= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg";
	
	private final FacultadesRepository facultadesRepository;
	
	private FacultadesController(FacultadesRepository facultadesRepository) {
		this.facultadesRepository=facultadesRepository;
	}
	@GetMapping("/{requestedId}")
	private ResponseEntity<Facultades> findById(@PathVariable Long requestedId) {
			Optional<Facultades> facultadesOptional=facultadesRepository.findById(requestedId);
			if(facultadesOptional.isPresent()) {
				return ResponseEntity.ok(facultadesOptional.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		
	}
}
