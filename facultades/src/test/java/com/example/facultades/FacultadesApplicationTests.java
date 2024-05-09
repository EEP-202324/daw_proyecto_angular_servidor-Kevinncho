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
import net.minidev.json.JSONArray;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
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
	    @DirtiesContext
	    void deberiaCrearNuevaFacultad() {
	       Facultades newFacultad = new Facultades(null, "Facultad de Psicología", "Quito","LaPiedra","https://www.ecured.cu/images/d/d6/Universidad_Central_del_Ecuador.jpg",9L);
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
	        assertThat(nombre).isEqualTo("Facultad de Psicología");
	        assertThat(ciudad).isEqualTo("Quito");
	        assertThat(campus).isEqualTo("LaPiedra");
	        assertThat(photo).isEqualTo("https://www.ecured.cu/images/d/d6/Universidad_Central_del_Ecuador.jpg");
	        assertThat(carreras).isEqualTo(9);

	    }
	    
	    @Test
	    @DirtiesContext
	    void deberiaDevolverTodasLasFacultadesCuandoSoliciteLista() {
	    	 ResponseEntity<String> response = restTemplate.getForEntity("/facultades", String.class);
	         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	         
	         DocumentContext documentContext = JsonPath.parse(response.getBody());
	         int facultadesCount = documentContext.read("$.length()");
	         assertThat(facultadesCount).isEqualTo(4);
	         
	         JSONArray ids = documentContext.read("$..id");
	         assertThat(ids).containsExactlyInAnyOrder(1, 2, 52,1152);
	         
	         JSONArray nombres = documentContext.read("$..nombre");
	         assertThat(nombres).containsExactlyInAnyOrder("Facultad de Derecho", "Facultad de Odontología", "Facultad de Educación inicial","Facultad de Odontología");
	         
	         JSONArray ciudades = documentContext.read("$..ciudad");
	         assertThat(ciudades).containsExactlyInAnyOrder("México", "Bogota", "Cuzco","Bogota");
	   
	         JSONArray campuses = documentContext.read("$..campus");
	         assertThat(campuses).containsExactlyInAnyOrder("JurisPraeceptum", "Colgate", "EDU","Colgate");
	         
	         JSONArray photos = documentContext.read("$..photo");
	         assertThat(photos).containsExactlyInAnyOrder(URL_FACU_DERECHO, URL_FACU_ODONTOLOGIA, URL_FACU_DERECHO,URL_FACU_ODONTOLOGIA);
	   
	         JSONArray carrerass = documentContext.read("$..carreras");
	         assertThat(carrerass).containsExactlyInAnyOrder(4, 4, 9,4);
	         
	    }
	    @Test
	    @DirtiesContext
	    void deberiaActualizarUnaFacultadExistente() {
	    	Facultades facultadUpdate= new Facultades(null, "Facultad de Educación inicial","Cuzco","EDU",URL_FACU_DERECHO,9L);
	    	 HttpEntity<Facultades> request = new HttpEntity<>(facultadUpdate);
	    	    ResponseEntity<Void> response = restTemplate .exchange("/facultades/52", HttpMethod.PUT, request, Void.class);
	    	    
	    	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	    	    
	    	    ResponseEntity<String> getResponse = restTemplate.getForEntity("/facultades/52", String.class);
	    	    
	    	    assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	    	    DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
	    	    Number id = documentContext.read("$.id");
	    	    String nombre = documentContext.read("$.nombre");
	    	    String ciudad = documentContext.read("$.ciudad");
	    	    String campus = documentContext.read("$.campus");
	    	    String photo = documentContext.read("$.photo");
	    	    Number carreras = documentContext.read("$.carreras");

	    	    assertThat(id).isEqualTo(52);
	    	    assertThat(nombre).isEqualTo("Facultad de Educación inicial");
	    	    assertThat(ciudad).isEqualTo("Cuzco");
	    	    assertThat(campus).isEqualTo("EDU");
	    	    assertThat(photo).isEqualTo(URL_FACU_DERECHO);
	    	    assertThat(carreras).isEqualTo(9);

	    }
	    @Test
	    void noDeberiaActualizarUnaFacultadQueNoExiste() {
	    	Facultades facultadDesconocida= new Facultades(null, "Facultad Química", "Sucre","Quimic","htt:ww/sccb/jede.jpg",5L);
	    	HttpEntity<Facultades> request = new HttpEntity<>(facultadDesconocida);
	    	ResponseEntity<Void> response = restTemplate.exchange("/facultades/99999", HttpMethod.PUT, request, Void.class);
	    	
	    	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	    }
	    
	    @Test
	    @DirtiesContext
	    void deberiaEliminarFacultadExistente() {
	    	ResponseEntity<Void> response = restTemplate.exchange("/facultades/1253", HttpMethod.DELETE, null, Void.class);
	    	
	    	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	    	ResponseEntity<String> getResponse = restTemplate.getForEntity("/facultades/1253", String.class);
	   
	    	assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	    }
	    @Test
	    void noDeberiaEliminarUnaFacultadQueNoExiste() {
	    	ResponseEntity<Void> deleteResponse = restTemplate .exchange("/facultades/99999", HttpMethod.DELETE, null, Void.class);
	    	
	    	assertThat(deleteResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	    }


}