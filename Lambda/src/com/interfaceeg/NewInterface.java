/**
 * 
 */
package com.interfaceeg;

/**
 * @author kapilbhatnagar
 *
 */
public interface NewInterface {

	public abstract String doIt();
	
	default void doIt2(){
		
	}
	
	static void doIt3(){
		//With definition
	}
}
