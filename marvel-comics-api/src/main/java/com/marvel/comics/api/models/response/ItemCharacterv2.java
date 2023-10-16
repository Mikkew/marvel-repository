package com.marvel.comics.api.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "resourceURI", "name", "type" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCharacterv2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "resourceURI")
	private String resourceURI;

	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "type")
    private String type;
}
