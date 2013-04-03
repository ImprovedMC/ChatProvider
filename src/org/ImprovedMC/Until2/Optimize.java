package org.ImprovedMC.Until2;

public @interface Optimize {

	enum Priority { LOW, NORMAL, HIGH }
	String value() default "Command";
	String[] assignedTo() default "/info";
	Priority priority();
	
}
