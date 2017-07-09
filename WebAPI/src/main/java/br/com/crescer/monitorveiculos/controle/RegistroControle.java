package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
@RequestMapping("/registro")
public class RegistroControle {
    
    @Autowired
    RegistroRepositorio registroService;
    
    @GetMapping
    public long Teste(@PathVariable long id) {
        return registroService.buscarPorRegistros(id);
    }
}
