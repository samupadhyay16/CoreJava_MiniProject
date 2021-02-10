package n2s.ehc.samprati;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMain{
	public static UserBean ub=new UserBean();
	public static UserOptions uo=new UserOptions(); 
	public static UserExceptions ue = new UserExceptions();
	public static Scanner scan = new Scanner(System.in);
	public static int ch;
	public static boolean in_flag=true;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		while(in_flag)
		    try {
			do
			{	
			    System.out.println("\n Choose the option below");
			    System.out.println("-------------------------------");
			    System.out.println("\n 1: Insert \n 2: Update \n 3: Delete \n 4: View \n 5: Exit \n");
		            System.out.println("Enter your option:");
			    ch=ub.setOptionValue(scan.nextInt());
			    if(ue.validateOption(ch)) {
			    	in_flag=false;
			    }
			    switch(ch)
			    {
			    	case 1:
			    		uo.insert(scan);
			    		break;
			        case 2:  
			        	uo.update(scan);
			        	break;
			        case 3:  
			            	uo.delete(scan);
			            	break;
			        case 4:
			        	uo.view();
			        	break;
			        case 5:
			        	uo.exit();
			        	scan.close();
			        	System.exit(0);
			        	break;
			     }
	        	}while(ch!=5);  
		}catch(InvalidEntry e) {
			System.out.println(e.toString());
		}catch (InputMismatchException ie) {
            		System.out.println(ie.toString());
            		scan.nextLine();
        	}
	}
}
