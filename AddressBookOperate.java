package com.address;

import java.util.*;

public class AddressBookOperate {
    public static ArrayList<Contact> mainlist = new ArrayList<>();
    public static Set<Contact> joined = new LinkedHashSet<>();
    Scanner scan =new Scanner(System.in);

    public void view() {
        if (mainlist.size() == 0) {
            System.out.println("*No contact information!!*");
            return;
        } else {
            Iterator<Contact> iter = mainlist.iterator();
            while (iter.hasNext())
                System.out.println(iter.next());}
    }

    public boolean add(String checkname) {
        String check=checkname;
        if (mainlist.size() == 0)
            return true;
        for (Contact con : mainlist) {
            if (con.getFirstName().equals(check)) {
                System.out.println("Contact with same name already exists !");
                return false;
            }
        }
        return true;
    }

    public boolean edit(String first, String last, String address, String city, String state,String email, String zip, String phoneNumber ) {
        if (mainlist.size() == 0)
            return false;
        int count = 0;
        for (Contact con : mainlist) {
            count++;
            if (con.getFirstName().equals(first) && con.getLastName().equals(last)) {
                con.setAddress(address);
                con.setcity(city);
                con.setState(state);
                con.setzip(zip);
                con.setphoneNumber(phoneNumber);
                con.setemail(email);
                mainlist.set(count-1, con);
                return true;
            }
        }
        if (true)
            System.out.println("There is no information about the contact in the system!!");
        return false;
    }
    public boolean delete(String first,String last) {
        if (mainlist.size() == 0)
            return false;
        int count=0;
        for (Contact con : mainlist) {
            count++;
            if (con.getFirstName().equals(first) && con.getLastName().equals(last)) {
                mainlist.remove(count - 1);
                System.out.println("Deleted successful");
                return true;
            }
        }
        System.out.println("This contact number does not exist!!");
        return true;
    }

    public static boolean searchPerson(String city, String state) {
        if(mainlist.size()==0)
            return false;
        int count = 0;
        int num = 0;
        for(Contact con : mainlist) {
            count ++;
            if(con.getcity().equals(city) || con.getState().equals(state)) {
                System.out.println(con);
                num++;
            }
            System.out.println("Number of Contacts with same city and name: "+num);
            return true;
        }
        System.out.println("Contact does not exist");
        return true;
    }

    int chooseOption() {
        System.out.println("Enter 1 to add contact");
        System.out.println("Enter 2 to view contact");
        System.out.println("Enter 3 to edit contact");
        System.out.println("Enter 4 to delete contact");
        System.out.println("Enter 5 to search contact");
        System.out.println("Enter 0 to switch Address Book");
        int n = scan.nextInt();
        return n;
    }
}
