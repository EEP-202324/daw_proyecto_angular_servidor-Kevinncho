package com.example.facultades;

import com.jayway.jsonpath.DocumentContext;   
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FacultadesApplicationTests {
	private static final String URL_FACU_DERECHO= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg";
	private static final String URL_FACU_ODONTOLOGIA="https://th.bing.com/th/id/R.ddc292c68e49005abd61c005f8c308cd?rik=I6nxg2Is5NZwzg&riu=http%3a%2f%2fwww.uabjo.mx%2fmedia%2f1%2f2021%2f06%2f2.jpg&ehk=pewkRgzNoamB1fl%2fORldaQltv0Yxk7xFMMTDq76ATuE%3d&risl=&pid=ImgRaw&r=0";
	 @Autowired
	    TestRestTemplate restTemplate;

	    @Test
	    void deberiaDevolverUnaFacultadCuandoSeGuardenLosDatos() {
	    	
	    	ResponseEntity<String> response  = restTemplate.getForEntity("/facultades/1", String.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        DocumentContext documentContext = JsonPath.parse(response.getBody());
	        Number id = documentContext.read("$.id");
	        assertThat(id).isEqualTo(1);

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



	    }


	    @Test
	    void noDeberiaDevolverUnaFacultadConUnIdDesconocido() {
	        ResponseEntity<String> response  = restTemplate.getForEntity("/facultades/1000", String.class);
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	        assertThat(response.getBody()).isBlank();
	    }
	    
	    @Test
	    void deberiaCrearNuevaFacultad() {
	       Facultades newFacultad = new Facultades(null, "Facultad de Odontología", "Bogota","Colgate",URL_FACU_ODONTOLOGIA,4L);
	       ResponseEntity<Void> createResponse = restTemplate.postForEntity("/facultades", newFacultad, Void.class);
	       assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	       
	       URI locationOfNewFacultad = createResponse.getHeaders().getLocation();
	       ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewFacultad, String.class);
	       
	       assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	       
	       DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
	       Number id= documentContext.read("$.id");
	       String nombre = documentContext.read("$.nombre");
	       String ciudad = documentContext.read("$.ciudad");
	       String campus = documentContext.read("$.campus");
	       String photo = documentContext.read("$.photo");
	       Number carreras = documentContext.read("$.carreras");

	       assertThat(id).isNotNull();
	        assertThat(nombre).isEqualTo("Facultad de Odontología");
	        assertThat(ciudad).isEqualTo("Bogota");
	        assertThat(campus).isEqualTo("Colgate");
	        assertThat(photo).isEqualTo(URL_FACU_ODONTOLOGIA);
	        assertThat(carreras).isEqualTo(4);

	    }
	    


}