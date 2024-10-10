package com.sistemaveterinario.tratamentos;

import com.sistemaveterinario.model.Animal;

public class MedicacaoContinua implements Tratamento {
    private double custo = 100.0;  // Definindo o custo da medicação contínua

    @Override
    public void realizarTratamento(Animal animal) {
        System.out.println("Aplicando medicação contínua no animal: " + animal.getNome());
        animal.adicionarTratamento("Medicação contínua", custo);
    }
}

