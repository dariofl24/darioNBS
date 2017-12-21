
package promp_try;

import com.jcraft.jsch.*;
import java.io.*;
import javax.swing.*;



public class Promp_try {

    public static void main(String[] arg){
    
    try{
      JSch jsch=new JSch();
  
      String host;
      
      host=JOptionPane.showInputDialog("Enter username@hostname",
                                         System.getProperty("user.name")+
                                         "@localhost");
      
      String user=host.substring(0, host.indexOf('@'));
      host=host.substring(host.indexOf('@')+1);
 
      Session session=jsch.getSession(user, host, 22);
 
      String passwd = JOptionPane.showInputDialog("Enter password");
      session.setPassword(passwd);
 
      UserInfo ui = new MyUserInfo(){
        @Override
        public void showMessage(String message){
          JOptionPane.showMessageDialog(null, message);
        }//
        
        @Override
        public boolean promptYesNo(String message){
          Object[] options={ "yes", "no" };
          int foo=JOptionPane.showOptionDialog(null, 
                                               message,
                                               "Warning", 
                                               JOptionPane.DEFAULT_OPTION, 
                                               JOptionPane.WARNING_MESSAGE,
                                               null, options, options[0]);
          return foo==0;
        }//
 
        // If password is not given before the invocation of Session#connect(),
        // implement also following methods,
        //   * UserInfo#getPassword(),
        //   * UserInfo#promptPassword(String message) and
        //   * UIKeyboardInteractive#promptKeyboardInteractive()
 
      };
 
      session.setUserInfo(ui); 
 
      // It must not be recommended, but if you want to skip host-key check,
      // invoke following,
      // session.setConfig("StrictHostKeyChecking", "no");
 
      session.connect(); System.out.println(">>> Connected");
 
      Channel channel=session.openChannel("shell"); System.out.println(">>> Channel");
      
      
      
      // Enable agent-forwarding.
      //((ChannelShell)channel).setAgentForwarding(true);
 
      channel.setInputStream(System.in); System.out.println(">>> Input");
      /*
      // a hack for MS-DOS prompt on Windows.
      channel.setInputStream(new FilterInputStream(System.in){
          public int read(byte[] b, int off, int len)throws IOException{
            return in.read(b, off, (len>1024?1024:len));
          }
        });
       */
 
      channel.setOutputStream(System.out); System.out.println(">>> Output");
 
      /*
      // Choose the pty-type "vt102".
      ((ChannelShell)channel).setPtyType("vt102");
      */
 
      /*
      // Set environment variable "LANG" as "ja_JP.eucJP".
      ((ChannelShell)channel).setEnv("LANG", "ja_JP.eucJP");
      */
 
      
      channel.connect(); System.out.println(">>> Connected");
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
 
  public static abstract class MyUserInfo
                          implements UserInfo, UIKeyboardInteractive{
    public String getPassword(){ return null; }
    public boolean promptYesNo(String str){ return false; }
    public String getPassphrase(){ return null; }
    public boolean promptPassphrase(String message){ return false; }
    public boolean promptPassword(String message){ return false; }
    public void showMessage(String message){ }
    public String[] promptKeyboardInteractive(String destination,
                                              String name,
                                              String instruction,
                                              String[] prompt,
                                              boolean[] echo){
      return null;
    }
  }
    
}//class
