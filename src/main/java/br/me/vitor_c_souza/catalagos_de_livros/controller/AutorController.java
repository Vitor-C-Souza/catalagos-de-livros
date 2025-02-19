package br.me.vitor_c_souza.catalagos_de_livros.controller;

import br.me.vitor_c_souza.catalagos_de_livros.model.Autor;
import br.me.vitor_c_souza.catalagos_de_livros.service.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AutorController {
    @Autowired
    private GraphQLService graphQLService;

    @MutationMapping
    public Autor addAutor(@Argument String nome, @Argument String nacionalidade) {
        return graphQLService.addAutor(nome, nacionalidade);
    }

    @QueryMapping
    public Autor autor(@Argument String id) {
        return graphQLService.getAutorById(id);
    }

    @QueryMapping
    public List<Autor> autores() {
        return graphQLService.getAutores();
    }

    @MutationMapping
    public Autor updateAutor(@Argument String id, @Argument String nome, @Argument String nacionalidade) {

        return graphQLService.updateAutor(id, new Autor(nome, nacionalidade));
    }

    @MutationMapping
    public Boolean deletaAutor(@Argument String id) {
        return graphQLService.deleteAutor(id);
    }
}
