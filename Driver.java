//package SocialMedia;
//Author: Brion & Abhilash
import java.util.*;
//import assignment1.Person;
//import assignment1.Dependents;
//import assignment1.PersonDao;

public class Driver implements PersonDao {
 
	
	List <Person> listofPersons=new ArrayList<Person>();	//Stores list of all  the people
	private static int idCount=0;						//Initialize ID to 0
	
	//Author: Abhilash
	public static void main(String[] args) {
		
		Driver driver= new Driver();
		
		Integer option=0;
		boolean quit=false;
		
		do {
			
			option=menu();						 //calls menu() method 
			
			switch(option) {
			
			case 1:
				driver.addPerson();				 //execute addPerson() Method
				break;
				
			case 2:
				driver.getAllPerson();			 //execute getAllPerson() Method
				break;
	
			case 3:			
				driver.updateProfile(); 			//execute updateProfile() Method
				break;
				
			case 4:
				driver.deletePerson(); 			//execute deletePerson() Method
				break;
				
			case 5:
				driver.connectTwoPersons(); 		//execute connectTwoPerson() Method
				break;
				
			case 6:
				driver.directFriendCheck(); 		//execute directFriendCheck() Method
				break;

			case 7:
				driver.findChild();				 //execute findChild() Method
				break;
			
			case 8:
				driver.findParent();				 //execute findParent() Method
				break;
			
			case 9:
				driver.display(); 				//execute person profile display() Method
				break;
			
			case 0:
				quit=true;
				break;
			
			default:
				System.out.println("Enter correct Option");
			
			}
			
		}while(!quit);
		
	}
	
	//Author: Abhilash
	//Method to add a person
	@Override
	public Person addPerson() {
				
		Person tempPerson=new Person();  
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name: ");
		tempPerson.setName(sc.next());
		System.out.println("Enter the age ");
		tempPerson.setAge(sc.nextInt());
		System.out.println("Enter the Status ");
		tempPerson.setStatus(sc.next());
		tempPerson.setID(idCount++);
		listofPersons.add(tempPerson);				//Adds to the list
		return tempPerson;
				
	}
	
	//Author: Brion		
	// Method to display all person
	@Override
	public void getAllPerson() {
				
		Iterator<Person> list=listofPersons.iterator(); //Using Iterator to iter through through the listofPerson
		
		while(list.hasNext()) {						
			Person p=list.next();
			System.out.println(p.toString());
		}
				
	}
			
	//Author: Abhilash
	// Method to update a person profile
	@Override
	public void updateProfile() {
				
		System.out.println("Enter the Person's name to be updated");
		Scanner sc=new Scanner(System.in);
		
		String searchName=sc.next();
				
		Person p = findPersonExist(searchName); //Checking if the person exists in the listofPerson
				
		if(p!=null) {
					
		System.out.println("Enter field to be updated [Name, Age,Status]");
		System.out.println("1.Name");
		System.out.println("2.Age");
		System.out.println("3.Status");
		System.out.println("Enter your Option: ");
			
		int num=sc.nextInt();
			 
		switch(num) {
			
		case 1:
			System.out.println("Enter updated Name:");
			String newName=sc.next();
			
			String oldName=p.getName(); 			 //assigning old name value to oldName variable.
			p.setName(newName); 					//setting new name 
				
			System.out.println("Name Updated:"+"[ Old Name: "+oldName+"] [New Name: "+newName+"]");
			listofPersons.remove(p); 			// removing existing name value from list 
			listofPersons.add(p); 				// adding new name value from list 
			break;
			
		case 2:
			System.out.println("Enter updated Age:");
			int newAge=sc.nextInt();
			
			int oldAge=p.getAge();  
			p.setAge(newAge); 
			
			System.out.println("Age Updated:"+"[ Old Age: "+oldAge+"] [New Age: "+newAge+"]");
			listofPersons.remove(p); 
			listofPersons.add(p); 			
			break;
			
		 case 3:
			 System.out.println("Enter updated Status");
			 String newStatus=sc.next();
			
			 String oldStatus=p.getStatus(); 
			 p.setStatus(newStatus); 
				
			 System.out.println("Status Updated:"+"[ Old Status: "+oldStatus+"] [New Status: "+newStatus+"]");
			 listofPersons.remove(p); 
			 listofPersons.add(p); 
			 break;
			
		 default:
			System.out.println("Enter correct option:");
			 
		 }
		 }
	
	}

	//Author: Brion
	//Method to delete a person
	@Override
	public void deletePerson() {
		
		System.out.println("Enter the Person's Name");
		Scanner sc=new Scanner(System.in);
		String searchName=sc.next();
		
		Person p=findPersonExist(searchName);
				
		if(p!=null) {
					
			listofPersons.remove(p);
			System.out.println("Successfully removed..!!\n");
					
		}else {
			System.out.println("Name Not Found..");
		}
		
	}
			
	//Author: Brion & Abhilash
	//Method for Connecting two Persons
	@Override
	public void connectTwoPersons() {
			
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first Person's name: ");
		String name1=sc.next();				
		
		Person p1=findPersonExist(name1);			//Checking by the name if it exists in the listofPerson
			
		if(p1==null) {
			
			System.out.println("Name not found");			
		
		}else  
			
			System.out.println("Enter second Person's name:");
			String name2=sc.next();
			Person p2=findPersonExist(name2);
			System.out.println(p2.toString());
			
		
		if(p2==null) {
			System.out.println("Name not found");			
		
		}else 
			System.out.println("Enter Relation:");
		    System.out.println("1.Friend");
		    System.out.println("2.Dependent");
		
		    int no=sc.nextInt();
				
		    switch(no) {
			
		    case 1:
		    	p1.friend = new ArrayList<Integer>();
		    	p2.friend = new ArrayList<Integer>();
		    	p1.friend.add(p2.getID());				//Adding ID to the list by fetching the ID
		    	p2.friend.add(p1.getID());

		    	//Replaces the list of persons with updated persons details
		    	listofPersons.remove(p1);
		    	listofPersons.remove(p2);
		    	listofPersons.add(p1);
		    	listofPersons.add(p2);

		    	System.out.println("Friend connection Estabilished");
		    	break;

			case 2:
				System.out.println("1. Mother");
				System.out.println("2. Father ");

				int no2 = sc.nextInt();

				switch (no2) {

				case 1:
					p1.dependents = new Dependents();
					p2.dependents = new Dependents();
					p1.dependents.setMother(p2.getName());
					p2.dependents.setChild((p1.getID()));
					System.out.println("Mother as a dependent set! ");
					
				 	//Replaces the list of persons with updated details
					listofPersons.remove(p1);
					listofPersons.remove(p2);
					listofPersons.add(p1);
					listofPersons.add(p2);
					break;

				case 2:
					p1.dependents = new Dependents();
					p2.dependents = new Dependents();
					p1.dependents.setFather(p2.getName());
					p2.dependents.setChild((p1.getID()));
					System.out.println("Father as a dependent set ");
					listofPersons.remove(p1);
					listofPersons.remove(p2);
					listofPersons.add(p1);
					listofPersons.add(p2);
					break;

				default:
					System.out.println("Option not proper");

				}

				break;

			default:
				System.out.println("Option not proper");

		    }

	}

	//Author: Brion
	//Method to check a friend
	@Override
	public void directFriendCheck() {
			
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person's Name:");
		String searchName=sc.next(); 				
		
		Person p=findPersonExist(searchName); 		//Checking if the name of the person exists in the listofPerson
				
		if(p!=null)	{
				
			System.out.println("Enter the Friend's Name:");
			String friendName=sc.next(); 
			
			Person q=findPersonExist(friendName); 
			if(q!=null){
				
				if(p.friend.contains(q.getID())) { //checking for other Person's ID in the first person friend list
						
					System.out.println("We have got a direct friend");
				
				}else
					System.out.println("Sorry!Not a direct friend");
					
			}else
				System.out.println("Friend Not found");	
		}else 

			System.out.println("Person Not found");
		
	}

	//Author: Brion
	//Method to a find child
	@Override
	public void findChild() {
		
		System.out.println("Enter the Name:");
		Scanner sc=new Scanner(System.in);
		String searchName=sc.next();
		
		Person p= findPersonExist(searchName); //Checking if the person exists in the listofPerson
		
		if(p!=null) {
			
			if(p.dependents.getChild()>=0) { 
				
				int k=p.dependents.getChild();
				ListIterator<Person> itr=listofPersons.listIterator(); //Using Iterator to get all persons
				while(itr.hasNext()) {  
					
					Person q=itr.next();
					if(q.getID().equals(k)) { 						// comparing two values
						System.out.println("Child Details: "+q.toString());
					}							
				}
			}
		}
	}
	
	
	//Author: Brion
	//Method for finding parent info.
	@Override
	public void findParent() {

				
		System.out.println("Enter the Person's Name");
		Scanner sc= new Scanner(System.in);
		String searchName=sc.next();
			
		Person p=findPersonExist(searchName);// Checking person's name in Person method using composition
		
		if(p!=null) {
			if(p.dependents.getFather()!=null||p.dependents.getMother()!=null) { 
					
				System.out.println("Parents are:");
					
				Person mother=findPersonExist(p.dependents.getMother());
				Person father=findPersonExist(p.dependents.getFather());
					
				if(p.dependents.getMother()!=null)
				System.out.println("Mother Details: "+mother.toString());
					
				if(p.dependents.getFather()!=null)
				System.out.println("Father Details: "+father.toString());
						
			}
		}
	
	}
	
	
	//Author: Abhilash	
	//Method for displaying a person's profile
	@Override
	public void display() {
	
		System.out.println("Enter the Person's Name");
		Scanner sc= new Scanner(System.in);
		String searchName=sc.next();
	
		Person p=findPersonExist(searchName); // Checking for person's name in Person method using composition
	
		if(p!=null) {
			System.out.println(p.toString());	
		}else 
			System.out.println("Name not found");
	
	}
	
	////Author: Abhilash
	// menu displaying all option to the user
	public static int menu() {
		int selection;
		
		System.out.println("======================================");
		System.out.println("              MiniNet                 ");
		System.out.println("======================================");
		
		System.out.println("1. Add a profile of a person");
		System.out.println("2. Get all persons");
		System.out.println("3. Update a person information");
		System.out.println("4. Delete a person information");
		System.out.println("5. Connect two person(Make a relation)");
		System.out.println("6. Check Whether friend is direct friend of another person");
		System.out.println("7. Find a person's Children");
		System.out.println("8. Find name of parent");
		System.out.println("9. Display profile of person");
		System.out.println("0. Exit");
			
		System.out.println(" ");
		System.out.println("Enter Your Option");
		Scanner sc=new Scanner(System.in);
		selection=sc.nextInt();
			
		return selection;
			
	}
	
	//Author: Brion
	//Method to search if the person exists
	private Person findPersonExist(String name) {

		Iterator<Person> itr = listofPersons.iterator();	
		while (itr.hasNext()) {

			Person per = itr.next();						//Looping
			if (per.getName().equalsIgnoreCase(name)) {	//If Name if found it returns the name 

				return per;

			}
		}
		return null;
	}


	
	

}