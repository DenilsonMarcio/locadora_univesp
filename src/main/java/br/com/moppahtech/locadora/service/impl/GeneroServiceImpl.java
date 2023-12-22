package br.com.moppahtech.locadora.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.model.enums.TipoGenero;
import br.com.moppahtech.locadora.service.GeneroService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService
{
    @Override
    public List<TipoGenero> listaGeneros()
    {
        return Arrays.asList(TipoGenero.values());
    }    
}
