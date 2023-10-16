package com.marvel.comics.api.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "code", "status", "copyright", "attributionText", "attributionHTML", "etag", "data" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCharacter implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "code")
	private Integer code;

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "copyright")
	private String copyright;

	@JsonProperty(value = "attributionText")
	private String attributionText;

	@JsonProperty(value = "attributionHTML")
	private String attributionHTML;

	@JsonProperty(value = "etag")
	private String etag;

	@JsonProperty(value = "data")
	@Valid
	private DataCharacter data;
}
