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
    
   @Query("select COUNT(distinct ci.idcidade) FROM Camera ca INNER JOIN ca.idcidade ci") 
   public Long getNumeroCidadesComRegistros(); 
   
//   @Query("SELECT c.nome FROM Cidade c INNER JOIN Veiculo WHERE cidade.idcidade = :cidadeVeiculo")
//   Cidade getCidadeDoVeiculo(@Param("cidadeVeiculo") Long cidadeVeiculo);
}
