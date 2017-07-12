package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.servico.RegistroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
@RequestMapping(value = "/registro")
public class RegistroControle {

    @Autowired
    RegistroServico registroService;

}
