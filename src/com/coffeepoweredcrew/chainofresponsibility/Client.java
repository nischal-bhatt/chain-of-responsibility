package com.coffeepoweredcrew.chainofresponsibility;

import java.time.LocalDate;

import com.coffeepoweredcrew.chainofresponsibility.LeaveApplication.Type;

public class Client {

	public static void main(String[] args) {
	    LeaveApplication application = LeaveApplication.getBuilder().withType(Type.Sick)
	    		.from(LocalDate.now()).to(LocalDate.of(2022,4,11))
	    		.build();
	    System.out.println(application);
	    System.out.println("------------------");
	    LeaveApprover approver = createChain();
	    approver.processLeaveApplication(application);
	    System.out.println(application);
	}
	
	private static LeaveApprover createChain()
	{
		Director director = new Director(null);
		Manager manager = new Manager(director);
		ProjectLead lead = new ProjectLead(manager);
		
		return lead;
	}

	
}
