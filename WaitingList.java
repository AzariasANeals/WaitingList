import java.util.*;


public class WaitingList
{
    private Queue<String> waitingList;
    private Set<String> verifyList;
    
    public WaitingList(){
        waitingList = new LinkedList<String>();
        verifyList = new HashSet<String>();
    }
    
    public void addPerson(String name){
        if(!verifyList.contains(name)){
            verifyList.add(name);
            waitingList.add(name);
        }
    }
    
    public String servePerson(){
        String buffer = "";
        // We are casting waitingList to LinkedList to use the size() method.
        // if the size is greater than 0, we will remove the next person in the list.
        if(((LinkedList)waitingList).size() > 0){
            buffer = waitingList.remove();
            
            // Need to remove the name from the Set so that another person with the same name
            // can be added later.
            if(verifyList.remove(buffer)){
                System.out.println("Removed: " + buffer);
            }
            else{
                System.out.println("Error removing " + buffer + " from verification list.");
            }
        }
        else{
            System.out.println("Waiting list is empty...");
        }
        return buffer;
    }
    
    public boolean isPersonInList(String name){
        //LinkedList contains() method returns a boolean.
        return  ((LinkedList)waitingList).contains(name); 
    }
    
    public int waitingListSize(){
        return ((LinkedList)waitingList).size();
    }
    
    public void displayWaitingList(){
        System.out.println("Current Waiting List\n");
        for(int i = 0; i < ((LinkedList)waitingList).size(); i++){
            System.out.println(((LinkedList)waitingList).get(i));
        }
    }
}
