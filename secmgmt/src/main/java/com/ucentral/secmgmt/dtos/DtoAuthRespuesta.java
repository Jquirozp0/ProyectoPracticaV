package com.ucentral.secmgmt.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DtoAuthRespuesta {
    private String accessToken;
    private Long idRole;
    private String tokenType = "Bearer ";

    public DtoAuthRespuesta(String accessToken, Long idRole) {
        this.accessToken = accessToken;
        this.idRole = idRole;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getRoleId() {
        return this.idRole;
    }

    public void setRoleId(Long idRole) {
        this.idRole = idRole;
    }
}
