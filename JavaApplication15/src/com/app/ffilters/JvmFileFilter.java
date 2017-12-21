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
public class JvmFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        
        return true;
    }//

    @Override
    public String getDescription() {
        return "Java Home Directory or executable";
    }
    
    
    
}//class
