package br.com.moppahtech.locadora.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.model.enums.TipoPreco;
import br.com.moppahtech.locadora.service.PrecoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrecoServiceImpl implements PrecoService
{
    @Override
    public List<TipoPreco> listaPrecos()
    {
        return Arrays.asList(TipoPreco.values());
    }
}