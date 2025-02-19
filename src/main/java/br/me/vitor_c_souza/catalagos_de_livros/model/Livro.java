package br.me.vitor_c_souza.catalagos_de_livros.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "livros")
public class Livro {
    @Id
    private String id;
    private String titulo;
    private String genero;
    private Integer anoPublicacao;
    @DBRef
    private Autor autor;

    public Livro(String titulo, String genero, Integer anoPublicacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
    }
}
