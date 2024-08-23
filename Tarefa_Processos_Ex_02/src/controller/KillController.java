package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.Content;

public class KillController {

	public KillController() {
		super();
	}

	public String os() {

		String os = System.getProperty("os.name");
		return os;

	}

	public void CallProcess(String os, String ListaWin, String ListaLinux) {
		if (os == "") {
			System.out.println("Primeiro Identifique o Sistema Operacional");

		} else {
			if (os.contains("dows")) {
				try {
					Process p = Runtime.getRuntime().exec(ListaWin);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();

					while (linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();

					}
					System.out.println(" ");
					buffer.close();
					fluxo.close();
					leitor.close();
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println();
				}
			} else {
				try {
					Process p = Runtime.getRuntime().exec(ListaLinux);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();

					}
					System.out.println(" ");
					buffer.close();
					fluxo.close();
					leitor.close();
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println(msgErro);
				}
			}

		}
	}

	public void MataPid(String os, String MataWin, String MataLinux) {
		StringBuffer buffer = new StringBuffer();
		if (os == "") {
			System.out.println("Primeiro Identifique o Sistema Operacional");

		} else {
			if (os.contains("dows")) {
				try {
					int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID que deseja matar"));
					buffer.append(MataWin);
					buffer.append(pid);
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println();
				}
			} else {
				try {
					int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID que deseja matar"));
					buffer.append(MataLinux);
					buffer.append(pid);
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println();
				}
			}
		}
		String matar = buffer.toString();
		CallProcess(os, matar, matar);
			
	}

	public void MataNome(String os, String MataWin, String MataLinux) {
		StringBuffer buffer = new StringBuffer();
		if (os == "") {
			System.out.println("Primeiro Identifique o Sistema Operacional");

		} else {
			if (os.contains("dows")) {
				try {
					String pid = JOptionPane.showInputDialog("Digite o nome do processo que deseja matar");
					buffer.append(MataWin);
					buffer.append(pid);
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println();
				}
			} else {
				try {
					int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o nome do processo que deseja matar"));
					buffer.append(MataLinux);
					buffer.append(pid);
				} catch (Exception e) {
					String msgErro = e.getMessage();
					System.err.println();
				}
			}
		}
		String matar = buffer.toString();
		CallProcess(os, matar, matar);
			
	}

}
