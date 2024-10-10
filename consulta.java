package com.sistemaveterinario.tratamentos;

import com.sistemaveterinario.model.Animal;

public class Consulta {
    private double custoConsultaRotina = 150.0;
    private double custoVacinacao = 75.0;
    private double custoExameEspecifico = 300.0;

    public void consultaDeRotina(Animal animal) {
        System.out.println("Consulta de rotina para " + animal.getNome());
        animal.adicionarTratamento("Consulta de Rotina", custoConsultaRotina);
    }

    public void vacinacao(Animal animal) {
        System.out.println("Vacinação do " + animal.getNome());
        animal.adicionarTratamento("Vacinação", custoVacinacao);
    }

    public void exameEspecifico(Animal animal) {
        System.out.println("Exame específico para " + animal.getNome());
        animal.adicionarTratamento("Exame Específico", custoExameEspecifico);
    }
}
