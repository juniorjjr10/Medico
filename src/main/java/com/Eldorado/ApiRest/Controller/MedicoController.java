package com.Eldorado.ApiRest.Controller;

import com.Eldorado.ApiRest.medicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastramedicos(@RequestBody @Valid DadosCadastraMedicos dados) {

        repository.save(new Medico(dados));


    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicos::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarinformacoes(dados);


    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedicos( @PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.inativar();



    }
}