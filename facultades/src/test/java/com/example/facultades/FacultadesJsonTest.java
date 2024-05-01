package com.example.facultades;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
class FacultadesJsonTest {
	
	 @Autowired
	 private JacksonTester<Facultades> json;
	 
	 @Test
	 void facultadesSerializationTest() throws  IOException{
		 Facultades facultades= new Facultades(0L, "Facultad de Derecho", "México","JurisPraeceptum","https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg",
				 4L,true);
	 
	 assertThat(json.write(facultades)).isStrictlyEqualToJson("expected.json");
     
	 assertThat(json.write(facultades)).hasJsonPathNumberValue("@.id");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.id")
             .isEqualTo(0);
     
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
          .isEqualTo("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg");
     
     assertThat(json.write(facultades)).hasJsonPathNumberValue("@.carreras");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.carreras")
             .isEqualTo(4);
     assertThat(json.write(facultades)).hasJsonPathBooleanValue("@.wifi");
     assertThat(json.write(facultades)).extractingJsonPathBooleanValue("@.wifi")
             .isEqualTo(true);
	 
	 }
//	 @Test
//	 void FacultadesDeserializationTest() throws IOException {
//	    String expected = """
//	            {
//	                "id":99,
//	                "amount":123.45
//	            }
//	            """;
//	    assertThat(json.parse(expected))
//	            .isEqualTo(new Facultades(0L, "Facultad de Derecho", "México","JurisPraeceptum","https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Facultad_de_Derecho_%288617641510%29.jpg/1280px-Facultad_de_Derecho_%288617641510%29.jpg",
//	   				 4L,true));
//	    assertThat(json.parseObject(expected).id()).isEqualTo(99);
//	    assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
//	 }
}
