/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author guana
 */
public class AdcVendas {

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 20001; i++) {
                VendasDAO vDAO = new VendasDAO();
                Vendas v = new Vendas();

                //idUsuario
                Random r = new Random();
                int idUsuario = r.nextInt((3 - 1) + 1) + 1;
                System.out.println("idUsuario: " + idUsuario);

                //nome
                String nomeProduto[] = {"Geladeira", "Notebook", "Mouse", "Teclado", "Mesa Escritório", "Monitor 22'", "Televisão 4k Samsung", "Abajur Usado", "SmartWhatch", "Headset Razer", "Adesivos Dev", "Joystick X-box", "Mac Pro 2019", "Ipad", "Iphone XR", "Iphone 8", "Smart phone 5g"};
                String sorteio = nomeProduto[r.nextInt(nomeProduto.length)];
                System.out.println("nomeProduto: " + sorteio);

                //qtd
                int qtd = r.nextInt((101 - 1) + 1) + 1;
                System.out.println("qtd: " + qtd);

                v.setIdUsuario(Integer.toString(idUsuario));
                v.setNomeProduto(sorteio);
                v.setQtd(Integer.toString(qtd));

                v.setDtVenda(null);

                vDAO.inserir(v);
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage() + " - " + e.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + " - " + e.toString());
        }
    }
}
