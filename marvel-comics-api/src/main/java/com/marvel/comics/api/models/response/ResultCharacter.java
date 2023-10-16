package com.marvel.comics.api.models.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultCharacter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
    private Integer id;
	
    @JsonProperty(value = "name")
    private String name;
    
    @JsonProperty(value = "description")
    private String description;
    
    @JsonProperty(value = "modified")
    private String modified;
    
    @JsonProperty(value = "thumbnail")
    @Valid
    private ThumbnailCharacter thumbnail;
    
    @JsonProperty(value = "resourceURI")
    private String resourceURI;
    
    @JsonProperty(value = "comics")
    @Valid
    private ComicsCharacter comics;
    
    @JsonProperty(value = "series")
    @Valid
    private SeriesCharacter series;
    
    @JsonProperty(value = "stories")
    @Valid
    private StoriesCharacter stories;
    
    @JsonProperty(value = "events")
    @Valid
    private EventsCharacter events;
    
    @JsonProperty(value = "urls")
    @Valid
    private List<UrlCharacter> urls;
}
