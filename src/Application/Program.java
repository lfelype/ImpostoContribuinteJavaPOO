package Application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Contribuinte> list = new ArrayList<Contribuinte>();

        System.out.println("Entre com o número de contribuintes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Contribuinte #" + i + " data:");
            System.out.print("Pessoa fisica ou Pessoa Juridica (f/j)? ");
            char type = sc.next().charAt(0);
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Gastos anuais: ");
            Double rendaAnual = sc.nextDouble();
            if (type == 'f') {
                System.out.print("Gastos com saúde: ");
                Double gastosSaude = sc.nextDouble();
                list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            }
            else {
                System.out.print("Numero de funcionarios: ");
                Integer numeroFuncionarios = sc.nextInt();
                list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }
        System.out.println();
        System.out.println("Taxas pagas:");
        for (Contribuinte cont : list) {
            System.out.println(cont.getNome() + ": $ " + String.format("%.2f", cont.taxa()));
        }

        System.out.println();
        double soma = 0.0;
        for (Contribuinte cont : list) {
            soma += cont.taxa();
        }
        System.out.println("Taxas totais: $ " + String.format("%.2f", soma));

        sc.close();

    }
}
