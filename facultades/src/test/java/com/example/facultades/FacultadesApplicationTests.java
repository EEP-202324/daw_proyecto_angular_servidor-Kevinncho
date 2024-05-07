package com.example.facultades;

import com.jayway.jsonpath.DocumentContext; 
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FacultadesApplicationTests {
	private static final String URL_FACU_DERECHO= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg";

	 @Autowired
	    TestRestTemplate restTemplate;

	    @Test
	    void deberiaDevolverUnaFacultadCuandoSeGuardenLosDatos() {
	    	
	    	ResponseEntity<String> response  = restTemplate.getForEntity("/facultades/99", String.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        DocumentContext documentContext = JsonPath.parse(response.getBody());
	        Number id = documentContext.read("$.id");
	        assertThat(id).isEqualTo(99);

	        String nombre = documentContext.read("$.nombre");
	        assertThat(nombre).isEqualTo("Facultad de Derecho");

	        String ciudad = documentContext.read("$.ciudad");
	        assertThat(ciudad).isEqualTo("México");

	        String campus = documentContext.read("$.campus");
	        assertThat(campus).isEqualTo("JurisPraeceptum");

	        String photo = documentContext.read("$.photo");
	        assertThat(photo).isEqualTo(URL_FACU_DERECHO);

	        Number carreras = documentContext.read("$.carreras");
	        assertThat(carreras).isEqualTo(4);

	        Boolean wifi = documentContext.read("$.wifi");
	        assertThat(wifi).isEqualTo(true);


	    }


	    @Test
	    void noDeberiaDevolverUnaFacultadConUnIdDesconocido() {
	        ResponseEntity<String> response  = restTemplate.getForEntity("/facultades/1000", String.class);
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	        assertThat(response.getBody()).isBlank();
	    }


}