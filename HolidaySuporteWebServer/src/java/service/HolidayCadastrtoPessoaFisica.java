/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import br.suporte.beans.Cidade;
import br.suporte.beans.Perfil;
import br.suporte.beans.PessoaFisica;
import br.suporte.beans.PessoaJuridica;
import br.suporte.beans.Sistema;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import downs.DownCadastros;
import java.lang.reflect.Type;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import testes.Cidadee;
import testes.Perfill;
import testes.PessoaJuridicaa;
import testes.PessoaFisicaa;
import testes.Sistemaa;

/**
 * REST Web Service
 *
 * @author rafael
 */
@Path("HolidayCadastrtoPessoaFisica")
public class HolidayCadastrtoPessoaFisica {
    
    private Cidadee cidadee = new Cidadee();
    private Perfill perfill = new Perfill();
    private Sistemaa sistemaa = new Sistemaa();
    private PessoaFisicaa pessoaa = new PessoaFisicaa();
    private PessoaJuridicaa pessoaJuridicaa = new PessoaJuridicaa();
    private Gson g = new Gson();
    private PessoaFisica pessoa = new PessoaFisica();
    private PessoaJuridica pessoaJuridica = new PessoaJuridica();
    private Cidade cidade = new Cidade();
    private Perfil perfil = new Perfil();
    private Sistema sistema = new Sistema();
    private DownCadastros downCadastro = new DownCadastros();
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HolidayCadastrtoPessoaFisica
     */
    public HolidayCadastrtoPessoaFisica() {
    }

    /**
     * Retrieves representation of an instance of service.HolidayCadastrtoPessoaFisica
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of HolidayCadastrtoPessoaFisica
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        try {
            /*cidadee = new Cidadee(1, "Porto Alegre");
            perfill = new Perfill(1, "Cliente", Boolean.TRUE);
            sistemaa = new Sistemaa(1, "Take me", Boolean.TRUE);
            pessoaJuridicaa.setId(1);
            pessoaa = new PessoaFisicaa(1,"Rafael Danda", "rafaeldanda@gmail.com", "1234", Boolean.TRUE, cidadee, perfill,pessoaJuridicaa);
            
            System.out.println(g.toJson(pessoaa));*/
            
            //retorna Json em Objeto de novo
            Type estadoType = new TypeToken<PessoaFisicaa>() {
            }.getType();
            pessoaa = g.fromJson(content, estadoType);
            
            this.cadastraPessoa(pessoaa);
            
            return "Sucesso!";
            
        } catch (Exception e) {
            System.err.println("Log ------- " + e.getMessage());
        }
        return "fail";
    }
    
    private void cadastraPessoa(PessoaFisicaa pessoaa) throws Exception {
        
        this.cidade.setId(pessoaa.getCidade().getId());
        this.cidade.setNome(pessoaa.getCidade().getNome());
        
        this.perfil.setId(pessoaa.getPerfil().getId());
        this.perfil.setNome(pessoaa.getPerfil().getNome());
        this.perfil.setStatus(pessoaa.getPerfil().getStatus());
        
        this.sistema.setId(1);
        this.pessoaJuridica.setId(pessoaa.getPessoaJuridica().getId());
        
        this.pessoa.setId(pessoaa.getId());
        this.pessoa.setNome(pessoaa.getNome());
        this.pessoa.setEmail(pessoaa.getEmail());
        this.pessoa.setSenha(pessoaa.getSenha());
        this.pessoa.setCidade(cidade);
        this.pessoa.setPerfil(perfil);
        this.pessoa.setPessoaJuridica(pessoaJuridica);
        
        
        downCadastro.cadastrarAlterar(this.pessoa);
        
        
    }
}
