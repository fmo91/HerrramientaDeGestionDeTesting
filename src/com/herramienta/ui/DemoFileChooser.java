package com.herramienta.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.herramienta.core.MiFiltroArchivo;
import com.herramienta.model.CodeMetric;
import com.herramienta.model.Method;
import com.herramienta.services.CodeInspectionService;
import com.herramienta.services.CodeLinesNumberInspectionService;
import com.herramienta.services.CommentedLinesInspectionService;
import com.herramienta.services.CyclomaticComplexityInspectionService;
import com.herramienta.services.FanInInspectionService;
import com.herramienta.services.FanOutInspectionService;
import com.herramienta.services.HalsteadInspectionService;
import com.herramienta.utils.MethodFinder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;



@SuppressWarnings("serial")
public class DemoFileChooser extends javax.swing.JFrame {

	// ATTRIBUTES -
	private List<CodeInspectionService> servicios;
	private MethodFinder methodFinder;
	private File archFile;
	
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
    private javax.swing.JList<String> methodsList; 
    private javax.swing.JTextArea codeTextArea;
	
	/**
	 * Creates new form DemoFileChooser
	 */
	public DemoFileChooser()
	{
		setTitle("Testing Tool");
		initComponents();
	}

	/**
	 * Initializes all components in the class
	 * */
	private void initComponents() {

        fileChooser			= new javax.swing.JFileChooser();
        jScrollPane1 		= new javax.swing.JScrollPane();
        editorTextArea 		= new javax.swing.JTextArea();
        jToolBar1 			= new javax.swing.JToolBar();
        abrirArchivoButton 	= new javax.swing.JButton();
        SalirButton 		= new javax.swing.JButton();
        jMenuBar1 			= new javax.swing.JMenuBar();
        jMenu1 				= new javax.swing.JMenu();
        abrirMenuItem 		= new javax.swing.JMenuItem();
        salirMenuItem 		= new javax.swing.JMenuItem();


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
        
        codeTextArea = new JTextArea();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(codeTextArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        				.addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(codeTextArea, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);
        
        this.methodsList = new JList<String>();
        
        this.methodsList.addListSelectionListener(new ListSelectionListener() {
			
        	// Esta funcion se va a ejecutar cada vez que se cambie el estado
        	// de seleccion de la list.
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedIndex = methodsList.getSelectedIndex();
				
				if (selectedIndex == -1) {
					// Si es -1, es porque no hay nada seleccionado
					return;
				}
				
				// En este caso ya sabemos que hay algo que esta 
				// seleccionado, de modo que podemos obtener el metodo seleccionado!
				Method selectedMethod = methodFinder.getMethods().get(selectedIndex);
				
				servicios = new ArrayList<CodeInspectionService>();
				
				// Agregamos todos los servicios que necesitamos para analizar el codigo.
				// Cada vez que el programa pase por una linea, la enviará
				// a todos los servicios que esten registrados.
				// Los servicios entonces van a procesar esa linea y van a registrar
				// los resultados en un objeto CodeMetric.
				
				// Con este servicio contamos las lineas de codigo.
				servicios.add(new CodeLinesNumberInspectionService());
				
				// Contamos las lineas comentadas
				servicios.add(new CommentedLinesInspectionService());
				
				// Contamos la complejidad ciclomatica
				servicios.add(new CyclomaticComplexityInspectionService());
				
				// Contamos Halstead (?) quizas esto tengamos que separarlo en 
				// otros servicios mas pequeños, porque hay varias metricas de halstead
				servicios.add(new HalsteadInspectionService());
				
				// Contamos el Fan In del metodo seleccionado
				// Fan in es la cantidad de veces que ese metodo
				// es invocado desde afuera
				servicios.add(new FanInInspectionService(methodFinder.getMethods(), selectedMethod));
				
				// Contamos el Fan Out del metodo seleccionado
				// Fan out es la cantidad de veces que el metodo seleccionado
				// llama a otros metodos.
				servicios.add(new FanOutInspectionService(methodFinder.getMethods(), selectedMethod));
				
				Iterator<String> methodLinesIterator = selectedMethod.getLines().iterator();
				while(methodLinesIterator.hasNext()) {
					String line = methodLinesIterator.next();
					for (CodeInspectionService servicio : servicios) {
						servicio.analyzeLine(line);
					}
				}
				
				StringBuffer sb = new StringBuffer();
				for (CodeInspectionService servicio : servicios) {
					CodeMetric metrica = servicio.getMetric();
					sb.append(metrica.getName() + ": " + metrica.getValue() + "\n");
				}
				editorTextArea.setText(sb.toString());
				
				// Imprimimos el codigo en pantalla
				// para mostrar el metodo que estamos analizando.
				codeTextArea.setText(selectedMethod.toString());
				
			}
		});
        
        jScrollPane1.setColumnHeaderView(methodsList);

        pack();
    }// </editor-fold>//GEN-END:initComponents


	// EVENT LISTENERS -
    private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt)
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
		{
			String line;
			BufferedReader br = new BufferedReader(fr);
		    
			this.methodFinder = new MethodFinder();
			
			while ((line = br.readLine()) != null) {
				this.methodFinder.processLine(line);
			}
			
			this.methodsList.setListData(this.methodFinder.getMethodsNamesList());
			fr.close();
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
	private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_salirMenuItemActionPerformed
		System.exit(0);
    }//GEN-LAST:event_salirMenuItemActionPerformed

	/**
	 * Main method
	 * */
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
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DemoFileChooser fchooser = new DemoFileChooser();
				fchooser.setBounds(100, 100, 700, 500);
				fchooser.editorTextArea.setEnabled(false);
				fchooser.setVisible(true);
			}
		});
	}
}
