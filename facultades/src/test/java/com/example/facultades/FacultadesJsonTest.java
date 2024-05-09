package com.example.facultades;
import static org.assertj.core.api.Assertions.assertThat; 

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.assertj.core.util.Arrays;


@JsonTest
class FacultadesJsonTest {
	private static final String URL_FACU_DERECHO= "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg";
	private static final String URL_FACU_ODONTOLOGIA="https://th.bing.com/th/id/R.ddc292c68e49005abd61c005f8c308cd?rik=I6nxg2Is5NZwzg&riu=http%3a%2f%2fwww.uabjo.mx%2fmedia%2f1%2f2021%2f06%2f2.jpg&ehk=pewkRgzNoamB1fl%2fORldaQltv0Yxk7xFMMTDq76ATuE%3d&risl=&pid=ImgRaw&r=0";
	 
	

	@Autowired
	 private JacksonTester<Facultades> json;
	 @Autowired
		private JacksonTester<Facultades[]> jsonList;
		private Facultades[] facultadeslist;
		
	@BeforeEach
		void setUp() {
			facultadeslist= Arrays.array(
				new Facultades(1L, "Facultad de Derecho", "México","JurisPraeceptum",URL_FACU_DERECHO,4L),
				new Facultades(2L, "Facultad de Odontología", "Bogota","Colgate",URL_FACU_ODONTOLOGIA,4L),
				new Facultades(55L, "Facultad de Odontología", "Bogota","Colgate",URL_FACU_ODONTOLOGIA,4L),
				new Facultades(102L, "Facultad de Odontología", "Bogota","Colgate",URL_FACU_ODONTOLOGIA,4L));
		}
	 @Test
	 void facultadesSerializationTest() throws  IOException{
		 Facultades facultades= facultadeslist[0];
		
	 assertThat(json.write(facultades)).isStrictlyEqualToJson("single.json");
     
	 assertThat(json.write(facultades)).hasJsonPathNumberValue("@.id");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.id")
             .isEqualTo(1);
     
     assertThat(json.write(facultades)).hasJsonPathStringValue("@.nombre");
     assertThat(json.write(facultades)).extractingJsonPathStringValue("@.nombre")
          .isEqualTo("Facultad de Derecho");
     
     assertThat(json.write(facultades)).hasJsonPathStringValue("@.ciudad");
     assertThat(json.write(facultades)).extractingJsonPathStringValue("@.ciudad")
          .isEqualTo("México");
     
     assertThat(json.write(facultades)).hasJsonPathStringValue("@.campus");
     assertThat(json.write(facultades)).extractingJsonPathStringValue("@.campus")
          .isEqualTo("JurisPraeceptum");
     
     assertThat(json.write(facultades)).hasJsonPathStringValue("@.photo");
     assertThat(json.write(facultades)).extractingJsonPathStringValue("@.photo")
          .isEqualTo(URL_FACU_DERECHO);
     
     assertThat(json.write(facultades)).hasJsonPathNumberValue("@.carreras");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.carreras")
             .isEqualTo(4);
	 
	 }
	 @Test
	 void FacultadesDeserializationTest() throws IOException {
	    String expected = """
	            {
	                "id": 1,
	    			"nombre": "Facultad de Derecho",
	    			"ciudad": "México",
	    			"campus": "JurisPraeceptum",
	    			"photo": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg",
	    			"carreras": 4
	            }
	            """;
	    Facultades facultades= json.parseObject(expected);
	    assertThat(json.parseObject(expected).getId()).isEqualTo(1);
	    assertThat(json.parseObject(expected).getNombre()).isEqualTo("Facultad de Derecho");
	    assertThat(json.parseObject(expected).getCiudad()).isEqualTo("México");
	    assertThat(json.parseObject(expected).getCampus()).isEqualTo("JurisPraeceptum");
	    assertThat(json.parseObject(expected).getPhoto()).isEqualTo(URL_FACU_DERECHO);
	    assertThat(json.parseObject(expected).getCarreras()).isEqualTo(4);


	 }
	 @Test
	 void facultadesListDeserializationTest() throws IOException {
	    String expected="""
	          [
	  {
	  "id": 1,
      "nombre": "Facultad de Derecho",
      "ciudad": "México",
      "campus": "JurisPraeceptum",
      "photo": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg",
      "carreras": 4
      },
      {   
      "id": 2,
      "nombre": "Facultad de Odontología",
      "ciudad": "Bogota",
      "campus": "Colgate",
      "photo": "https://th.bing.com/th/id/R.ddc292c68e49005abd61c005f8c308cd?rik=I6nxg2Is5NZwzg&riu=http%3a%2f%2fwww.uabjo.mx%2fmedia%2f1%2f2021%2f06%2f2.jpg&ehk=pewkRgzNoamB1fl%2fORldaQltv0Yxk7xFMMTDq76ATuE%3d&risl=&pid=ImgRaw&r=0",
      "carreras": 4
      },
      {    
      "id": 55,
      "nombre": "Facultad de Odontología",
      "ciudad": "Bogota",
      "campus": "Colgate",
      "photo": "https://th.bing.com/th/id/R.ddc292c68e49005abd61c005f8c308cd?rik=I6nxg2Is5NZwzg&riu=http%3a%2f%2fwww.uabjo.mx%2fmedia%2f1%2f2021%2f06%2f2.jpg&ehk=pewkRgzNoamB1fl%2fORldaQltv0Yxk7xFMMTDq76ATuE%3d&risl=&pid=ImgRaw&r=0",
      "carreras": 4
      },
      {    
      "id": 102,
      "nombre": "Facultad de Odontología",
      "ciudad": "Bogota",
      "campus": "Colgate",
      "photo": "https://th.bing.com/th/id/R.ddc292c68e49005abd61c005f8c308cd?rik=I6nxg2Is5NZwzg&riu=http%3a%2f%2fwww.uabjo.mx%2fmedia%2f1%2f2021%2f06%2f2.jpg&ehk=pewkRgzNoamB1fl%2fORldaQltv0Yxk7xFMMTDq76ATuE%3d&risl=&pid=ImgRaw&r=0",
      "carreras": 4
      }
]
	          """;	    
	    assertThat(jsonList.parse(expected)).isEqualTo(facultadeslist);
	 }
	 @Test
	 void facultadesListSerializationTest() throws IOException {
	    assertThat(jsonList.write(facultadeslist)).isStrictlyEqualToJson("list.json");
	 }

			 
}