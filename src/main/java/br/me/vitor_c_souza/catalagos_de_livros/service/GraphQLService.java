package br.me.vitor_c_souza.catalagos_de_livros.service;

import br.me.vitor_c_souza.catalagos_de_livros.model.Autor;
import br.me.vitor_c_souza.catalagos_de_livros.model.Livro;
import br.me.vitor_c_souza.catalagos_de_livros.repository.AutorRepository;
import br.me.vitor_c_souza.catalagos_de_livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GraphQLService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    // Queries
    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(String id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(String id) {
        return autorRepository.findById(id).orElse(null);
    }

    // Mutações
    public Livro addLivro(String titulo, String genero, int anoPublicacao, String autorId) {
        Autor autor = autorRepository.findById(autorId).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        Livro livro = new Livro(titulo, genero, anoPublicacao);
        livro.setAutor(autor);
        return livroRepository.save(livro);
    }

    public Autor addAutor(String nome, String nacionalidade) {
        Autor autor = new Autor(nome, nacionalidade);
        return autorRepository.save(autor);
    }

    public Autor updateAutor(String id, Autor input) {
        return autorRepository.findById(id).map(autor -> {
            if (input.getNome() != null) autor.setNome(input.getNome());
            if (input.getNacionalidade() != null) autor.setNacionalidade(input.getNacionalidade());
            return autorRepository.save(autor);
        }).orElseThrow(() -> new NoSuchElementException("Nenhum autor encontrado!"));
    }

    public Livro updateLivro(String id, Livro input, String autorId) {
        if (autorId != null) {
            Autor autor = autorRepository.findById(autorId).orElse(null);
            input.setAutor(autor);
        }

        return livroRepository.findById(id).map(livro -> {
            if (input.getTitulo() != null) livro.setTitulo(input.getTitulo());
            if (input.getGenero() != null) livro.setGenero(input.getGenero());
            if (input.getAnoPublicacao() != null) livro.setAnoPublicacao(input.getAnoPublicacao());
            if (input.getAutor() != null) livro.setAutor(input.getAutor());
            return livroRepository.save(livro);
        }).orElseThrow(() -> new NoSuchElementException("Nenhum livro encontrado!"));
    }

    public Boolean deleteLivro(String id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean deleteAutor(String id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
