package com.bugfix.jutil.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.bugfix.jutil.net.NetUtil;
import com.bugfix.jutil.validation.Validator;

public class SocketServer {
	
	private static ServerSocket serverSocket = null;
	 
	public static boolean listen(String hostAddress, int port) throws Exception{
		if(Validator.isEmpty(hostAddress)){
			throw new Exception("Host Address \""+hostAddress+"\" inputted is invalid to create a ServerSocket!!!");
		}
		
		if(!NetUtil.isHostAddressAvailable(hostAddress)){
			throw new Exception("Host Address \""+hostAddress+"\" inputted is not available to create a ServerSocket");
		}
		
		if(Validator.isValidPortNumber(port)){
			throw new Exception("Port number \""+port+"\" (1024-65535) inputted is invalid to create a ServerSocket");
		}
		
		serverSocket = new ServerSocket(port);
		InetSocketAddress inetSocketAddress = new InetSocketAddress(NetUtil.getInetAddress(hostAddress), port);
		serverSocket.bind(inetSocketAddress);
		if(serverSocket.isBound()){
			return true;
		}
		return false;
	}
	
	public static Socket connect(){
		try {
			Socket childSocket = serverSocket.accept();
			if(childSocket.isConnected()){
				return childSocket;
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public static String readSocket(Socket socket){
		if(!socket.isConnected()){
			System.err.println("Client ["+socket+"] disconnected");
		}
		return null;
	}
	
	public static boolean writeToSocket(String message){
		return true;
	}
}
