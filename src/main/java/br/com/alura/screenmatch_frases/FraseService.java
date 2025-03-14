package br.com.alura.screenmatch_frases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obterFraseAleatoria() {
        // Obtendo todas as frases do banco de dados
        List<Frase> frases = repositorio.findAll();

        // Se não houver nenhuma frase no banco de dados, lançar uma exceção ou retornar um valor padrão
        if (frases.isEmpty()) {
            throw new RuntimeException("Nenhuma frase encontrada.");
        }

        // Gerando um índice aleatório
        Random random = new Random();
        Frase fraseAleatoria = frases.get(random.nextInt(frases.size()));

        // Convertendo a entidade Frase para FraseDTO e retornando
        return new FraseDTO(fraseAleatoria.getTitulo(), fraseAleatoria.getFrase(), fraseAleatoria.getPersonagem(), fraseAleatoria.getPoster());
    }
}
