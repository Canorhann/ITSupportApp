import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    int id;
    String issue;
    String status;

    public Ticket(int inputId, String inputIssue) {
        id = inputId;
        issue = inputIssue;
        status = "Acik"; 
    }
}

public class App {
    public static void main(String[] args) {
        List<Ticket> ticketList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); 
        int nextTicketId = 101; 

        System.out.println("--- BT Destek Sistemi v1.0 (MVP) ---");

        while (true) {
            System.out.println("\nLutfen bir islem secin:");
            System.out.println("1 - Yeni Talep Olustur");
            System.out.println("2 - Talepleri Listele");
            System.out.println("3 - Talebi Cozuldu Olarak Isaretle");
            System.out.println("4 - Cikis");
            System.out.print("Seciminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Sorunu kisaca aciklayin: ");
                    String userIssue = scanner.nextLine(); 
                    ticketList.add(new Ticket(nextTicketId, userIssue));
                    System.out.println("Talep basariyla olusturuldu! ID: " + nextTicketId);
                    nextTicketId++; 
                    break;
                case 2:
                    System.out.println("\n--- Guncel Talepler ---");
                    if (ticketList.isEmpty()) {
                        System.out.println("Sistemde hic talep yok.");
                    } else {
                        for (Ticket t : ticketList) {
                            System.out.println("ID: " + t.id + " | Durum: " + t.status + " | Sorun: " + t.issue);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Cozulen talebin ID numarasini girin: ");
                    int resolveId = scanner.nextInt();
                    scanner.nextLine();
                    
                    boolean found = false;
                    for (Ticket t : ticketList) {
                        if (t.id == resolveId) {
                            t.status = "Cozuldu"; // Durumu guncelliyoruz
                            System.out.println("Harika! Talep " + resolveId + " basariyla cozuldu.");
                            found = true;
                            break; // Talebi buldugumuz icin donguyu durduruyoruz
                        }
                    }
                    if (!found) {
                        System.out.println("Hata: Bu ID'ye ait bir talep bulunamadi.");
                    }
                    break;
                case 4:
                    System.out.println("Sistemden cikiliyor. Iyi gunler!");
                    scanner.close(); 
                    return; 
                default:
                    System.out.println("Gecersiz secim, lutfen 1, 2, 3 veya 4 tuslayin.");
            }
        }
    }
}