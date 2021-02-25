package com.address;

import java.util.*;

public class AddressBook extends AddressBookOperate {
    public static void main(String[] args) {
        System.out.println("List of Address books");
        Map<String, ArrayList<Contact>> map = new HashMap<>();
        ArrayList<Contact> list1 = new ArrayList<>();
        ArrayList<Contact> list2 = new ArrayList<>();
        map.put("AddressBook1", list1);
        map.put("AddressBook2", list2);
        for(Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey()+ " " +m.getValue());
        }

        boolean f = true;
        s: while(true)
        {
            s2: while(f == true) {
                System.out.println("! Welcome to the Address Book System !");
                System.out.println("Enter 1 to work on AddressBook1");
                System.out.println("Enter 2 to work on AddressBook2");
                System.out.println("Enter 3 to search for a Contact");
                System.out.println("Enter 0 to exit System");
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1) {
                    System.out.println("Working on AddressBook "+choice);
                    details(list1);
                    break;
                }
                else if(choice == 2) {
                    System.out.println("Working on AddressBook "+choice);
                    details(list2);
                    break;
                }

                else if(choice == 3) {

                    joined.addAll(list1);
                    joined.addAll(list2);
                  /*  Iterator<Contact> itr = joined.iterator();
                    while(itr.hasNext()){
                        System.out.println(itr.next());
                    }*/

                    if(joined.size()==0){
                        System.out.println("No contacts");
                    }
                    System.out.println("Enter city name");
                    String checkcity = new Scanner(System.in).nextLine();
                    System.out.println("Enter state name: ");
                    String checkstate = new Scanner(System.in).nextLine();
                    int num = 0;
                    for(Contact con : joined) {
                        if (con.getcity().equals(checkcity) || con.getState().equals(checkstate)) {
                            System.out.println(con+"");
                            num++;
                        }
                    }
                    System.out.println("Number of Contacts with same city and state: " + num);
                    break;
                } else if(choice == 0) {
                    System.out.println("System Exit");
                    break s;
                }
            }
        }
    }

    public static void details(ArrayList<Contact> list) {
        mainlist = list;
        int numOfPerson = 0;
        AddressBook Book = new AddressBook();
        boolean flag=true;
        s: while(flag == true) {
            int choice = Book.chooseOption();
            s2: while(true) {
                if(choice == 1) {
                    System.out.println("Enter number of Persons to add");
                    numOfPerson = new Scanner(System.in).nextInt();
                    for(int i =1;i <=numOfPerson;i++) {
                        System.out.println("Enter the First name to check");
                        String checkname = new Scanner(System.in).nextLine();
                        if(Book.add(checkname) == false)
                            break s2;
                        System.out.println("Enter the First name for Person "+i);
                        String first = new Scanner(System.in).nextLine();
                        System.out.println("Enter last name for Person "+i);
                        String last = new Scanner(System.in).nextLine();
                        System.out.println("Enter Address for Person "+i);
                        String address = new Scanner(System.in).nextLine();
                        System.out.println("Enter city for person "+i);
                        String city= new Scanner(System.in).nextLine();
                        System.out.println("Enter state for person "+i);
                        String state = new Scanner(System.in).nextLine();
                        System.out.println("Enter zip for Person "+i);
                        String zip = new Scanner(System.in).nextLine();
                        System.out.println("Enter Phone number for Person "+i);
                        String phoneNumber = new Scanner(System.in).nextLine();
                        System.out.println("Enter email for Person "+i);
                        String email = new Scanner(System.in).nextLine();
                        Contact con = new Contact(first,last,address,city,state,zip,phoneNumber,email);
                        mainlist.add(con);
                        System.out.println("Added Succesfully");
                    }
                    break;
                }
                else if(choice == 2){
                    Book.view();
                    break;
                }
                else if(choice == 3) {
                    System.out.println("Enter first name: ");
                    String first = new Scanner(System.in).nextLine();
                    System.out.println("Enter last name: ");
                    String last = new Scanner(System.in).nextLine();
                    System.out.println("Enter Address: ");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println("Enter city: ");
                    String city = new Scanner(System.in).nextLine();
                    System.out.println("Enter state");
                    String state = new Scanner(System.in).nextLine();
                    System.out.println("Enter zip");
                    String zip = new Scanner(System.in).nextLine();
                    System.out.println("Enter Phone number :");
                    String phoneNumber = new Scanner(System.in).nextLine();
                    System.out.println("Enter email: ");
                    String email = new Scanner(System.in).nextLine();
                    if(Book.edit(first,last,address, city,state,zip,phoneNumber,email) == false)
                        break s2;
                    else
                        System.out.println("Edited Successfully");
                    break;
                }
                else if(choice == 4) {
                    System.out.println("Enter first name");
                    String first = new Scanner(System.in).nextLine();
                    System.out.println("Enter last name: ");
                    String last = new Scanner(System.in).nextLine();
                    if(Book.delete(first,last) == false) {
                        break s2;
                    }
                    break;
                }
                else if(choice == 5) {
                    System.out.println("Enter city name");
                    String city = new Scanner(System.in).nextLine();
                    System.out.println("Enter state name: ");
                    String state = new Scanner(System.in).nextLine();
                    if(Book.searchPerson(city,state) == false) {
                        break s2;
                    }
                    break;
                }
                else if(choice == 0) {
                    System.out.println("Return to main");;
                    break s;
                }
                else
                    System.out.println("Invalid choice");
            }
        }
    }
}
