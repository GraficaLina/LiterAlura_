package com.alura.Literature.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TodosDatos(
        @JsonAlias("results")List<DatosLibro> books
        ){

}
