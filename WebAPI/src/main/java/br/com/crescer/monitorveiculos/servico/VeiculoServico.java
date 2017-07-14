package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.modelo.ConsultaVeiculosModel;
import br.com.crescer.monitorveiculos.repositorio.OcorrenciaRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class VeiculoServico {

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;
    @Autowired
    private RegistroRepositorio registroRepositorio;
    @Autowired
    private OcorrenciaRepositorio ocorrenciaRepositorio;

    public List<Veiculo> obterTodosVeiculos() {
        return (List<Veiculo>) veiculoRepositorio.findAll();
    }

    public Long totalVeiculos() {
        return veiculoRepositorio.count();
    }

    public Veiculo obterVeiculoPorId(Long id) {
        return veiculoRepositorio.findOne(id);
    }

    public Veiculo obterVeiculoPorPlaca(String placa) {
        return veiculoRepositorio.findByPlacaIgnoreCase(placa);
    }

    public Long obterNumeroOcorrencias(Veiculo veiculo) {
        return ocorrenciaRepositorio.countByVeiculo(veiculo);
    }

    public Long buscarNumeroRegistros(String placa) {
        return registroRepositorio.countByPlaca(placa);
    }

    public Long obterNumeroeRegistrosPorCamera(String placa) {
        return registroRepositorio.obterNumeroDeCamerasComRegistros(placa);
    }

    public Long obterNumeroDeVezesQuePassouVelocidade(String placa) {
        return registroRepositorio.obterNumeroDeVezesQuePassouVelocidade(placa);
    }

    public ConsultaVeiculosModel realizarBusca(String placa) {

        ConsultaVeiculosModel retorno = new ConsultaVeiculosModel();
        Veiculo veiculo = obterVeiculoPorPlaca(placa);

        retorno.setTotalOcorrencias(obterNumeroOcorrencias(veiculo));
        retorno.setTotalRegistros(buscarNumeroRegistros(placa));
        retorno.setQuantidadeCameras(obterNumeroeRegistrosPorCamera(placa));
        retorno.setCidadeVeiculo(veiculo.getCidade());
        retorno.setVezesUltrapassouLimite(obterNumeroDeVezesQuePassouVelocidade(placa));
        retorno.setNumeroDiasNoutraCidade(registroRepositorio.obterNumeroVezesVeiculoForaSuaCidade(placa, pegarPrimeiroDiaMes(), pegarUltimoDiaMes()));
        return retorno;
    }

    public Date pegarPrimeiroDiaMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public Date pegarUltimoDiaMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
}
