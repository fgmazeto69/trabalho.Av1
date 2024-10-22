package atividadeav1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




class Quarto {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }
}

class Reserva {
    private String nomeHospede;
    private String dataCheckIn;
    private String dataCheckOut;
    private int numeroQuartosReservados;
    private String tipoQuartoReservado;

    public Reserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuartosReservados, String tipoQuartoReservado) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartosReservados = numeroQuartosReservados;
        this.tipoQuartoReservado = tipoQuartoReservado;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroQuartosReservados() {
        return numeroQuartosReservados;
    }

    public String getTipoQuartoReservado() {
        return tipoQuartoReservado;
    }
}

class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        quartos.add(new Quarto(numero, tipo, precoDiario));
        System.out.println("Quarto cadastrado com sucesso.");
    }

    public void cadastrarReserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuartosReservados, String tipoQuartoReservado) {
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel() && quarto.getTipo().equals(tipoQuartoReservado)) {
                quarto.reservar();
                reservas.add(new Reserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuartosReservados, tipoQuartoReservado));
                System.out.println("Reserva cadastrada com sucesso.");
                return;
            }
        }
        System.out.println("Nenhum quarto disponível do tipo " + tipoQuartoReservado + ".");
    }

    public void checkIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                System.out.println("Check-in realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada para " + nomeHospede);
    }

    public void checkOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                for (Quarto quarto : quartos) {
                    if (quarto.getTipo().equals(reserva.getTipoQuartoReservado())) {
                        quarto.liberar();
                        System.out.println("Check-out realizado para " + nomeHospede);
                        return;
                    }
                }
            }
        }
        System.out.println("Reserva não encontrada para " + nomeHospede);
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        int quartosOcupados = 0;
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                quartosOcupados++;
                System.out.println("Quarto " + quarto.getNumero() + " - Tipo: " + quarto.getTipo());
            }
        }
        System.out.println("Total de quartos ocupados: " + quartosOcupados);
    }

    public void relatorioHistoricoReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Hóspede: " + reserva.getNomeHospede() + ", Data Check-in: " + reserva.getDataCheckIn() + ", Data Check-out: " + reserva.getDataCheckOut());
        }
    }
}

public class SistemaHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Quarto");
            System.out.println("2 - Cadastrar Reserva");
            System.out.println("3 - Check-in");
            System.out.println("4 - Check-out");
            System.out.println("5 - Relatório de Ocupação");
            System.out.println("6 - Relatório de Histórico de Reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Tipo do quarto: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double precoDiario = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, precoDiario);
                    break;

                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Data de Check-in: ");
                    String dataCheckIn = scanner.nextLine();
                    System.out.print("Data de Check-out: ");
                    String dataCheckOut = scanner.nextLine();
                    System.out.print("Número de quartos reservados: ");
                    int numeroQuartosReservados = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Tipo de quarto reservado: ");
                    String tipoQuartoReservado = scanner.nextLine();
                    hotel.cadastrarReserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuartosReservados, tipoQuartoReservado);
                    break;

                case 3:
                    System.out.print("Nome do hóspede para Check-in: ");
                    String nomeCheckIn = scanner.nextLine();
                    hotel.checkIn(nomeCheckIn);
                    break;

                case 4:
                    System.out.print("Nome do hóspede para Check-out: ");
                    String nomeCheckOut = scanner.nextLine();
                    hotel.checkOut(nomeCheckOut);
                    break;

                case 5:
                    hotel.relatorioOcupacao();
                    break;

                case 6:
                    hotel.relatorioHistoricoReservas();
                    break;

                case 0:
                    System.out.println("Saindo do sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
