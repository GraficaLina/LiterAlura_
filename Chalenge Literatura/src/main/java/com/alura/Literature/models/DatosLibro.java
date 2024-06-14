package com.alura.Literature.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias ("title") String title,
        @JsonAlias("authors") List<DatosAutor> authors,
        @JsonAlias("languages")List<String> languages,
        @JsonAlias("download_count") Double numberOfDownloads
) {
    // Método para obtener el primer idioma de la lista
    public String getFirstLanguage() {
        return languages != null && !languages.isEmpty() ? languages.get(0) : null;
    }
}
