package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }


    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int index = myContacts.indexOf(oldContact);

        if (index >= 0) {
            myContacts.set(index, newContact);
            return true;
        }

        return false;
    }

    public boolean removeContact(Contact contact){
        if (myContacts.contains(contact)){
            myContacts.remove(contact);
            if (!myContacts.contains(contact)){
                return true;
            }

        }

        return false;
    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);

            if (c.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);

            if (c.getName().equalsIgnoreCase(contact)) {
                return c;
            }
        }
        return null;
    }

    public void printContact(){
        for (Contact contact: myContacts){
            System.out.println(contact);
        }
    }

}
