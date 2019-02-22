package codigo;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fazer {
	double num1, num2, resultado;

	// Muda a cor do JTEXTFIELD de acordo com o valor recebido (double)
	public void mudaCor(double c, JTextField v) {
		// bota o texto com a cor preta
		v.setDisabledTextColor(Color.BLACK);
		// verifica se o valor esta na media, e pinta o JTEXTFIELD de verde
		if (c >= 5 && c <= 10) {
			v.setBackground(new Color(0, 255, 0));
		} 
		else if (c == 404) {
			v.setText("");
			v.setBackground(new Color(255, 255, 255));
		}
		// caso o valor não esteja na media, pinta o JTEXTFIELD de vermelho
		else {
			v.setBackground(new Color(255, 77, 77));
		}
	}

	public void salvarpts(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/ptsavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public void salvarpp(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/ppavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public void salvarae(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/aeavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public void salvarpe(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/peavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public void salvarpvt(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/pvtavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public void salvarpt(JTextField[] campos) throws IOException {
		String path = System.getProperty("user.home");
		FileWriter cria = new FileWriter(path + "/ptavancado.txt");
		BufferedWriter gravarArq = new BufferedWriter(cria);
		for (int i = 0; i < campos.length; i++) {
			String valor = campos[i].getText();
			gravarArq.write(valor);
			gravarArq.newLine();
		}
		gravarArq.close();
		cria.close();
	}

	public String calculaFinalDaDisciplina(JTextField x, JTextField y, JTextField prova) {

		String entradaX = x.getText();
		double valorX = Double.parseDouble(entradaX.replace(',', '.'));
		String entradaY = y.getText();
		double valorY = Double.parseDouble(entradaY.replace(',', '.'));
		String entradaProva = prova.getText();
		double valorProva = Double.parseDouble(entradaProva.replace(',', '.'));

		double result = (valorX + valorY + (2 * valorProva)) / 4;
		String resultadoEmTexto = String.format("%.1f", result);
		return resultadoEmTexto;
	}

	public String notaFinaldoModulo(JTextField webI, JTextField webII, JTextField bancoDados,
			JTextField dispositivosMovies) {
		String entradaWEBII = webII.getText();
		double valorWEBII = Double.parseDouble(entradaWEBII.replace(',', '.'));
		String entradaWEBI = webI.getText();
		double valorWEBI = Double.parseDouble(entradaWEBI.replace(',', '.'));
		String entradaBANCODEDADOS = bancoDados.getText();
		double valorBANCODEDADOS = Double.parseDouble(entradaBANCODEDADOS.replace(',', '.'));
		String entradaDISPOSITIVOS = dispositivosMovies.getText();
		double valorDISPOSITIVOS = Double.parseDouble(entradaDISPOSITIVOS.replace(',', '.'));

		double result = ((valorBANCODEDADOS * 80) + (valorWEBI * 60) + (valorDISPOSITIVOS * 60) + (valorWEBII * 60))
				/ 260;
		String resultadoEmTexto = String.format("%.1f", result);
		return resultadoEmTexto;
	}

	public String calculaNotasSemanais(JTextField x, JTextField y) {
		if (x.getText().trim().equals("") || y.getText().trim().equals("")) {
			return "404";
		} else {
			String entradaX = x.getText();
			double valorX = Double.parseDouble(entradaX.replace(',', '.'));
			String entradaY = y.getText();
			double valorY = Double.parseDouble(entradaY.replace(',', '.'));
			resultado = (valorX + valorY) / 2;
			resultado = Double.valueOf(String.format(Locale.US, "%.1f", resultado));
			String resultadoEmTexto = "" + resultado;
			return resultadoEmTexto;
		}
	}

	public void selecionaTodoConteudo(JTextField x, JTextField y) {
		y.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				// coloca o foco no componente
				y.requestFocus();
				// seleciona todo o conte�do
				y.selectAll();
			}
		});
		x.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				// coloca o foco no componente
				x.requestFocus();
				// seleciona todo o conte�do
				x.selectAll();
			}
		});
	}

	// ---------------------Limpa todos os campos do JPANEL Notas
	// semanais------------
	public void limparCampos(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("0");
				((JTextField) component).setBackground(new Color(255, 255, 255));
			}
		}
	}
}