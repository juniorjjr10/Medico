package com.Eldorado.ApiRest.medicos;

import com.Eldorado.ApiRest.Endereco.DadosEndereco;
import com.Eldorado.ApiRest.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialiade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;



    public Medico(DadosCadastraMedicos dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarinformacoes(DadosAtualizarMedicos dados) {
       if (dados.nome() != null) {
           this.nome = dados.nome();
       }
       if (dados.email() != null){
           this.email = dados.email();
       }
    }

    public void inativar() {
        this.ativo = false;

    }
}
