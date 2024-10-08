package com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ruta"
})
public class Ruta {
	@JsonProperty("ruta")
	private String ruta;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("ruta")
	public String getRuta() {
	return ruta;
	}

	@JsonProperty("ruta")
	public void setRuta(String ruta) {
	this.ruta = ruta;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
