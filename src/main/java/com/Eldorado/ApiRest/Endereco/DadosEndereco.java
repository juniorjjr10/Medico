package com.Eldorado.ApiRest.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(


        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String numero,
        @NotBlank
        String uf,
        String Complemento) {


}
