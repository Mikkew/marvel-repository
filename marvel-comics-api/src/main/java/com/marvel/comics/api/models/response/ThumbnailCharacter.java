package com.marvel.comics.api.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "path", "extension" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThumbnailCharacter implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "path")
	private String path;

	@JsonProperty(value = "extension")
	private String extension;
}
