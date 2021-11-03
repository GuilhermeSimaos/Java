import java.util.Scanner;

public class Compilation1 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        //Esse programa tem como objetivo fazer um compilado de exercicios realizados
        //Futuras possibilidades: adicionar cores(se possivel), utilizar try-catches, melhorar interface(talvez utilizar JOption).
        
        int option = 0;
        
        Menu();
        option = Integer.parseInt(s.nextLine());
        
        while (option != -1) {            
            switch(option){
                case 1 -> Ola_pessoa();
                case 2 -> Par_Impar();
                case 3 -> Troca_nomes();
                case 4 -> Tabuada();
                case 5 -> Somador();
                case 6 -> Desconto_produtos();
                case 7 -> MaiorValor();
                case 8 -> MediaNotas();
                case 9 -> MediaNotasV2();
                case 10 -> Convidados();
                case 11 -> ConvidadosV2();
                case 12 -> LadosTriangulo();
                case 13 -> MaioresDeIdade();
                case 14 -> AntecessorSucessor();
                case 15 -> ConversorDeTemperatura();
                }
            
            System.out.print("Pressione Enter para continuar");
            s.nextLine();
            System.out.println("\n\n\n\n\n\n");
            clearScreen();
            Menu();
            option = Integer.parseInt(s.nextLine());
            clearScreen();
        }
        System.out.println("\n\t\t*** Finalizando ***\n");
    }
    public static void Menu(){
        System.out.println("============= Compilação de exercícios v1 =============");
        System.out.println("\nLista de Programas criados: ");
        System.out.println("\t1 - Olá <pessoa>");
        System.out.println("\t2 - Par ou Impar");
        System.out.println("\t3 - Troca de nomes");
        System.out.println("\t4 - Tabuada");
        System.out.println("\t5 - Somador de idades");
        System.out.println("\t6 - Desconto em produtos");
        System.out.println("\t7 - Maior valor");
        System.out.println("\t8 - Media das notas");
        System.out.println("\t9 - Media das notas V2");
        System.out.println("\t10- Lista de convidados");
        System.out.println("\t11- Lista de convidados dinâmica");
        System.out.println("\t12- Lados de um triângulo");
        System.out.println("\t13- Maiores de idade");
        System.out.println("\t14- Antecessor e Sucessor");
        System.out.println("\t15- Conversor de Temperatura");
        System.out.println("\n\t-1 para SAIR\n");
        System.out.println("=======================================================");
        System.out.print("Selecione uma opção: ");
    }
    public static void Ola_pessoa(){
        String nome;
        
        System.out.println("===================== Ola pessoa ======================");
        System.out.print("\nQual o seu nome? : ");
        nome = s.nextLine();
        
        System.out.printf("\nOlá %1$s, fico feliz em te conhecer!\n\n",nome);
        System.out.println("=======================================================");
    }
    public static void Par_Impar(){
        int numero;
        
        System.out.println("==================== Par ou Impar =====================");
        System.out.print("\nDigite um numero qualquer: ");
        numero = Integer.parseInt(s.nextLine());
        
        if (numero % 2 == 0) {
            System.out.printf("\n\tO numero %1$d é par\n\n",numero);
        }else{
            System.out.printf("\n\tO número %1$d é ímpar\n\n",numero);
        }
        System.out.println("=======================================================");
    }
    public static void Troca_nomes(){
        String nome1, nome2, aux;
        
        System.out.println("==================== Troca de Nomes ===================");
        System.out.print("\nQual é o seu nome? : ");
        nome1 = s.nextLine();
        System.out.print("Qual é o seu sobrenome? : ");
        nome2 = s.nextLine();
        
        aux = nome1;
        nome1 = nome2;
        nome2 = aux;
        
        System.out.printf("\nAgora seu nome é %1$s %2$s\n\n",nome1,nome2);
        System.out.println("=======================================================");
    }
    public static void Tabuada(){
        int numero;
        
        System.out.println("======================= Tabuada =======================");
        System.out.print("\nDigite um numero qualquer : ");
        numero = Integer.parseInt(s.nextLine());
        
        System.out.println("\n\t\t    --- Tabuada ---");
        for (int i = 0; i < 11; i++) {
            System.out.printf("\t%1$d x %2$d = %3$d\n",numero,i,numero*i);
        }
        System.out.println("\n=======================================================");
    }
    public static void Somador(){
        int idade, total = 0;
        
        System.out.println("================== Somador de idades ==================\n");
        int i =0;
        while (i < 5) {            
            System.out.print("Digite uma idade qualquer: ");
            idade = Integer.parseInt(s.nextLine());
            total += idade;
            i++;
        }
        System.out.printf("\nA soma das idade é %1$d\n\n",total);
        System.out.println("=======================================================");
    }
    public static void Desconto_produtos(){
        String nome, desconto;
        float valor, valorFinal = 0, valorDesc;
        
        System.out.println("================= Desconto de produtos ================");
        System.out.print("\nQual o nome do produto? : ");
        nome = s.nextLine();
        System.out.print("E qual o valor do produto? : R$");
        valor = Float.parseFloat(s.nextLine());
        
        if (valor > 100.0 && valor <= 200.0) {
            desconto = "10%";
            valorDesc = 10;
        }else if (valor > 200.0 && valor <= 300.0) {
            desconto = "20%";
            valorDesc = 20;
        }else if (valor > 300.0) {
            desconto = "30%";
            valorDesc = 30;
        }else{
            desconto = "0%";
            valorDesc = 0;
        }
        valorFinal = valor - (valor * valorDesc/100);
        
        
        System.out.printf("\n\n... %1$s recebeu %2$s de desconto! ...\n\n",nome,desconto);
        System.out.printf("Nome do produto: %1$s\n",nome);
        System.out.printf("Valor original : R$%1$.2f\nValor Final: R$%2$.2f\n\n",valor,valorFinal);
        System.out.println("=======================================================");
    }
    public static void MaiorValor(){
        int[] numero = new int[4];
        
        System.out.println("===================== Maior Valor =====================\n");
        for (int i = 0; i < numero.length; i++) {
            System.out.print("Digite um numero qualquer: ");
            numero[i] = Integer.parseInt(s.nextLine());
        }
        
        if (numero[0] > numero[1] && numero[0] > numero[2] && numero[0] > numero[3]) {
            System.out.println("\nO maior numero é "+numero[0]+"\n");
        }else if (numero[1] > numero[0] && numero[1] > numero[2] && numero[1] > numero[3]) {
            System.out.println("\nO maior numero é "+numero[1]+"\n");
        }else if (numero[2] > numero[0] && numero[2] > numero[1] && numero[2] > numero[3]) {
            System.out.println("\nO maior numero é "+numero[2]+"\n");
        }else if (numero[3] > numero[0] && numero[3] > numero[1] && numero[3] > numero[2]) {
            System.out.println("\nO maior numero é "+numero[3]+"\n");
        }else{
            System.out.println("\nExistem dois ou mais numeros de maior valor iguais!\n");
        }
        System.out.println("=======================================================");
    }
    public static void MediaNotas(){
        float nota1, nota2, nota3, nota4, notaFinal;
        String nome;
        
        System.out.println("=================== Media das Notas ===================");
        System.out.print("\nQual o seu nome? : ");
        nome = s.nextLine();
        System.out.print("Qual foi sua primeira nota? : ");
        nota1 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua segunda nota?  : ");
        nota2 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua terceira nota? : ");
        nota3 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua quarta nota?   : ");
        nota4 = Float.parseFloat(s.nextLine());
        
        notaFinal = (nota1+nota2+nota3+nota4)/4;
        
        System.out.printf("\n%1$s, sua nota final foi a seguinte: %2$.1f\n\n",nome,notaFinal);
        System.out.println("=======================================================");
    }
    public static void MediaNotasV2(){
        float nota1, nota2, nota3, nota4, notaFinal;
        String nome;
        
        System.out.println("================== Media das Notas V2 =================");
        System.out.print("\nQual o seu nome? : ");
        nome = s.nextLine();
        System.out.print("Qual foi sua primeira nota? : ");
        nota1 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua segunda nota?  : ");
        nota2 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua terceira nota? : ");
        nota3 = Float.parseFloat(s.nextLine());
        System.out.print("Qual foi sua quarta nota?   : ");
        nota4 = Float.parseFloat(s.nextLine());
        
        notaFinal = (nota1+nota2+nota3+nota4)/4;
        
        if (notaFinal >= 6) {
            System.out.println("\n---Parabens! você passou na sua disciplina---  \n");
        }else{
            System.out.println("\nInfelizmente você não passou na disciplina. :( \n");
        }
        System.out.println("A média necessária para passar é 6.");
        System.out.printf("%1$s, você obteve uma média de %2$.1f\n\n",nome,notaFinal);
        System.out.println("=======================================================");
    }
    public static void Convidados(){
        String[] convidados = new String[5];
        
        
        System.out.println("================ Lista de Convidados ==================");
        System.out.println("\nLista de convidados para a festa");
        System.out.println("Digite o nome dos convidados: ");
        
        for (int i = 0; i < convidados.length; i++) {
            System.out.printf("Convidado %1$d : ",i+1);
            convidados[i] = s.nextLine();
        }
        
        System.out.println("\n\nOs convidados para a festa sâo :");
        
        for (int i = 0; i < convidados.length; i++) {
            System.out.println("\t"+convidados[i]);
        }
        System.out.println("\n=======================================================");
    }
    public static void ConvidadosV2(){
        String[] convidados = new String[100];
        char continuar = 's';
        int npessoas = 0;
        System.out.println("=============== Lista de Convidados V2 ================");
        System.out.println("\nLista de convidados dinâmica da festa! ");
        System.out.println("Digite o nome dos convidados: ");
        
        for (int i = 0; i < convidados.length && continuar != 'n'; i++) {
            System.out.printf("Convidado %1$d : ",i+1);
            convidados[i] = s.nextLine();
            System.out.print("Continuar Cadastrando? s/n : ");
            continuar = s.nextLine().toLowerCase().charAt(0);
        }
        
        System.out.print("\nQuantos convidados deseja exibir? : ");
        npessoas = Integer.parseInt(s.nextLine());
        
        System.out.println("\nLista dos convidados para a festa: ");
        for (int i = 0; i < npessoas; i++) {
            if (convidados[i] != null) {
                System.out.println("\t"+convidados[i]);
            }
        }
        System.out.println("\n=======================================================");
    }
    public static void LadosTriangulo(){
        int lado1, lado2, lado3;
        
        System.out.println("================ Lados de um Triângulo ================");
        System.out.print("\nDigite o comprimento do primeiro lado: ");
        lado1 = Integer.parseInt(s.nextLine());
        System.out.print("Digite o comprimento do segundo lado : ");
        lado2 = Integer.parseInt(s.nextLine());
        System.out.print("Digite o comprimento do terceiro lado: ");
        lado3 = Integer.parseInt(s.nextLine());
        
        if (lado1 <= lado2 + lado3 && lado2 <= lado1 + lado3 && lado3 <= lado1 + lado2) {
            System.out.println("\n\t>>> É um triângulo! <<<\n");
        }else{
            System.out.println("\n\t,,, Nao é um triângulo ,,,\n");
        }
        System.out.println("=======================================================");
    }
    public static void MaioresDeIdade(){
        int[] idade = new int[5];
        int maiores = 0;
        
        System.out.println("================== Maiores de Idade ===================\n");
        for (int i = 0; i < idade.length; i++) {
            System.out.print("Digite um idade qualquer: ");
            idade[i] = Integer.parseInt(s.nextLine());
            if (idade[i] >= 18) {
                maiores++;
            }
        }
        
        if (maiores > 1) {
            System.out.printf("\n%1$d pessoas são adultas(18+)\n\n",maiores);
        }else if (maiores == 0) {
            System.out.println("\nTodos são adolescentes e não tem nenhum adulto\n");
        }else{
            System.out.println("\nSomente 1 pessoa é maior de idade\n");
        }
        System.out.println("=======================================================");
    }
    public static void AntecessorSucessor(){
        int numero;
        
        System.out.println("=============== Antecessor e Sucessor =================");
        System.out.print("\nDigite um numero qualquer: ");
        numero = Integer.parseInt(s.nextLine());
        
        System.out.println("\nSeu numero escolhido foi : "+numero);
        System.out.println("O Antecessor dele é : "+(numero - 1));
        System.out.println("O Sucessor dele é : "+(numero + 1)+"\n");
        System.out.println("=======================================================");
    }
    public static void ConversorDeTemperatura(){
        float celsius, farenheit, kelvin;
        
        System.out.println("============== Conversor de Temperaturas ==============");
        System.out.print("\nDigite a temperatura em Celsius(ºC): ");
        celsius = Float.parseFloat(s.nextLine());
        
        farenheit = (float) (celsius * 1.8 + 32);
        kelvin = (float) (celsius + 273.15);
        
        System.out.println("\nTemperatura original em Celsius   : "+celsius+"ºC");
        System.out.println("Temperatura original em Farenheit : "+farenheit+"ºF");
        System.out.println("Temperatura original em Kelvin    : "+kelvin+"ºK\n");
        System.out.println("=======================================================");
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }    
}
