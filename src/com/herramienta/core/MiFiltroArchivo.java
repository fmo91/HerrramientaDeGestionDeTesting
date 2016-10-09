/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herramienta.core;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MiFiltroArchivo extends FileFilter
{
	@Override
	public boolean accept(File f)
	{
		String nombreArch = f.getName();
		
		if(f.isDirectory() || nombreArch.endsWith(".java") || nombreArch.endsWith(".txt"))
			return true;
		
		return false;
	}

	@Override
	public String getDescription()
	{
		return "Archivos de texto (.java, .txt)";
	}
	
}
