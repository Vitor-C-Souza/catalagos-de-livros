package br.me.vitor_c_souza.catalagos_de_livros.controller;

import br.me.vitor_c_souza.catalagos_de_livros.model.Livro;
import br.me.vitor_c_souza.catalagos_de_livros.service.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LivroController {
    @Autowired
    private GraphQLService graphQLService;

    @MutationMapping
    public Livro addLivro(
            @Argument String titulo,
            @Argument String genero,
            @Argument int anoPublicacao,
            @Argument String autorId
    ) {
        return graphQLService.addLivro(titulo, genero, anoPublicacao, autorId);
    }

    @QueryMapping
    public Livro livro(@Argument String id) {
        return graphQLService.getLivroById(id);
    }

    @QueryMapping
    public List<Livro> livros() {
        return graphQLService.getLivros();
    }

    @MutationMapping
    public Livro updateLivro(@Argument String id, @Argument String titulo, @Argument String genero, @Argument Integer anoPublicacao, @Argument String autorId) {

        return graphQLService.updateLivro(id, new Livro(titulo, genero, anoPublicacao), autorId);
    }

    @MutationMapping
    public Boolean deletaLivro(@Argument String id) {
        return graphQLService.deleteLivro(id);
    }
}
