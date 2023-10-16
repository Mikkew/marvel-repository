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

@JsonPropertyOrder({ "offset", "limit", "total", "count", "results" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataCharacter implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "offset")
	private Integer offset;

	@JsonProperty(value = "limit")
	private Integer limit;

	@JsonProperty(value = "total")
	private Integer total;

	@JsonProperty(value = "count")
	private Integer count;

	@JsonProperty(value = "results")
	@Valid
	private List<ResultCharacter> results;
}
