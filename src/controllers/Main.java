package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;

public class Main
{
  public static void main(String[] args) throws IOException
  {    
	  PacemakerAPI pacemakerAPI = new PacemakerAPI();

	    pacemakerAPI.createUser("Bart", "Simpson",   "bart@simpson.com", "secret");
	    pacemakerAPI.createUser("Homer", "Simpson",  "homer@simpson.com", "secret");
	    pacemakerAPI.createUser("Lisa", "Simpson", " lisa@simpson.com", "secret");

	    Collection<User> users = pacemakerAPI.getUsers();
	    System.out.println(users);

	    User homer = pacemakerAPI.getUser("homer@simpson.com");
	    System.out.println(homer);

	    pacemakerAPI.deleteUser(homer.id);
	    users = pacemakerAPI.getUsers();
	    System.out.println(users);
	    
	    XStream xstream = new XStream(new DomDriver());
	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("datastore.xml"));
	    out.writeObject(users);
	    out.close();
  }
}