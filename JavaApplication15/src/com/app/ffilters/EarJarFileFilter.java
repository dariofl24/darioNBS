/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ffilters;

import java.io.File;

/**
 *
 * @author Dario
 */
public class EarJarFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        return (file != null && ( file.getName().endsWith(".jar") || file.getName().endsWith(".ear") ) );
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}//class
