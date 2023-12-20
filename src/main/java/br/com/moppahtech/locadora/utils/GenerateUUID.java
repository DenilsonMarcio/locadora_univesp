package br.com.moppahtech.locadora.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class GenerateUUID {
    public String get(){
        return UUID.randomUUID().toString();
    }
}
