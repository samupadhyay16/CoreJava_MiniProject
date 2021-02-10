package n2s.ehc.samprati;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserOptions {
	public static Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
	public static UserBean ub=new UserBean();
	public static UserExceptions ue = new UserExceptions();
	public static int op,count;
	public static String v_name;
	public static boolean i_flag=true,u_flag=true,d_flag=true;
	                                	
	public void valid_id(Scanner scan){
		System.out.printf("\n Enter UserId: ");
		try {
			op=ub.setUserId(scan.nextInt());			
		}catch(Exception e) {
			System.out.println("\n Invalid Id");
			scan.nextLine();
			valid_id(scan);
		}
	}
	
	public void valid_name(Scanner scan) {
		System.out.printf("\n Enter Name: ");		
    	v_name=ub.setUserName(scan.next());
    	if (!v_name.matches("^[a-zA-Z\\s]+")) {
		    System.out.println("\n Invalid name");
		    valid_name(scan);
		}
	}
	
	public void insert_op(Scanner scan) {
		System.out.println("\n Wish to insert more(y/n): ");
		char op1=scan.next().charAt(0);
        if(op1=='y'||op1=='Y')
        {
        	insert(scan);
        }
        else if(op1=='n'||op1=='N'){
        	i_flag=false;
        	u_flag=true;
        	d_flag=true;
        }
        else {
        	System.out.println("Incorrect input");
        	insert_op(scan);
        }
	}
	
	public void update_op(Scanner scan) {
		System.out.println("\n Wish to update more(y/n): ");
		char op1=scan.next().charAt(0);
        if(op1=='y'||op1=='Y')
        {
        	update(scan);
        }
        else if(op1=='n'||op1=='N'){
        	i_flag=true;
        	u_flag=false;
        	d_flag=true;
        }
        else {
        	System.out.println("Incorrect input");
        	update_op(scan);
        }
	}
	
	public void delete_op(Scanner scan) {
		System.out.println("\n Wish to delete more(y/n): ");
		char op1=scan.next().charAt(0);
        if(op1=='y'||op1=='Y')
        {
        	delete(scan);
        }
        else if(op1=='n'||op1=='N'){		       
        	i_flag=true;
        	u_flag=true;
        	d_flag=false;
        }
        else {
        	System.out.println("Incorrect input");
        	delete_op(scan);
        }
	}
	
	public void insert(Scanner scan) {
		while(i_flag) {	
	    	System.out.println("\n Insert \n------------------");
	    	try {	    		
	    		valid_id(scan);	    		
	            if(ue.validateId(ht.containsKey(op))) {
	            	i_flag=false;
	            }
	            valid_name(scan);
	            ht.put(op,v_name);
	            System.out.printf("\n Your Insert Success !!");
	            insert_op(scan);
	    	}catch(InvalidUserId ui) {
				System.out.println(ui.toString());
			}
		}
	}
	
	public void update(Scanner scan) {
		while(u_flag) {
	    	System.out.println("\n Update \n------------------");
	    	try {
	    		valid_id(scan);
	            if(ue.idUnavailable(!ht.containsKey(op))) {
	            	u_flag=false;
	            }
	            valid_name(scan);
	            ht.put(op,v_name);
	            System.out.printf("\n Update Success !!");
	            update_op(scan);
	    	}catch(UserIdNotFound uinf) {
				System.out.println(uinf.toString());;
			}
		}
	}
    	
	public void delete(Scanner scan) {
		while(d_flag) {
	    	System.out.println("\n Delete \n------------------");
	    	try {
	    		valid_id(scan);
	            if(ue.idUnavailable(!ht.containsKey(op))) {
	            	d_flag=false;
	            }	
	            ht.remove(op);
	            System.out.printf("\n Delete Success !!");
	            delete_op(scan);
	    	}catch(UserIdNotFound uinf) {
				System.out.println(uinf.toString());;
			}
		}
	}
	
	public void view() {
		int count=1;
		System.out.println(" \n View \n----------------------------");
		System.out.println("S.No. \t Id \t Name \n-------------------------------");
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(ht);
		for(Map.Entry<Integer, String> i:tmap.entrySet()){
			 System.out.println(count+"\t"+i.getKey()+"\t"+ i.getValue());
			 count++;
		}
    	count++;		
	}
	
	public void exit() {
		System.out.println("**********Exit************");
    	System.out.println("\n Ending the flow. Thank you !"); 
    	System.out.println("***************************");
	}
}
	
	


