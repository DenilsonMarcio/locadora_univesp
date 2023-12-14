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
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
    private static final String PLATAFORMA_DEFAULT = "PLATAFORMA_DEFAULT";

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
        switch (plataforma) {
            case "MEGADRIVE":
                plataforma = TipoPlataforma.MEGADRIVE.getPlataforma();
                break;
            case "SEGA_SATURN":
                plataforma = TipoPlataforma.SEGA_SATURN.getPlataforma();
                break;
            case "PLAYSTATION":
                plataforma = TipoPlataforma.PLAYSTATION.getPlataforma();
                break;
            case "VIRTUAL_BOY":
                plataforma = TipoPlataforma.VIRTUAL_BOY.getPlataforma();
                break;
            case "NINTENDO_64":
                plataforma = TipoPlataforma.NINTENDO_64.getPlataforma();
                break;
            case "SUPER_NINTENDO":
                plataforma = TipoPlataforma.SUPER_NINTENDO.getPlataforma();
                break;
            case "NEO_GEO_POCKET":
                plataforma = TipoPlataforma.NEO_GEO_POCKET.getPlataforma();
                break;
            case "GAME_BOY_COLOR":
                plataforma = TipoPlataforma.GAME_BOY_COLOR.getPlataforma();
                break;
            default:
                plataforma = PLATAFORMA_DEFAULT;
        }
        return plataforma;
    }

    private String gerarCodigoJogo() {
        return "J-".concat(getRandomNumber().toString());
    }
    private String gerarCodigoFilme() {
        return "F-".concat(getRandomNumber().toString());
    }
    private Integer getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(10000, 100000);
    }
}
