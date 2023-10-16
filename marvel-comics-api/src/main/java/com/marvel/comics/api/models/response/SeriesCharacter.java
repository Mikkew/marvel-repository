package com.marvel.comics.api.models.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "available", "collectionURI", "items", "returned" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesCharacter implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "available")
	private Integer available;

	@JsonProperty(value = "collectionURI")
	private String collectionURI;

	@JsonProperty(value = "items")
	@Valid
	private List<ItemCharacterv1> items;

	@JsonProperty(value = "returned")
	private Integer returned;
}
