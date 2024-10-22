package atividadeav1;

import java.util.Scanner;

public class avaliativa {
    private double tamanhoTerreno;
    private int numComodos;
    private int numJanelas;
    private int numPortas;
    private String material;
    
 
    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o tamanho do terreno (em metros quadrados): ");
        tamanhoTerreno = scanner.nextDouble();
        
        System.out.println("Informe o número de cômodos: ");
        numComodos = scanner.nextInt();
        
        System.out.println("Informe o número de janelas: ");
        numJanelas = scanner.nextInt();
        
        System.out.println("Informe o número de portas: ");
        numPortas = scanner.nextInt();

        System.out.println("Escolha o material de construção (1 - Tijolo, 2 - Madeira, 3 - Concreto): ");
        int escolhaMaterial = scanner.nextInt();
        if (escolhaMaterial == 1) {
            material = "Tijolo";
        } else if (escolhaMaterial == 2) {
            material = "Madeira";
        } else {
            material = "Concreto";
        }


    }
    

}
