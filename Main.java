import java.util.Scanner;

/**
 * This is my Main class. 
 * 
 * It will then display a
Menu giving you the option to add a person to your wait list, serve a person, find a person
in the list, get a total number of people waiting, display the waiting list, or quit the 
application. You will then enter in an option number depending on what you would like to do.
 */
public class Main
{

    public static void main(String[] args) {

        WaitingList waiting = new WaitingList();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{
            menu();
            choice = scanner.nextInt();
            if(choice >= 1 && choice <= 5){
                executeOption(choice, waiting, scanner);
            }
        }
        while(choice != 6);

    }

    public static void menu(){
        System.out.println("\nWaiting List Options\n");
        System.out.println("1. Add person to list.\n");
        System.out.println("2. Serve person.\n");
        System.out.println("3. Find person in list.\n");
        System.out.println("4. Get total number of people waiting.\n");
        System.out.println("5. Display waiting list.\n");
        System.out.println("6. Quit application.\n");
        System.out.println("Enter in option number...");
        System.out.println("---------------------------------------------\n");
    }

    public static void executeOption(int option, WaitingList waiting, Scanner s){
        switch(option){
            case 1: 
                addPersonToListOption(waiting);
                break;
            case 2:
                servePersonOption(waiting);
                break;
            case 3:
                findPersonOption(waiting);
                break;
            case 4:
                getTotalPeopleWaitingOption(waiting);
                break;
            case 5:
                displayWaitingListOption(waiting);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void addPersonToListOption(WaitingList waiting ){
        System.out.println("Adding person to list...\n");
        System.out.print("Please enter the name of the person to add to the list: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("You added: " + name);
        waiting.addPerson(name);
    }

    public static void servePersonOption(WaitingList waiting){
        System.out.println("Serving person...\n");
        String name = waiting.servePerson();
        System.out.println("Doctor is now seeing " + name);
    }

    public static void findPersonOption(WaitingList waiting){
        System.out.println("Finding person...\n");
        System.out.println("What person would you like to find? ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("You are trying to find " + name);

        if(waiting.isPersonInList(name)){
            System.out.println(name + " is on the list.");
        }
        else{
            System.out.println("Could not find " + name + " on the list.");
        }
    }

    public static void getTotalPeopleWaitingOption(WaitingList waiting){
        System.out.println("Getting list total...\n");
        System.out.println("There are " + waiting.waitingListSize() + " people on the list.");
    }

    public static void displayWaitingListOption(WaitingList waiting){
        System.out.println("Displaying list...\n");
        waiting.displayWaitingList();
    }
}
