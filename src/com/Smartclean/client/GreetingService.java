package com.Smartclean.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String[][] getappoint(String s) throws IllegalArgumentException;
	String[][] getappointtd(String s,String s1) throws IllegalArgumentException;
	int gettfee(String s,String s1)throws IllegalArgumentException;
	String[] getpatient(int no,String s)throws IllegalArgumentException;
	String insert(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String s12)throws IllegalArgumentException;
	String[] check(String s1,String s2) throws IllegalArgumentException;
	String insertdc(String s1,String s2,String s3,String s4,String s5,String s6)throws IllegalArgumentException;
	int regclinic(String s1,String s2,String s3,String s4)throws IllegalArgumentException;
	int validclinic(String s1,String s2)throws IllegalArgumentException;
}