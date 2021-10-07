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
            byte[] buffer = new byte[100];
            while (true) {
                 System.out.println("*** Servidor aguardando request");
                // cria datagrama para recepcionar solicitação do cliente
                
                DatagramPacket req = new DatagramPacket(buffer, buffer.length);
                s.receive(req);
                //Implementação 
                String questao = new String(req.getData());
                char V;
                char F;
                V = 'V';
                F = 'F';
                int certos = 0;
                int erradas = 0;
                String alternativa[] = new String[3];

                alternativa = questao.split(";");
                System.out.println("Questão: " + questao);
                System.out.println("Número da questão: " + alternativa[0]);
                System.out.println("Qº alternativas: " + alternativa[1]);

                //contagem de certos
                for (int i=0; i<questao.length(); i++) {
                    char c = questao.charAt(i);
                    if(c == V){
                        certos++;
                    }
                }
                //contagem de erradas
                for (int i=0; i<questao.length(); i++) {
                    char c = questao.charAt(i);
                    if(c == F){
                        erradas++;
                    }
                }
                
                System.out.println("Certas: " + certos);
                System.out.println("Erradas: " + erradas);


                String saida = "Questão: " + alternativa[0] + " // Nº de alternativas: " + alternativa[1] + " // Número de acertos: " + certos + "// Número de erradas: " + erradas; //transformar inteiro em string
        
                byte[] saidaFinal = saida.getBytes(); //transformar a saída em byte

                req.setData(saidaFinal); //setagem dos dados no buffer do pacote
                //Implementação final

                System.out.println("*** Request recebido de: " + req.getSocketAddress());
                
                DatagramPacket resp = new DatagramPacket(req.getData(), req.getLength(),
                        req.getAddress(), req.getPort()); // envia resposta
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
}
