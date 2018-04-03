package com.hp.logs;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hp.logs.entity.CountryCode;

public class CountryCodeSerializer extends JsonSerializer<CountryCode> {

    private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void serialize(CountryCode value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	  
	        StringWriter writer = new StringWriter();
	        mapper.writeValue(writer, value);
	        gen.writeFieldName(writer.toString());
		
	}

}
