package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {
    
   @Query("select count(distinct ci.idcidade) from Camera ca inner join ca.idcidade ci") 
   public Long getNumeroCidadesComRegistros(); 
   
   @Query("SELECT nome from cidade inner join veiculo on cidade.idcidade = :cidadeVeiculo")
   Cidade getCidadeDoVeiculo(@Param("cidadeVeiculo") Long cidadeVeiculo);
}
