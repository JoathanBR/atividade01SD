public class Teste {
    public static void main(String args[]) {
        String q = "FFFFV";
        alternativa(q);
    
    }

    public static void alternativa (String questao){
        char V;
        V = 'V';
        int certos = 0;

        System.out.println(questao);

        for (int i=0; i<questao.length(); i++) {
            char c = questao.charAt(i);
            if(c == V){
                certos++;
            }
        }
        
        System.out.println("Número de acertos: " + certos);
        return ;
    }
}
