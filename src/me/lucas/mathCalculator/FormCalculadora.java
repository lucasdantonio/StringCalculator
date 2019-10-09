package me.lucas.mathCalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormCalculadora extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton ponto;
	private JButton multiplicacao;
	private JButton subtracao;
	private JButton adicao;
	private JButton divisao;
	private JButton igual;
	private JButton c;
	private JTextField display;
	JButton[] numeros = new JButton[10];

	public FormCalculadora() {
		super("Calculadora");
		setSize(400, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		addActions();

		add(criaDisplay(), BorderLayout.NORTH);
		add(criaTeclado(), BorderLayout.CENTER);

		setVisible(true);
	}

	public JPanel criaDisplay() {
		JPanel displayPanel = new JPanel(new FlowLayout(100));

		display = new JTextField();
		display.setPreferredSize(new Dimension(385, 50));
		display.setEditable(false);

		displayPanel.add(display);

		return displayPanel;
	}

	public JPanel criaTeclado() {
		JPanel numPanel = new JPanel(new GridLayout(0, 4));

		for (int i = 9; i >= 0; i--) {
			String val = Integer.toString(i);
			numeros[i] = new JButton(val);
			numeros[i].addActionListener(e -> display.setText(display.getText() + val));
		}

		numPanel.add(numeros[7]);
		numPanel.add(numeros[8]);
		numPanel.add(numeros[9]);
		numPanel.add(divisao);
		numPanel.add(numeros[4]);
		numPanel.add(numeros[5]);
		numPanel.add(numeros[6]);
		numPanel.add(multiplicacao);
		numPanel.add(numeros[1]);
		numPanel.add(numeros[2]);
		numPanel.add(numeros[3]);
		numPanel.add(subtracao);
		numPanel.add(numeros[0]);
		numPanel.add(ponto);
		numPanel.add(igual);
		numPanel.add(adicao);
		numPanel.add(c);

		return numPanel;
	}

	public void addActions() {
		ponto = new JButton(".");
		ponto.addActionListener(e -> {
			display.setText(display.getText() + ".");
		});
		multiplicacao = new JButton("*");
		multiplicacao.addActionListener(e -> {
			display.setText(display.getText() + " * ");
		});

		divisao = new JButton("/");
		divisao.addActionListener(e -> {
			display.setText(display.getText() + " / ");
		});

		adicao = new JButton("+");
		adicao.addActionListener(e -> {
			display.setText(display.getText() + " + ");
		});

		subtracao = new JButton("-");
		subtracao.addActionListener(e -> {
			display.setText(display.getText() + " - ");
		});

		igual = new JButton("=");
		igual.addActionListener(e -> {
			String exibe = "";
			
			try {
				exibe = display.getText() + " = " + Cerebro.calc(display.getText());
			} catch (NumberFormatException ex) {
				exibe = "Erro de entrada: " + ex.getMessage();
			} catch (Exception ex) {
				exibe = "Erro: " + ex.getMessage();
			} finally {
				display.setText(exibe);
			}

		});

		c = new JButton("C");
		c.addActionListener(e -> {
			display.setText("");
		});
	}
}
