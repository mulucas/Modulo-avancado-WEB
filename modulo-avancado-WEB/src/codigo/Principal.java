package codigo;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField pp[];
	private JTextField pvt[];
	private JTextField pts[];
	private JTextField ae[];
	private JTextField pe[];
	private JTextField pt[];
	private JTextField finalDisciplina[];
	private JLabel semanas[];
	private JLabel disciplina[];
	private JLabel aeptpefinal[];
	private JTextField tffinalModulo;
	JButton btnCalcularModulo = new JButton("Calcular Modulo");
	JButton btnCalcularPt = new JButton("CALCULAR P.T");
	JButton btnLimparTudo = new JButton("LIMPAR TUDO");
	JPanel panel;
	FileReader abrir;
	BufferedReader ler;
	InputStream in;
	Fazer fazer = new Fazer();

	FileReader arquivo;
	BufferedReader lerArquivo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
	}

	public Principal() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("CALCULA NOTAS DO AVANÇADO WEB"); // 9996-4397

		ImageIcon icone = new ImageIcon(getClass().getResource("/dados/calculadora.png"));
		setIconImage(icone.getImage());

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(357, 219, 300, 129);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		ImageIcon logo = new ImageIcon(getClass().getResource("/dados/imd.jpg"));
		JLabel lblNewLabel_4 = new JLabel(logo);
		panel_1.add(lblNewLabel_4);

		// --------------------JPANEL--NOTAS--SEMANAIS----------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 43, 740, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		// -----------------------------------------------------------------------------------
		JLabel lblNotasSemanais = new JLabel("NOTAS SEMANAIS");
		lblNotasSemanais.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNotasSemanais.setBounds(265, 0, 173, 43);
		panel.add(lblNotasSemanais);
		// --------------------JLABEL--NOTAS--SEMANAIS----------------------------------------
		JLabel lblNewLabel = new JLabel("SEMANAS");
		lblNewLabel.setBounds(5, 42, 60, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("P.P");
		lblNewLabel_1.setBounds(10, 60, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("P.V.T");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("P.T");
		lblNewLabel_3.setBounds(10, 100, 46, 14);
		panel.add(lblNewLabel_3);
		// -------------------------PP---------JTextField---------------------------------------
		pp = new JTextField[20];
		int cont = 0;
		this.setLayout(null);
		for (int i = 0; i < pp.length; i++) {
			cont += 33;
			pp[i] = new JTextField();
			pp[i].setColumns(10);
			pp[i].setBounds(33 + cont, 60, 30, 17);
			pp[i].setVisible(true);
			panel.add(pp[i]);
		}
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			FileReader arquivo = new FileReader(path + "/ppavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				pp[i].setText(linha);
				i++;
			}
			lerArquivo.close();
			arquivo.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// -------------------------PVT--------JTextField----------------------------------------
		pvt = new JTextField[20];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < pvt.length; i++) {
			cont += 33;
			pvt[i] = new JTextField();
			pvt[i].setColumns(10);
			pvt[i].setBounds(33 + cont, 80, 30, 17);
			pvt[i].setVisible(true);
			panel.add(pvt[i]);
			abrir = null;
			ler = null;
		}
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			FileReader arquivo = new FileReader(path + "/pvtavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				pvt[i].setText(linha);
				i++;
			}
			lerArquivo.close();
			arquivo.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// -------------------------ptss-------------JTextField-------------------------------------
		pts = new JTextField[20];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < pts.length; i++) {
			cont += 33;
			pts[i] = new JTextField();
			pts[i].setColumns(10);
			pts[i].setBounds(33 + cont, 100, 30, 17);
			pts[i].setVisible(true);
			pts[i].setEnabled(false);
			panel.add(pts[i]);
		}
		abrir = null;
		ler = null;
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			System.out.println(path);
			FileReader arquivo = new FileReader(path + "/ptsavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				pts[i].setText(linha);
				i++;
			}
			lerArquivo.close();
			arquivo.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// -------------------------JLABEL--DAS--SEMANAS-------------------------------------------
		semanas = new JLabel[20];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < semanas.length; i++) {//esse if e else serve para alinhar as S1 S2 S3 S4 ....
			if (i >= 9) {
				semanas[i] = new JLabel("S" + (i + 1));
				semanas[i].setBounds(74 + cont, 40, 26, 17);
				cont += 32;
			} else {
				semanas[i] = new JLabel("S" + (i + 1));
				semanas[i].setBounds(74 + cont, 40, 26, 17);
				cont += 33;
			}
			panel.add(semanas[i]);
		}
		// -------------------------JLABEL--DAS--disciplina-----------------------------------------
		disciplina = new JLabel[5];
		cont = 0;
		this.setLayout(null);
		disciplina[0] = new JLabel("DISCIPLINA");
		disciplina[1] = new JLabel("Desenvolvimento I");
		disciplina[2] = new JLabel("Desenvolvimento II");
		disciplina[3] = new JLabel("Banco de Dados");
		disciplina[4] = new JLabel("Dispositivos Móveis");
		for (int i = 0; i < disciplina.length; i++) {
			disciplina[i].setBounds(10, 219 + cont, 135, 15);
			disciplina[i].setFont(new Font("Tahoma", Font.BOLD, 12));
			cont += 16;
			contentPane.add(disciplina[i]);
		}
		// -------------------------JLABEL--DAS--disciplina----------------------------------------
		aeptpefinal = new JLabel[4];
		cont = 0;
		this.setLayout(null);
		aeptpefinal[0] = new JLabel("AE");
		aeptpefinal[1] = new JLabel("PT");
		aeptpefinal[2] = new JLabel("PE");
		aeptpefinal[3] = new JLabel("FINAL");
		for (int i = 0; i < aeptpefinal.length; i++) {
			aeptpefinal[i].setBounds(157 + cont, 219, 19, 15);
			aeptpefinal[i].setFont(new Font("Tahoma", Font.BOLD, 12));
			cont += 32;
			contentPane.add(aeptpefinal[i]);
		}
		aeptpefinal[3].setBounds((157 + cont) - 32, 219, 40, 15);
		// -------------------------AE---------JTextField-----------------------------------------
		ae = new JTextField[4];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < ae.length; i++) {
			ae[i] = new JTextField();
			ae[i].setColumns(10);
			ae[i].setBounds(152, 232 + cont, 30, 17);
			cont += 17;
			ae[i].setVisible(true);
			contentPane.add(ae[i]);
		}
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			FileReader arquivo = new FileReader(path + "/aeavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				ae[i].setText(linha);
				i++;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// -------------------------PT---------JTextField-----------------------------------------
		pt = new JTextField[4];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < pt.length; i++) {
			pt[i] = new JTextField();
			pt[i].setColumns(10);
			pt[i].setBounds(184, 232 + cont, 30, 17);
			cont += 17;
			pt[i].setVisible(true);
			pt[i].setEnabled(false);
			pt[i].setDisabledTextColor(Color.BLACK);
			contentPane.add(pt[i]);
		}
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			FileReader arquivo = new FileReader(path + "/ptavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				pt[i].setText(linha);
				double r = Double.parseDouble(linha.replace(",", "."));
				fazer.mudaCor(r, pt[i]);
				i++;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// -------------------------PE---------JTextField------------------------------------------
		pe = new JTextField[4];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < pe.length; i++) {
			pe[i] = new JTextField();
			pe[i].setColumns(10);
			pe[i].setBounds(218, 232 + cont, 30, 17);
			cont += 17;
			pe[i].setVisible(true);
			contentPane.add(pe[i]);
		}
		try {
			int i = 0;
			String path = System.getProperty("user.home");
			FileReader arquivo = new FileReader(path + "/peavancado.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			String linha;
			while ((linha = lerArquivo.readLine()) != null) {
				pe[i].setText(linha);
				i++;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// -------------------------Final das
		// Disciplina---------JTextField------------------------------
		finalDisciplina = new JTextField[4];
		cont = 0;
		this.setLayout(null);
		for (int i = 0; i < finalDisciplina.length; i++) {
			finalDisciplina[i] = new JTextField();
			finalDisciplina[i].setColumns(10);
			finalDisciplina[i].setBounds(254, 232 + cont, 30, 17);
			cont += 17;
			finalDisciplina[i].setVisible(true);
			finalDisciplina[i].setEnabled(false);
			finalDisciplina[i].setDisabledTextColor(Color.BLACK);
			contentPane.add(finalDisciplina[i]);
		}
		// ------------------------BOTOES----------------------------------------------------------------
		btnLimparTudo.setBounds(370, 131, 120, 25);
		btnLimparTudo.addActionListener(this);
		panel.add(btnLimparTudo);

		btnCalcularPt.setBounds(240, 131, 120, 25);
		btnCalcularPt.addActionListener(this);
		panel.add(btnCalcularPt);

		btnCalcularModulo.setBounds(90, 378, 137, 23);
		contentPane.add(btnCalcularModulo);
		btnCalcularModulo.addActionListener(this);
		// ---------------------------------------------------------------------------------------------
		JLabel lblFinalModulo = new JLabel("FINAL");
		lblFinalModulo.setBounds(99, 353, 46, 14);
		contentPane.add(lblFinalModulo);

		tffinalModulo = new JTextField();
		tffinalModulo.setBounds(141, 353, 46, 17);
		contentPane.add(tffinalModulo);
		tffinalModulo.setColumns(10);
		tffinalModulo.setDisabledTextColor(Color.BLACK);
		tffinalModulo.setEnabled(false);

		JLabel lblSistemaDesenvolvidoPor = new JLabel(
				"Programa Desenvolvido por LUCAS QUEIROZ - lukasqueiroz54@gmail.com");
		lblSistemaDesenvolvidoPor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSistemaDesenvolvidoPor.setBounds(314, 406, 370, 14);
		contentPane.add(lblSistemaDesenvolvidoPor);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});
		// -------------------------SELECIONAR--tudo--O--CONTEUDO--SOZINHO------------------------------
		for (int i = 0; i < pp.length; i++) {
			fazer.selecionaTodoConteudo(pp[i], pvt[i]);
		}
		for (int i = 0; i < ae.length; i++) {
			fazer.selecionaTodoConteudo(ae[i], pe[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnCalcularModulo) {
			for (int i = 0; i < 4; i++) {
				String m = ae[i].getText();
				if (m.isEmpty()) {
					ae[i].setText("0");
				}
				m = pe[i].getText();
				if (m.isEmpty()) {
					pe[i].setText("0");
				}
				finalDisciplina[i].setText(fazer.calculaFinalDaDisciplina(ae[i], pt[i], pe[i]));
			}
			try {
				fazer.salvarae(ae);
				fazer.salvarpe(pe);
			} catch (IOException erro) {
				erro.printStackTrace();
			}
			tffinalModulo.setText(fazer.notaFinaldoModulo(finalDisciplina[0], finalDisciplina[1], finalDisciplina[2],
					finalDisciplina[3]));
			String entradaX = tffinalModulo.getText();
			double valorX = Double.parseDouble(entradaX.replace(',', '.'));
			fazer.mudaCor(valorX, tffinalModulo);
			// --------------------------metodo para calcular a nota do modulo
		} else if (o == btnCalcularPt) {
			/*
			 * ----------Calcula pts
			 */
			for (int i = 0; i < pts.length; i++) {
				String m = pp[i].getText();
				if (m.isEmpty()) {
					pp[i].setText("0");
				}
				m = pvt[i].getText();
				if (m.isEmpty()) {
					pvt[i].setText("0");
				}
				pts[i].setText(fazer.calculaNotasSemanais(pvt[i], pp[i]));
				double r = Double.parseDouble(pts[i].getText());
				fazer.mudaCor(r, pts[i]);
			}
			/*--------ESTAO NA ORDEM DE POSICAO NA TELA  
			 *------------------- WEB I----------------------------
			 */
			double valor1 = 0, resultado = 0;
			for (int i = 0; i < 10; i++) {
				valor1 = Double.parseDouble(pts[i].getText());
				resultado += valor1;
			}
			valor1 = resultado / 10;
			String resultadoEmTexto = String.format("%.1f", valor1);
			pt[0].setText(resultadoEmTexto);
			fazer.mudaCor(valor1, pt[0]);
			/*
			 * -------------------WEB II----------------------------
			 */
			valor1 = 0;
			resultado = 0;
			resultadoEmTexto = "";
			for (int i = 10; i < 20; i++) {
				valor1 = Double.parseDouble(pts[i].getText());
				resultado += valor1;
			}
			valor1 = resultado / 10;
			resultadoEmTexto = String.format("%.1f", valor1);
			pt[1].setText(resultadoEmTexto);
			fazer.mudaCor(valor1, pt[1]);
			/*
			 * ------------ BANCO DE DADOS---------------------
			 */
			valor1 = 0;
			resultado = 0;
			resultadoEmTexto = "";
			for (int i = 0; i < 12; i++) {
				valor1 = Double.parseDouble(pts[i].getText());
				resultado += valor1;
			}
			valor1 = resultado / 12;
			resultadoEmTexto = String.format("%.1f", valor1);
			pt[2].setText(resultadoEmTexto);
			fazer.mudaCor(valor1, pt[2]);
			/*
			 * ---------DISPOSITIVOS MOVEIS------------------
			 */
			valor1 = 0;
			resultado = 0;
			resultadoEmTexto = "";
			for (int i = 12; i < 20; i++) {
				valor1 = Double.parseDouble(pts[i].getText());
				resultado += valor1;
			}
			valor1 = resultado / 8;
			resultadoEmTexto = String.format("%.1f", valor1);
			pt[3].setText(resultadoEmTexto);
			fazer.mudaCor(valor1, pt[3]);

			salvaNotasSemanais();
		} else if (o == btnLimparTudo) {
			String message = "Deseja realmente limpar todos os campos ?";
			String title = "Confirmação";
			int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				fazer.limparCampos(panel);
				try {
					fazer.salvarpp(pp);
					fazer.salvarpvt(pvt);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} // https://pt.stackoverflow.com/questions/38387/como-passar-um-array-para-um-jtexfield
	}

	private void salvaNotasSemanais() {
		try {
			fazer.salvarpp(pp);
			fazer.salvarpvt(pvt);
			fazer.salvarpts(pts);
			fazer.salvarpt(pt);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}