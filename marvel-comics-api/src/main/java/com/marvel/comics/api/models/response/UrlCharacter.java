package com.marvel.comics.api.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "type", "url" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlCharacter implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "url")
	private String url;

}
