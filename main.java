package com.sistemaveterinario.main;

import com.sistemaveterinario.model.Animal;
import com.sistemaveterinario.model.Cachorro;
import com.sistemaveterinario.model.Gato;
import com.sistemaveterinario.model.Ave;
import com.sistemaveterinario.model.AnimalExotico;
import com.sistemaveterinario.tratamentos.Consulta;
import com.sistemaveterinario.tratamentos.Cirurgia;
import com.sistemaveterinario.tratamentos.Fisioterapia;
import com.sistemaveterinario.tratamentos.MedicacaoContinua;
import com.sistemaveterinario.tratamentos.Tratamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaVeterinario {
    private static List<Animal> animais = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consulta consulta = new Consulta();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== Sistema de Gerenciamento de Clínica Veterinária ====");
            System.out.println("1. Cadastrar novo animal");
            System.out.println("2. Marcar consulta");
            System.out.println("3. Registrar tratamento");
            System.out.println("4. Exibir histórico de tratamentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAnimal(scanner);
                    break;
                case 2:
                    marcarConsulta(scanner, consulta);
                    break;
                case 3:
                    registrarTratamento(scanner);
                    break;
                case 4:
                    exibirHistoricoTratamentos(scanner);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void cadastrarAnimal(Scanner scanner) {
        System.out.print("Digite o nome do animal: ");
        String nome = scanner.next();
        System.out.print("Digite a espécie (Cachorro/Gato/Ave/Exotico): ");
        String especie = scanner.next();
        System.out.print("Digite a idade do animal: ");
        int idade = scanner.nextInt();
        System.out.print("Digite a raça do animal: ");
        String raca = scanner.next();
        System.out.print("Digite o peso do animal (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite o nome do tutor: ");
        String nomeTutor = scanner.next();

        Animal animal;

        switch (especie.toLowerCase()) {
            case "cachorro":
                animal = new Cachorro(nome, especie, idade, raca, peso, nomeTutor);
                break;
            case "gato":
                animal = new Gato(nome, especie, idade, raca, peso, nomeTutor);
                break;
            case "ave":
                animal = new Ave(nome, especie, idade, raca, peso, nomeTutor);
                break;
            case "exotico":
                animal = new AnimalExotico(nome, especie, idade, raca, peso, nomeTutor);
                break;
            default:
                System.out.println("Espécie inválida. Animal não cadastrado.");
                return;
        }

        animais.add(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void marcarConsulta(Scanner scanner, Consulta consulta) {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado!");
            return;
        }

        Animal animal = selecionarAnimal(scanner);

        System.out.println("1. Consulta de Rotina");
        System.out.println("2. Vacinação");
        System.out.println("3. Exame Específico");
        System.out.print("Escolha o tipo de consulta: ");
        int tipoConsulta = scanner.nextInt();

        switch (tipoConsulta) {
            case 1:
                consulta.consultaDeRotina(animal);
                break;
            case 2:
                consulta.vacinacao(animal);
                break;
            case 3:
                consulta.exameEspecifico(animal);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void registrarTratamento(Scanner scanner) {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado!");
            return;
        }

        Animal animal = selecionarAnimal(scanner);

        System.out.println("1. Cirurgia");
        System.out.println("2. Fisioterapia");
        System.out.println("3. Medicação contínua");
        System.out.print("Escolha o tratamento: ");
        int tipoTratamento = scanner.nextInt();

        Tratamento tratamento = null;
        switch (tipoTratamento) {
            case 1:
                tratamento = new Cirurgia();
                break;
            case 2:
                tratamento = new Fisioterapia();
                break;
            case 3:
                tratamento = new MedicacaoContinua();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        if (tratamento != null) {
            tratamento.realizarTratamento(animal);
        }
    }

    private static void exibirHistoricoTratamentos(Scanner scanner) {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado!");
            return;
        }

        Animal animal = selecionarAnimal(scanner);
        animal.exibirHistoricoTratamentos();
    }

    private static Animal selecionarAnimal(Scanner scanner) {
        System.out.println("Animais cadastrados:");
        for (int i = 0; i < animais.size(); i++) {
            System.out.println((i + 1) + ". " + animais.get(i).getNome() + " (" + animais.get(i).getEspecie() + ")");
        }
        System.out.print("Selecione o número do animal: ");
        int indiceAnimal = scanner.nextInt();

        if (indiceAnimal < 1 || indiceAnimal > animais.size()) {
            System.out.println("Animal inválido.");
            return null;
        }

        return animais.get(indiceAnimal - 1);
    }
}
