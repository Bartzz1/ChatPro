package net.bartzz.chat;

public @interface TODO {
	
	String[] todoValue = { "" };
	
	String[] todoValue() default { "" };
}
