package com.sistemaveterinario.tratamentos;

import com.sistemaveterinario.model.Animal;

public class Fisioterapia implements Tratamento {
    private double custo = 200.0;  // Definindo o custo da fisioterapia

    @Override
    public void realizarTratamento(Animal animal) {
        System.out.println("Realizando fisioterapia no animal: " + animal.getNome());
        animal.adicionarTratamento("Fisioterapia", custo);
    }
}
