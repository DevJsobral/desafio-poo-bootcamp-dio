import java.util.Scanner;

public class ContaTerminalJava {

    int numero;
    String agencia;
    String nomeCliente;
    double saldo;

    public ContaTerminalJava(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public static void main(String[] args) throws Exception {
       
        String nome;
        int numero = 0;
        String agencia;
        double saldo = 0;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Olá, por favor digite seu nome:");
        nome = scanner.nextLine();
        
        System.out.println("Por favor digite o número da sua conta:");
        try {
           numero = Integer.parseInt(scanner.nextLine());
       } catch (Exception e) {
            scanner.close();
            throw new RuntimeException ("O número que você inseriu não é um número válido.");
       }
        
        System.out.println("Por favor digite sua agencia:");
        agencia = scanner.nextLine();
        
        System.out.println("Por favor digite seu saldo:");
        try {
            saldo = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            scanner.close();
            throw new RuntimeException("O Saldo que você inseriu não é um número válido, adicione apenas números, sem vírugla pontos e afins.");
        }

        ContaTerminalJava conta = new ContaTerminalJava(numero, agencia, nome, saldo);

        System.out.println("Olá " + conta.nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + conta.agencia + ", conta " + conta.numero + " e seu saldo " + conta.saldo
                + " já está disponível para saque.");

        scanner.close();
    }
}
