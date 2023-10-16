package com.marvel.comics.api.models.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParamsContext {
	
	private Optional<String> name;
	private Optional<String> nameStartsWith;
	private Optional<String> modifiedSince;
	private Optional<Integer> comics;
	private Optional<Integer> series;
	private Optional<Integer> events;
	private Optional<Integer> stories;
	private Optional<String> orderBy;
	private Optional<Integer> limit;
	private Optional<Integer> offset;
}
