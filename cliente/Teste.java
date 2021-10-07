public class Teste {
    public static void main(String args[]) {

        String tudo = "12;92;";
        String questao = "";
        String altern = "";
        char V;
        char F;
        char ponto;
        V = 'V';
        F = 'F';
        ponto = ';';

        String frase = "nome;teste;10";
        String array[] = new String[3];
        
        array = tudo.split(";");
        System.out.println(array[0]);
    }
}
