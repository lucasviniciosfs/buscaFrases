package br.com.lucas.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		while(true){
			Scanner leitor = new Scanner (System.in);
			System.out.println("Digite o código da frase: ");
			String mensagem = leitor.nextLine();
			InetAddress addr = InetAddress.getByName("localhost"); //nome do host destino
			int port = Integer.parseInt("12345");
			byte[] msg = mensagem.getBytes();
			// Monta o pacote a ser enviado
			DatagramPacket pkg = new DatagramPacket(msg, msg.length, addr, port);
			// Cria o DatagramSocket que será responsável por enviar a mensagem
			DatagramSocket ds = new DatagramSocket();
			ds.send(pkg); // Envia a mensagem
			System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n"
			+ "Porta: " + port + "\n" + "Mensagem: " + new String(msg) );			
			ds.close();
		}
	}

}
