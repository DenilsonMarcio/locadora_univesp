package br.com.moppahtech.locadora.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.model.enums.TipoPlataforma;
import br.com.moppahtech.locadora.service.PlataformaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlataformaServiceImpl implements PlataformaService
{
    @Override
    public List<TipoPlataforma> listaPlataformas()
    {
        return Arrays.asList(TipoPlataforma.values());
    }    
}
