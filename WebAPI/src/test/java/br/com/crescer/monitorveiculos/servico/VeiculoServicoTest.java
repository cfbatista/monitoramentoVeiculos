package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Diandra Rocha
 */
public class VeiculoServicoTest {

    @Mock
    private VeiculoRepositorio veiculoRepositorio;

    @InjectMocks
    private VeiculoServico veiculoServico;

    @Mock
    private Veiculo veiculo;

    @Mock
    private List<Veiculo> veiculos;

    @Before
    public void setUp() {
        veiculo = Veiculo.builder().placa("ABCD-1234").idveiculo(1L).build();
        when(veiculoRepositorio.findByPlacaIgnoreCase("ABCD-1234")).thenReturn(veiculo);
        when(veiculoRepositorio.findOne(1L)).thenReturn(veiculo);
        when(veiculoRepositorio.findAll()).thenReturn(veiculos);
    }

    @Ignore
    @Test
    public void testObterTodosVeiculos() {
        assertEquals(veiculos, veiculoServico.obterTodosVeiculos());
        verify(veiculoRepositorio).findAll();
    }

    @Ignore
    @Test
    public void testObterVeiculoPorId() {
        assertEquals(veiculo, veiculoServico.obterVeiculoPorId(1L));
        verify(veiculoRepositorio).findOne(1L);
    }

    @Ignore
    @Test
    public void testObterVeiculoPorPlaca() {
        assertEquals(veiculo, veiculoServico.obterVeiculoPorPlaca("ABCD-1234"));
        verify(veiculoRepositorio).findByPlacaIgnoreCase("ABCD-1234");
    }

}
