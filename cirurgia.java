package com.sistemaveterinario.tratamentos;

import com.sistemaveterinario.model.Animal;

public class Cirurgia implements Tratamento {
    private double custo = 500.0;  // Definindo o custo da cirurgia

    @Override
    public void realizarTratamento(Animal animal) {
        System.out.println("Realizando cirurgia no animal: " + animal.getNome());
        animal.adicionarTratamento("Cirurgia", custo);
    }
}
