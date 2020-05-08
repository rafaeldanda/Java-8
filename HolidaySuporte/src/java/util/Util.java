/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import br.suporte.beans.PessoaFisica;
import java.util.InputMismatchException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael
 */
public class Util {

    private FacesContext fc;
    private HttpSession session;
    PessoaFisica p = new PessoaFisica();

    public PessoaFisica retornaSessao() {
        fc = FacesContext.getCurrentInstance();
        session = (HttpSession) fc.getExternalContext().getSession(false);
        return (PessoaFisica) session.getAttribute("autenticacao");

    }

    public void mataSessao() {
        fc = FacesContext.getCurrentInstance();
        session = (HttpSession) fc.getExternalContext().getSession(false);
        session.getAttribute("autenticacao");
        session.invalidate();

    }

    public Boolean validaCpf(String cpf) throws Exception {

        int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
        int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
        String strDigitoVerificador, strDigitoResultado;

        cpf = cpf.replace('.', ' ');
        cpf = cpf.replace('-', ' ');
        cpf = cpf.replaceAll(" ", "");

        if (!cpf.substring(0, 1).equals("") && !cpf.equals("00000000000")
            && !cpf.equals("11111111111") && !cpf.equals("22222222222") 
            && !cpf.equals("33333333333") && !cpf.equals("44444444444")
            && !cpf.equals("55555555555") && !cpf.equals("66666666666")
            && !cpf.equals("88888888888") && !cpf.equals("77777777777")
            && !cpf.equals("99999999999")) {

            for (int iCont = 1; iCont < cpf.length() - 1; iCont++) {
                iDigitoCPF = Integer.valueOf(cpf.substring(iCont - 1, iCont)).intValue();
                iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
                iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
            }
            iRestoDivisao = (iDigito1Aux % 11);
            if (iRestoDivisao < 2) {
                iDigito1 = 0;
            } else {
                iDigito1 = 11 - iRestoDivisao;
            }
            iDigito2Aux += 2 * iDigito1;
            iRestoDivisao = (iDigito2Aux % 11);
            if (iRestoDivisao < 2) {
                iDigito2 = 0;
            } else {
                iDigito2 = 11 - iRestoDivisao;
            }
            strDigitoVerificador = cpf.substring(cpf.length() - 2, cpf.length());
            strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
            if (strDigitoVerificador.equals(strDigitoResultado)) {
                return true;
            } else {
                FacesMessage msg = new FacesMessage("Aviso:", "CPF inválido.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return false;
            }

        } else {
            FacesMessage msg = new FacesMessage("Aviso:", "CPF inválido.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return false;
        }


    }

    public Boolean validaCNPJ(String cnpj) throws Exception {

        String str_cnpj = cnpj.toString().replace("-", "").trim();
        str_cnpj = str_cnpj.replace("/", "").trim();
        str_cnpj = str_cnpj.replace(".", "").trim();

        int soma = 0;
        String cnpj_calc = str_cnpj.substring(0, 12);

        if (str_cnpj.length() != 14) {
            FacesMessage msg = new FacesMessage("Aviso:", "CNPJ inválido.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return false;
        }
        char[] chr_cnpj = str_cnpj.toCharArray();

        for (int i = 0; i < 4; i++) {
            if ((chr_cnpj[i] - '0' >= 0) && (chr_cnpj[i] - '0' <= 9)) {
                soma += (chr_cnpj[i] - '0') * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if ((chr_cnpj[(i + 4)] - '0' >= 0) && (chr_cnpj[(i + 4)] - '0' <= 9)) {
                soma += (chr_cnpj[(i + 4)] - '0') * (10 - (i + 1));
            }
        }
        int dig = 11 - soma % 11;

        cnpj_calc = cnpj_calc + ((dig == 10) || (dig == 11)
                ? "0" : Integer.toString(dig));

        soma = 0;
        for (int i = 0; i < 5; i++) {
            if ((chr_cnpj[i] - '0' >= 0) && (chr_cnpj[i] - '0' <= 9)) {
                soma += (chr_cnpj[i] - '0') * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if ((chr_cnpj[(i + 5)] - '0' >= 0) && (chr_cnpj[(i + 5)] - '0' <= 9)) {
                soma += (chr_cnpj[(i + 5)] - '0') * (10 - (i + 1));
            }
        }
        dig = 11 - soma % 11;
        cnpj_calc = cnpj_calc + ((dig == 10) || (dig == 11)
                ? "0" : Integer.toString(dig));

        if (!cnpj_calc.equals("00000000000000")) {
            if (!str_cnpj.equals(cnpj_calc)) {
                FacesMessage msg = new FacesMessage("Aviso:", "CNPJ inválido.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return false;
            }
        } else {
            FacesMessage msg = new FacesMessage("Aviso:", "CNPJ inválido.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return false;
        }

        return true;
    }
}
