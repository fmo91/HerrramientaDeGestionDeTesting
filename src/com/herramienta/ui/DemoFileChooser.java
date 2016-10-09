package com.herramienta.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.herramienta.core.MiFiltroArchivo;

import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("serial")
public class DemoFileChooser extends javax.swing.JFrame {

	/**
	 * Creates new form DemoFileChooser
	 */
	public DemoFileChooser()
	{
		setTitle("Testing Tool");
		initComponents();
		
		archivoAbierto = false;
	}

	private List<String> codigo;
	private int complejidadCiclomatica = 0;
	private int valorCC;
	private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorTextArea = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        abrirArchivoButton = new javax.swing.JButton();
        SalirButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrirMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();


        fileChooser.setFileFilter(new MiFiltroArchivo());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editorTextArea.setColumns(20);
        editorTextArea.setRows(5);
        jScrollPane1.setViewportView(editorTextArea);

        jToolBar1.setRollover(true);

        abrirArchivoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("./abrir grande.png"))); // NOI18N
        abrirArchivoButton.setFocusable(false);
        abrirArchivoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirArchivoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrirArchivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuItemActionPerformed(evt);
            }
        });
        jToolBar1.add(abrirArchivoButton);

        SalirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("./salir grande.png"))); // NOI18N
        SalirButton.setFocusable(false);
        SalirButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SalirButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jToolBar1.add(SalirButton);

        jMenu1.setText("Archivo");

        abrirMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        abrirMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("./abrir chico.png"))); // NOI18N
        abrirMenuItem.setText("Abrir");
        abrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(abrirMenuItem);

        salirMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        salirMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("./salir chico.png"))); // NOI18N
        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_abrirMenuItemActionPerformed
    {//GEN-HEADEREND:event_abrirMenuItemActionPerformed
        int ret = fileChooser.showOpenDialog(this);
		
		if(ret != JFileChooser.APPROVE_OPTION)
			return;
		
		archFile = fileChooser.getSelectedFile();
		
		FileReader fr;
		
		try
		{
			fr = new FileReader(archFile);
			this.setTitle(archFile.getAbsolutePath());
		}
		catch(FileNotFoundException ex)
		{
			JOptionPane.showMessageDialog(this, ex.getMessage(), "El Archivo no existe", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try
		{/*
			int cantif =0;
			int cantwhile =0;
			int cntcase =0;
			int cantfor=0;*/
			int cantLineas = 0;

			this.complejidadCiclomatica = 0;
			String line;
			BufferedReader br = new BufferedReader(fr);
			this.codigo= new ArrayList<String>();
		    
			while ((line = br.readLine()) != null) {
		    	   cantLineas++;
		    	   this.codigo.add(line);
							
		       }
		       this.procesar(codigo);
			
			
			editorTextArea.setText("El archivo fuente tiene "+cantLineas+" lineas\n"+
								   "Complejidad ciclomatica: "+this.valorCC+"\n");


			fr.close();
			archivoAbierto = true;
		}
		catch(IOException ex)
		{
			try
			{
				fr.close();
			}
			catch(IOException ex1)
			{}
			
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error en lectura de Archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		
    }//GEN-LAST:event_abrirMenuItemActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_salirMenuItemActionPerformed
    {//GEN-HEADEREND:event_salirMenuItemActionPerformed
		System.exit(0);
    }//GEN-LAST:event_salirMenuItemActionPerformed
    
    public void procesar(List<String> lineasArchivo) {

        //La complejidad ciclomatica mi­nima.
        this.valorCC = 1;
        //Listado de palabras que representan un salto en el curso de decision.
        String keywords[] = {"if", "else", "case", "default", "for", "while", "catch", "throw"};
        String condiciones[] = {"&&", "||"};
        int cantidad;
        
        for (String linea : lineasArchivo) {
            if (linea.matches(".*\\W*(if|else|case|default|while|for|catch|throw)\\W.*")) {
            	for(String palabra : keywords) {
		        	cantidad = (linea.length() - linea.replace(palabra, "").length()) / palabra.length();
		        	if(cantidad > 0) {
		        		valorCC += cantidad;
		        	}
            	}
            }
            
            if (linea.matches(".*(&&|\\|\\|).*")) {
            	for(String simbolo : condiciones) {
            		cantidad = (linea.length() - linea.replace(simbolo, "").length()) / simbolo.length();
		        	if(cantidad > 0) {
		        		valorCC += cantidad;
		        	}
            	}
            }
        }
}
	public static void main(String args[])
	{
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch(ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(DemoFileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch(InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(DemoFileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch(IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(DemoFileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch(javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(DemoFileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoFileChooser fchooser = new DemoFileChooser();
				fchooser.setBounds(100, 100, 700, 500);
				fchooser.editorTextArea.setEnabled(false);
				fchooser.setVisible(true);
				
			}
		});
	}
	
	private File archFile;
	private boolean archivoAbierto;
    private javax.swing.JButton SalirButton;
    private javax.swing.JButton abrirArchivoButton;
    private javax.swing.JMenuItem abrirMenuItem;
    private javax.swing.JTextArea editorTextArea;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem salirMenuItem;
}
