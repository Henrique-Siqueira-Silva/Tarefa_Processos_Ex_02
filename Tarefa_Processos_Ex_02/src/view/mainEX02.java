package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class mainEX02 {
	public static void main(String[] args) {
		KillController m = new KillController();
		String os = "";
		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"ESCOLHA A OPS \n 1 = Identifica SO \n 2 = Lista processos \n 3 = Mata por PID \n 4 = Mata por Nome \n 9 = FIM"));
			switch (opc) {
			case 1:
				os = m.os();
				System.out.println(os);
				System.out.println("");
				break;

			case 2:
				m.CallProcess(os, "TASKLIST /FO TABLE", "ps -ef");
				break;
				
			case 3:
				m.MataPid(os, "TASKKILL /PID ", "kill -9 ");
				break;
				
			case 4 :
				m.MataNome(os, "TASKKILL /IM ", "pkill -f ");
				
			case 9:
				System.out.println("FIM DO PROGRAMA");
				break;

			}
		}
	}
}
