package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.Estado;
import com.example.Cidade;


public class Function {
    
    @FunctionName("funcaocriarcidade")
    public Cidade criar(@HttpTrigger (
    name = "restcriarcidade",
    methods = {HttpMethod.POST},
    route = "cidade"
    )Cidade c ) {
        
        c.setId(new Long(1));
        
        
        return c;
    }
    
    @FunctionName("funcaolercidade")
    public List<Cidade> ler(@HttpTrigger (
    name = "restlercidade",
    methods = {HttpMethod.GET},
    route = "cidade"
    )String x ) {
        
        Estado sp = new Estado(1, "São Paulo");
        Estado pr = new Estado(2, "Paraná");
        Estado sc = new Estado(3, "Santa Catarina");
        
        return Stream.of(
            new Cidade(new Long(1), "Praia Grande", sp),
            new Cidade(new Long(5), "Cornelio Procopio", pr),
            new Cidade(new Long(10), "Florianópolis", sc)               
        ).collect(Collectors.toList());
 
    }
    
    @FunctionName("funcaoalterarcidade")
    public Cidade alterar(@HttpTrigger (
    name = "restalterarcidade",
    methods = {HttpMethod.PUT},
    route = "cidade"
    )Cidade c ) {
        
        c.setNome(c.getNome() + "Tops");
        
        
        return c;
    }
    
     
    @FunctionName("funcaodeletarcidade")
    public int deletar(@HttpTrigger (
    name = "restdeletarcidade",
    methods = {HttpMethod.DELETE},
    route = "cidade/{id}"
    )@BindingName("id") Long id) {
        
        System.out.println(String.format("Id: %d", id));
    
        return 200;
    }
    
    
}