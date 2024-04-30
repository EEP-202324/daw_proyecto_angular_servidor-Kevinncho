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
		 Facultades facultades= new Facultades(99L, 123.45);
	 
	 assertThat(json.write(facultades)).isStrictlyEqualToJson("expected.json");
     assertThat(json.write(facultades)).hasJsonPathNumberValue("@.id");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.id")
             .isEqualTo(99);
     assertThat(json.write(facultades)).hasJsonPathNumberValue("@.amount");
     assertThat(json.write(facultades)).extractingJsonPathNumberValue("@.amount")
          .isEqualTo(123.45);
	 
 }
}
