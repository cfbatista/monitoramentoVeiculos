package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Diandra Rocha
 */
@RunWith(MockitoJUnitRunner.class)
public class VeiculoServicoTest {

    @Mock
    private VeiculoRepositorio veiculoRepositorio;

    @InjectMocks
    private VeiculoServico veiculoServico;

    @Mock
    private Veiculo veiculo;

    private static final String PLACA = "ABCD-1234";

    @Before
    public void setUp() {
        when(veiculo.getPlaca()).thenReturn(PLACA);
        when(veiculo.getIdveiculo()).thenReturn(1L);
        when(veiculoRepositorio.findByPlacaIgnoreCase(PLACA)).thenReturn(veiculo);
    }

    @Test
    public void testObterTodosVeiculos() {
        final List<Veiculo> veiculos = Arrays.asList(veiculo);
        when(veiculoRepositorio.findAll()).thenReturn(veiculos);

        final List<Veiculo> obterTodosVeiculos = veiculoServico.obterTodosVeiculos();

        assertEquals(veiculos, obterTodosVeiculos);
        verify(veiculoRepositorio).findAll();
    }

    @Test
    public void testObterVeiculoPorId() throws MonitoramentoVeiculosException {
        when(veiculoRepositorio.findOne(1L)).thenReturn(veiculo);

        final Veiculo obterVeiculoPorId = veiculoServico.obterVeiculoPorId(1L);

        assertEquals(veiculo, obterVeiculoPorId);
        verify(veiculoRepositorio).findOne(1L);
    }

    @Test
    public void testObterVeiculoPorPlaca() throws MonitoramentoVeiculosException {

        final Veiculo obterVeiculoPorPlaca = veiculoServico.obterVeiculoPorPlaca(PLACA);

        assertEquals(veiculo, obterVeiculoPorPlaca);
        assertEquals(PLACA, obterVeiculoPorPlaca.getPlaca());
        verify(veiculoRepositorio).findByPlacaIgnoreCase(PLACA);
    }

}
