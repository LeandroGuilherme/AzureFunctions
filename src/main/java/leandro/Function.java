package leandro;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;

import lombok.Data;

import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

    @FunctionName("helloserverless")
    public String hello(
            @HttpTrigger(
                    name = "hellorest",
                    methods = {HttpMethod.GET},
                    route = "hello"
            ) String x) {

        return "Hello REST World!";
    }

    @FunctionName("createfuncionario")
    public Funcionario create(
            @HttpTrigger(
                    name = "createfuncionariorest",
                    methods = {HttpMethod.POST},
                    route = "funcionario"
            ) Funcionario funcionario) {

        // Do something important
        // Some business rules
        funcionario.setId(UUID.randomUUID());
        
        FuncionarioDAO fundao = new FuncionarioDAO();
        fundao.create(funcionario);
        
        return funcionario;
    }

    @FunctionName("updatefuncionario")
    public Funcionario update(
            @HttpTrigger(
                    name = "updatefuncionariorest",
                    methods = {HttpMethod.PUT},
                    route = "funcionario"
            ) Funcionario funcionario) {

        FuncionarioDAO fundao = new FuncionarioDAO();
        fundao.update(funcionario);
        // Do some update ...

        //funcionario.setId(UUID.randomUUID());
        // funcionario.setNome(funcionario.getNome() + " - updated!");
        return funcionario;
    }

    @FunctionName("deletefuncionario")
    public Funcionario delete(
            @HttpTrigger(
                    name = "deletefuncionariorest",
                    methods = {HttpMethod.DELETE},
                    route = "funcionario"
            ) Funcionario funcionario) {

        FuncionarioDAO fundao = new FuncionarioDAO();
        fundao.delete(funcionario);
        // Do some delete ...

        //uncionario.setId(UUID.randomUUID());
        //funcionario.setNome(funcionario.getNome() + " - deleted!");
        return funcionario;
    }

    @FunctionName("buscafuncionario")
    public Funcionario busca(
            @HttpTrigger(
                    name = "buscafuncionariorest",
                    methods = {HttpMethod.GET},
                    route = "funcionario"
            ) Funcionario funcionario) {

        FuncionarioDAO fundao = new FuncionarioDAO();
        ArrayList<Funcionario> lista = fundao.busca(funcionario);
        // Do some search ...
        lista.forEach((_item) -> {
            System.out.println("ok" + lista);
        });

        //funcionario.setId(UUID.randomUUID());
        //funcionario.setNome(funcionario.getNome() + " - searched!");
        return funcionario;
    }
}

@Data
class Funcionario {

    private UUID id;
    private String nome;
    private int idade;
    private double salario;

}

class FuncionarioDAO {

    ArrayList<Funcionario> ListFuncionario = new ArrayList<>();

    public void create(Funcionario funcionario) {
        ListFuncionario.add(funcionario);
    }

    public ArrayList<Funcionario> busca(Funcionario funcionario) {

        for (int i = 0; i < ListFuncionario.size(); i++) {
            if (funcionario.getId() == ListFuncionario.get(i).getId()) {
                ListFuncionario.add(i, funcionario);
            }

        }

        return ListFuncionario;

    }

    public boolean update(Funcionario funcionario) {

        for (int i = 0; i < ListFuncionario.size(); i++) {
            if (funcionario.getId() == ListFuncionario.get(i).getId()) {
                ListFuncionario.add(i, funcionario);
            }

        }
        System.out.println("Atualizado");
        return true;
    }

    public boolean delete(Funcionario funcionario) {

        for (int i = 0; i < ListFuncionario.size(); i++) {
            if (funcionario.getId() == ListFuncionario.get(i).getId()) {
                ListFuncionario.remove(i);
            }

        }
        return true;
    }

}
