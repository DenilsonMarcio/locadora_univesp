package br.com.moppahtech.locadora.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.model.enums.TipoClassificacao;
import br.com.moppahtech.locadora.service.ClassificacaoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassificacaoServiceImpl implements ClassificacaoService
{
    @Override
    public List<TipoClassificacao> listaClassificacoes()
    {
        return Arrays.asList(TipoClassificacao.values());
    }
}