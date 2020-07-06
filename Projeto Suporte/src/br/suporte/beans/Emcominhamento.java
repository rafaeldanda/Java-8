package br.suporte.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tblEmcominhamento")
@XmlRootElement
public class Emcominhamento implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_ENCAMINHAMENTO",sequenceName="SEQ_ENCAMINHAMENTO_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_ENCAMINHAMENTO", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50,nullable=true)
    private String encaminhadoPara;
    
   
    @Temporal(TemporalType.DATE)
    private Calendar dataEncaminhamento;
    
    @Column(length=50,nullable=true)
    private String encaminhadoDe;
    
    
    @ManyToMany
    @JoinTable(name = "tblemcominhamento_tblpessoafisica",
            joinColumns = @JoinColumn(name = "listaencaminhamento_id"),
            inverseJoinColumns = @JoinColumn(name = "listapessoafisica_id"))
    private List<PessoaFisica> listaPessoaFisica;
    

    public Emcominhamento() {
    }

    public Calendar getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(Calendar dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public String getEncaminhadoDe() {
        return encaminhadoDe;
    }

    public void setEncaminhadoDe(String encaminhadoDe) {
        this.encaminhadoDe = encaminhadoDe;
    }

    public String getEncaminhadoPara() {
        return encaminhadoPara;
    }

    public void setEncaminhadoPara(String encaminhadoPara) {
        this.encaminhadoPara = encaminhadoPara;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PessoaFisica> getListaPessoa() {
        return listaPessoaFisica;
    }

    public void setListaPessoa(List<PessoaFisica> listaPessoaFisica) {
        this.listaPessoaFisica = listaPessoaFisica;
    }

   
    
    
}
