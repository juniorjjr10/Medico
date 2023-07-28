package com.Eldorado.ApiRest.medicos;

public record DadosListagemMedicos( Long id,String nome, String email, String crm, Especialiade especialiade) {
    public DadosListagemMedicos(Medico medico){
        this( medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());

    }
}
