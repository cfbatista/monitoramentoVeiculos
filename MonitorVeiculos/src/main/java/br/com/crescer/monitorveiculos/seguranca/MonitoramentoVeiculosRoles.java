package br.com.crescer.monitorveiculos.seguranca;

import org.springframework.security.core.GrantedAuthority;

public enum MonitoramentoVeiculosRoles implements GrantedAuthority {
    USUARIO, ADMINISTRADOR, AUTORIDADE;

    @Override
    public String getAuthority() {
        return toString();
    }

}
