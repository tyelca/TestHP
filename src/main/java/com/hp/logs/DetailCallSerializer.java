package com.hp.logs;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hp.logs.entity.DetailCall;

public class DetailCallSerializer extends JsonSerializer<DetailCall> {

	
	@Override
	public void serialize(DetailCall value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {

	        jgen.writeStartObject();
	        jgen.writeNumberField("calls", value.getCallOriginCount());
	        jgen.writeNumberField("durationAvg", value.getCallDurationAvg());
	        jgen.writeEndObject();
	}

}
