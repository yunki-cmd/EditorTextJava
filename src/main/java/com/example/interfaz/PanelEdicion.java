package com.example.interfaz;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class PanelEdicion extends JPanel {
	private JScrollPane scrollPane;
	private JTextArea textEdicion;

	/**
	 * Create the panel.
	 */
	public PanelEdicion() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textEdicion = new JTextArea();
		scrollPane.setViewportView(textEdicion);

	}
	
	public String darContenido () {
		return textEdicion.getText();
	}
	
	public void refrescarContenido(String contenido) {
		this.textEdicion.setText(contenido);
	}
	
	
}
