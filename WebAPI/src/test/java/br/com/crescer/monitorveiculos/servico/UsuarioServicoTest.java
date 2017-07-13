package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.repositorio.UsuarioRepositorio;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
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
public class UsuarioServicoTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    private UsuarioServico usuarioServico;

    @Mock
    private Usuario usuario;

    @Before
    public void setUp() {
        when(usuarioRepositorio.findByEmail("mock@mock.com")).thenReturn(usuario);
        when(usuarioRepositorio.save(usuario)).thenReturn(usuario);
    }

    @Ignore
    @Test
    public void testFindByEmail() {
        assertEquals(usuario, usuarioServico.findByEmail("mock@mock.com"));
        verify(usuarioRepositorio).findByEmail("mock@mock.com");
    }

    @Ignore
    @Test
    public void testSave() throws MonitoramentoVeiculosException {
        assertEquals(usuario, usuarioServico.save(usuario));
        verify(usuarioRepositorio).save(usuario);
    }

}
