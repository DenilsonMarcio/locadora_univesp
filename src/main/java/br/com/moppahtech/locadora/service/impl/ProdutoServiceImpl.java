package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.model.dto.FilmeDTO;
import br.com.moppahtech.locadora.model.dto.JogoDTO;
import br.com.moppahtech.locadora.model.dto.RequestProdutosDTO;
import br.com.moppahtech.locadora.model.entities.FilmeModel;
import br.com.moppahtech.locadora.model.entities.JogoModel;
import br.com.moppahtech.locadora.model.enums.TipoPlataforma;
import br.com.moppahtech.locadora.repository.FilmeRepository;
import br.com.moppahtech.locadora.repository.JogoRepository;
import br.com.moppahtech.locadora.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private static final Integer SOMA_UM = 1;
    private static final String PLATAFORMA_DEFAULT = TipoPlataforma.NINTENDO_64.getPlataforma();

    private final JogoRepository jogoRepository;
    private final FilmeRepository filmeRepository;
    @Override
    public void persistirProdutos(RequestProdutosDTO produtosDTO) {

        List<JogoDTO> jogos = produtosDTO.getJogos();
        if (nonNull(jogos)){
            for (JogoDTO jogo : jogos ){
                JogoModel model = JogoModel.builder()
                        .codigo(gerarCodigoJogo())
                        .name(jogo.getName())
                        .classificacao(jogo.getClassificacao())
                        .lancamento(jogo.getLancamento())
                        .produtora(jogo.getProdutora())
                        .genero(jogo.getGenero())
                        .quantidade(jogo.getQuantidade())
                        .preco(jogo.getPreco())
                        .plataforma(validatedPlataforma(jogo.getPlataforma()))
                        .build();
                jogoRepository.save(model);
            }
        }

        List<FilmeDTO> filmes = produtosDTO.getFilmes();
        if (nonNull(filmes)){
            for (FilmeDTO filme : filmes ){
                FilmeModel model = FilmeModel.builder()
                        .codigo(gerarCodigoFilme())
                        .name(filme.getName())
                        .classificacao(filme.getClassificacao())
                        .lancamento(filme.getLancamento())
                        .produtora(filme.getProdutora())
                        .genero(filme.getGenero())
                        .quantidade(filme.getQuantidade())
                        .preco(filme.getPreco())
                        .idioma(filme.getIdioma())
                        .diretor(filme.getDiretor())
                        .build();
                filmeRepository.save(model);
            }
        }
    }


    private String validatedPlataforma(String plataforma) {

        //TODO Validar utilização do Enum de Plataforma

        return (TipoPlataforma.PLAYSTATION.getPlataforma() == plataforma ? TipoPlataforma.PLAYSTATION.getPlataforma() : PLATAFORMA_DEFAULT);
    }

    private Integer gerarCodigoJogo() {
        return jogoRepository.gerarCodigoJogo() + SOMA_UM;
    }
    private Integer gerarCodigoFilme() {
        return filmeRepository.gerarCodigoFilme() + SOMA_UM;
    }
}
