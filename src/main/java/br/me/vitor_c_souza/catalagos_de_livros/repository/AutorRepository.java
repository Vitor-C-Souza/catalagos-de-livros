package br.me.vitor_c_souza.catalagos_de_livros.repository;

import br.me.vitor_c_souza.catalagos_de_livros.model.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutorRepository extends MongoRepository<Autor, String> {
}
