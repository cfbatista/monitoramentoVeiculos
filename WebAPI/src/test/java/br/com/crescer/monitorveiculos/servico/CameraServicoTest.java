package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
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
public class CameraServicoTest {

    @Mock
    private CameraRepositorio cameraRepositorio;

    @InjectMocks
    private CameraServico cameraServico;

    @Mock
    private Camera camera;

    @Before
    public void setUp() {
        when(camera.getIdcamera()).thenReturn(1L);
    }

    @Test
    public void testObterPotId() throws Exception {
        when(cameraRepositorio.findOne(1L)).thenReturn(camera);

        final Camera obterCameraPorId = cameraServico.obterPotId(1L);

        assertEquals(camera, obterCameraPorId);
        verify(cameraRepositorio).findOne(1L);
    }

    @Test
    public void testContagemTotal() {
        when(cameraRepositorio.count()).thenReturn(1L);

        final Long contagem = cameraServico.contagemTotal();
        final Long expected = 1L;

        assertEquals(expected, contagem);
        verify(cameraRepositorio).count();
    }

    @Test
    public void testObterTodas() {
        final List<Camera> cameras = Arrays.asList(camera);
        when(cameraRepositorio.findAll()).thenReturn(cameras);

        final List<Camera> obterTodasCameras = cameraServico.obterTodas();

        assertEquals(cameras, obterTodasCameras);
        verify(cameraRepositorio).findAll();
    }

}
