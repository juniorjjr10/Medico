package com.Eldorado.ApiRest.medicos;

import com.Eldorado.ApiRest.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedicos(
       @NotNull
        Long id,
        String nome,
        String email,
        DadosEndereco endereco) {


}
