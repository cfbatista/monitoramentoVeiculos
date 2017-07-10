/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitorveiculos.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoControle {
    
    @Autowired
    private VeiculoServico veiculoServico;
    
    @GetMapping
    public Iterable<Veiculo> pegarVeiculos(){
        return veiculoServico.listarVeiculos();
    }
}
