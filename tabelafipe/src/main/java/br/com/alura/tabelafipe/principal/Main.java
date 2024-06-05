package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.DadosAutomovel;
import br.com.alura.tabelafipe.model.ModelosMarca;
import br.com.alura.tabelafipe.model.Veiculo;
import br.com.alura.tabelafipe.service.ConsumoApi;
import br.com.alura.tabelafipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner leia = new Scanner(System.in);
    private final String ENDERECO="https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor= new ConverteDados();
    public void exibeMenu() {
        System.out.println(
                "**** OPÇÕES ****\n"+
                "Carros\n"+
                "Motos\n"+ "Caminhões\n"
        );
        String op = leia.nextLine();
        var json=consumo.obterDados(ENDERECO+op.toLowerCase()+"/marcas");
//        System.out.println(json);
        var dados= (conversor.obterLista(json, DadosAutomovel.class));
        dados.stream()
                .sorted(Comparator.comparing(DadosAutomovel::marca))
                .forEach(System.out::println);


        System.out.println("Digite o código da marca");
        String cod= leia.nextLine();
        json=consumo.obterDados(ENDERECO+op.toLowerCase()+"/marcas/"+cod+"/modelos");
        var modelosMarca=conversor.obterDados(json, ModelosMarca.class);
        System.out.println("Veja os modelos da marca escolhida:");
        modelosMarca.modelos().stream()
                .sorted(Comparator.comparing(DadosAutomovel::marca))
                .forEach(System.out::println);

        System.out.println("Digite o nome do carro a ser buscado");
        String buscaModelo= leia.nextLine();

        List<DadosAutomovel> modelosFiltrados = modelosMarca.modelos().stream()
                .filter(m->m.marca().toLowerCase().contains(buscaModelo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Modelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação");
        var codModelo =leia.nextLine();

        json=consumo.obterDados(ENDERECO+op.toLowerCase()+"/marcas/"+cod+"/modelos/"+codModelo+"/anos");
//        System.out.println(json);
        List<DadosAutomovel>anos=conversor.obterLista(json,DadosAutomovel.class);
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i =0; i<anos.size();i++){
            json=consumo.obterDados(ENDERECO+op.toLowerCase()+"/marcas/"+cod+"/modelos/"+codModelo+"/anos/"+anos.get(i).codigo());
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println("Veja os anos do modelo escolhido:");
        veiculos.forEach(System.out::println);

    }


}
