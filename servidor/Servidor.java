/*
 * Servidor.java
 *
 * Created on 17 de Maio de 2006, 11:27
 *
 * Servidor ECHO: fica em aguardo de solicita��o de algum cliente. Quando recebe
 * simplesmente devolve a mensagem.
 */

import java.net.*;
import java.io.*;

public class Servidor {
   public static void main(String args[]) {
        DatagramSocket s = null;
        
        try {
            s = new DatagramSocket(6789); // cria um socket UDP
            byte[] buffer = new byte[1000];
            while (true) {
                 System.out.println("*** Servidor aguardando request");
                // cria datagrama para recepcionar solicita��o do cliente
                
                DatagramPacket req = new DatagramPacket(buffer, buffer.length);
                s.receive(req);
                //Mudanças
                //String dados = getBytes();
                alternativa(new String(req.getData()));
                //System.out.println("TESTE: " + dados);
                //fim
                
                System.out.println("*** Request recebido de: " + req.getSocketAddress());
                // envia resposta
                DatagramPacket resp = new DatagramPacket(req.getData(), req.getLength(),
                        req.getAddress(), req.getPort());
                s.send(resp);
            }
            
        } catch (SocketException e) {
            System.out.println("Erro de socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro envio/recepcao pacote: " + e.getMessage());         
        } finally {
            if (s != null) s.close();
        }     
    }

    public static String alternativa (String questao){
        char V;
        V = 'V';
        int certos = 0;

        for (int i=0; i<questao.length(); i++) {
            char c = questao.charAt(i);
            if(c == V){
                certos++;
            }
        }
        
        System.out.println("Número de acertos: " + certos);
        return Integer.toString(certos);
    }
}
