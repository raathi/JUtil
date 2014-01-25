package com.bugfix.jutil.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ReadSocketThread implements Callable<String>{
	
	private final Socket socket;
	
	public ReadSocketThread(Socket socketToRead){
		this.socket = socketToRead;
	}

	@Override
	public String call() throws Exception {
		BufferedReader bufferedReader =  null;
		if(socket.isConnected()){
			try{
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
