package com.sistemaveterinario.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private String raca;
    private double peso;
    private String nomeTutor;
    private List<String> historicoTratamentos;
    private double totalDespesas;  // Novo atributo para calcular o custo total dos serviços

    public Animal(String nome, String especie, int idade, String raca, double peso, String nomeTutor) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.raca = raca;
        this.peso = peso;
        this.nomeTutor = nomeTutor;
        this.historicoTratamentos = new ArrayList<>();
        this.totalDespesas = 0.0;  // Inicializa o total de despesas
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public int getIdade() {
        return idade;
    }

    public String getRaca() {
        return raca;
    }

    public double getPeso() {
        return peso;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public List<String> getHistoricoTratamentos() {
        return historicoTratamentos;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Idade: " + idade);
        System.out.println("Raça: " + raca);
        System.out.println("Peso: " + peso);
        System.out.println("Nome do Tutor: " + nomeTutor);
    }

    public void atualizarPeso(double novoPeso) {
        this.peso = novoPeso;
        System.out.println("Peso atualizado para: " + peso + " kg");
    }

    public void adicionarTratamento(String tratamento, double custo) {
        historicoTratamentos.add(tratamento);
        totalDespesas += custo;  // Adiciona o custo ao total de despesas
        System.out.println("Tratamento '" + tratamento + "' adicionado ao histórico com custo de R$" + custo);
    }

    public void exibirHistoricoTratamentos() {
        System.out.println("Histórico de tratamentos de " + nome + ":");
        for (String tratamento : historicoTratamentos) {
            System.out.println("- " + tratamento);
        }
        System.out.println("Total gasto com tratamentos: R$" + totalDespesas);
    }
}
