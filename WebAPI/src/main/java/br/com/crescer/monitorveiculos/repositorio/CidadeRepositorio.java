package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {
    
   @Query("SELECT COUNT(DISTINCT ci.idcidade) "
           + "FROM Camera ca INNER JOIN ca.idcidade ci") 
   public Long getNumeroCidadesComRegistros(); 

}
