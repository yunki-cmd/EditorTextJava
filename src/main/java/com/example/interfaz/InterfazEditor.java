package com.example.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.Editor;

public class InterfazEditor extends JFrame {

	private JPanel contentPane;
	private PanelAcciones panelAcciones;
	private PanelEdicion panelEdicion;
	private Editor editor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEditor frame = new InterfazEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazEditor() {
		editor = new Editor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelAcciones = new PanelAcciones(this);
		contentPane.add(panelAcciones, BorderLayout.NORTH);
		
		panelEdicion = new PanelEdicion();
		contentPane.add(panelEdicion, BorderLayout.CENTER);
	}
	
	public void abrirArchivo() {
		JFileChooser jf = new JFileChooser();
		if(jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File archivo = jf.getSelectedFile();
			String contenido ="";
			try {				
				contenido = editor.openFile(archivo.getAbsolutePath());
				panelEdicion.refrescarContenido(contenido);
			}catch (Exception e){
				JOptionPane.showMessageDialog(this, e.getMessage(),"Editor simple de archivos",JOptionPane.ERROR_MESSAGE);
			}
		}
				
	}
	public void crearArchivo() {
		editor.newFile();
		panelEdicion.refrescarContenido("");
	}
	public void guardarArchivo() {
		if(this.editor.esnuevo()) {
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				String rutaArchivo = fc.getSelectedFile().getAbsolutePath();
				String contenido = panelEdicion.darContenido();
				try {
					editor.saveFile(contenido, rutaArchivo);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage(),"Editor simple de archivos",JOptionPane.ERROR_MESSAGE);
				}
			}
		}else {
			String contenido = panelEdicion.darContenido();
			try {
				editor.saveFile(contenido, null);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Editor simple de archivos",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
}
