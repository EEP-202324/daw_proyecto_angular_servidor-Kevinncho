package com.example.facultades;

import java.net.URI;   
import java.util.Optional;  

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin
@RequestMapping("/facultades")
 public class FacultadesController {
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
	@PostMapping
	private ResponseEntity<Void> crearFacultad(@RequestBody Facultades newFacultadRequest, UriComponentsBuilder ucb) {
		Facultades savedFacultad = facultadesRepository.save(newFacultadRequest);
		   URI locationOfNewFacultad = ucb.path("facultades/{id}")
		            .buildAndExpand(savedFacultad.getId())
		            .toUri();
		return ResponseEntity.created(locationOfNewFacultad).build();
	}
	@GetMapping()
	private ResponseEntity<Iterable<Facultades>> findAll() {
	   return ResponseEntity.ok(facultadesRepository.findAll());
	}
	
	@PutMapping("/{requestedId}")
	private ResponseEntity<Void> putFacultad(@PathVariable Long requestedId, @RequestBody Facultades facultadUpdate){
        Optional<Facultades> optional = facultadesRepository.findById(requestedId);
		if(optional.isPresent()) {
			Facultades facultad= optional.get();
			Facultades updateFacultad= new Facultades(facultad.getId(), 
					facultadUpdate.getNombre(),
					facultadUpdate.getCiudad(),
					facultadUpdate.getCampus(),
					facultadUpdate.getPhoto(), 
					facultadUpdate.getCarreras());
					facultadesRepository.save(updateFacultad);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deleteFacultad(@PathVariable Long id) {
		facultadesRepository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
	
}
