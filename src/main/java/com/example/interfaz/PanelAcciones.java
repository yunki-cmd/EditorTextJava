package com.example.interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelAcciones extends JPanel implements ActionListener{
	
	
	public static final String ABRIR = "ABRIR";
	public static final String CREAR = "CREAR";
	public static final String GUARDAR = "GUARDAR";
	
	private JButton btnAbrir;
	private JButton btnGuardar;
	private InterfazEditor principal;
	private JButton btnCrear;

	/**
	 * Create the panel.
	 */
	
	//muestre los elementos porque es un panel activo
	public PanelAcciones(InterfazEditor principal) {
		this();
		this.principal = principal;
	}
	
	public PanelAcciones() {
		setLayout(new GridLayout(1, 0, 2, 0));
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.setActionCommand(ABRIR);
		btnAbrir.addActionListener(this);
		add(btnAbrir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this);
		add(btnGuardar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setActionCommand(CREAR);
		btnCrear.addActionListener(this);
		add(btnCrear);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals(ABRIR)) {
			principal.abrirArchivo();
		}else if(evento.getActionCommand().equals(CREAR)) {
			principal.crearArchivo();
		}else if(evento.getActionCommand().equals(GUARDAR)) {
			principal.guardarArchivo();
		}
		
	}
	
	

}
