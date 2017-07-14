package br.com.crescer.monitorveiculos.seguranca;

import org.springframework.security.core.GrantedAuthority;

public enum MonitoramentoVeiculosRoles implements GrantedAuthority {
    ROLE_USUARIO, ROLE_ADMINISTRADOR, ROLE_AUTORIDADE;

    @Override
    public String getAuthority() {
        return toString();
    }

}
