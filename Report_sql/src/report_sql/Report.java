
package report_sql;
import java.sql.*;
import java.util.ArrayList;


public class Report {
    
    
    int cm1,cm2,total,cbb,total_usu=0; //Ciomprobantes generados el primer y segundo mes
    int where;
    ArrayList<ReporteBimestralItem> repoBimList;
    protected final String HEADER="\"Cuenta Bisnet\",\"Nombre\",\"Facturo primer mes\",\"Facturo segundo mes\"";

    
    public void generateString(String m1,String m2,String y1, String y2){
    	
    	int Se=0,Sf=0,ef=0;
        int len=0,index=0;
    	cm1=0;
    	cm2=0;
        cbb=0;
        total_usu=0;
        String reporteBimestralString="";
    	
    	String Reporte="";
    	
    	this.repoBimList= new ArrayList<ReporteBimestralItem>();
    	
    	try{
    		
    		//System.out.println("@# jdbc.url.mysql: "+this.sqlUrl);
    		
    		Class.forName("com.mysql.jdbc.Driver");
            
            String connectionUrl="jdbc:mysql://localhost/report?"+"user=root&password=32253225";
    		//String connectionUrl= this.sqlUrl+"?"+"user="+this.sqlUser+"&password="+this.sqlPass;                    
    		
            Connection con= DriverManager.getConnection(connectionUrl);
            Connection concbb= DriverManager.getConnection(connectionUrl);
            
            Statement stmt;
            ResultSet rs;
            
            Statement stmtcbb;
            ResultSet rscbb;
            
            String SQL="SELECT * FROM comprobante,usuario,contribuyente WHERE USU_ID=usuario.USU_ID_PK AND CONTRIBUYENTE_ID_FK=contribuyente.CONTR_ID_PK AND FECHA_CREACION BETWEEN '"+y1+"-"+m1+"-01' AND '"+y2+"-"+m2+"-01' ORDER BY FECHA_CREACION ASC";
            
            String SQLcbb="SELECT * FROM comprobantecbb,usuario,contribuyente WHERE USU_ID=usuario.USU_ID_PK AND CONTRIBUYENTE_ID_FK=contribuyente.CONTR_ID_PK AND FECHA_CREACION BETWEEN '"+y1+"-"+m1+"-01' AND '"+y2+"-"+m2+"-01' ORDER BY FECHA_CREACION ASC";
            
            stmt= con.createStatement();
            rs=stmt.executeQuery(SQL);
            
            stmtcbb= concbb.createStatement();
            rscbb=stmtcbb.executeQuery(SQLcbb);
            
            m2=(m2.equalsIgnoreCase("01"))?"12":((Integer.parseInt(m2)-1)+"");
            
            m2=(m2.length()==1)?"0"+m2:m2;
            
            while(rs.next()){
                //contador de registros
                
                if(rs.getString("FECHA_CREACION").contains(y1+"-"+m1)){
                    cm1+=1;
                }//if
                
                if(rs.getString("FECHA_CREACION").contains(y2+"-"+m2 )){
                    cm2+=1;
                }//if
                    
                len=len+1;
            }//while
            
            while(rscbb.next()){
                //contador de registros-cbb
                
                if(rscbb.getString("FECHA_CREACION").contains(y1+"-"+m1)){
                    cm1+=1;
                }//if
                
                if(rscbb.getString("FECHA_CREACION").contains(y2+"-"+m2 )){
                    cm2+=1;
                }//if
                
                cbb=cbb+1;
                len=len+1;
            }//while

            
            total=cm1+cm2;
            
            System.out.println("@# len: "+len);
            System.out.println("@# cm1: "+cm1);
            System.out.println("@# cm2: "+cm2);
            System.out.println("@# cbb: "+cbb);
            
            UsuarioRep[] Uarray=new UsuarioRep[len];
            
            if(rs.first()){
                
                if( !Existe(rs.getString("USU_ID_PK"),Uarray) ){
                    Uarray[index]=new UsuarioRep(rs,m1,m2,y1,y2);
                    index=index+1;
                }else{
                    Uarray[where].AddCoco(rs);    
                }//if-else
                
                System.out.println("@# while");
                
                while(rs.next()){
                    
                
                if( !Existe(rs.getString("USU_ID_PK"),Uarray) ){
                    
                    Uarray[index]=new UsuarioRep(rs,m1,m2,y1,y2);
                    index=index+1;
                    
                }else{
                    Uarray[where].AddCoco(rs);    
                }//if-else
                
                }//while
                
                System.out.println("@# while");
                
            }//if
            
            //********** CBB
            
            if(rscbb.first()){ //cbb
                
                if( !Existe(rscbb.getString("USU_ID_PK"),Uarray) ){
                    Uarray[index]=new UsuarioRep(rscbb,m1,m2,y1,y2);
                    index=index+1;
                }else{
                    Uarray[where].AddCoco(rscbb);
                }//if-else
                
                System.out.println("@# while cbb");
                
                while(rscbb.next()){
                    
                    
                    if( !Existe(rscbb.getString("USU_ID_PK"),Uarray) ){
                        
                        Uarray[index]=new UsuarioRep(rscbb,m1,m2,y1,y2);
                        index=index+1;
                        
                    }else{
                        Uarray[where].AddCoco(rscbb);
                    }//if-else
                    
                }//while
                
                System.out.println("@# while cbb");
                
            }//if
            
            
            //**********
            
            
            for(int i=0;i< index;++i){
                if(Uarray[i]!=null ){
                    Reporte= Reporte + Uarray[i].Print(false);
                    this.repoBimList.add( new ReporteBimestralItem(Uarray[i].NOMBRE,Uarray[i].USU_NOMBRE, 
                    		(Uarray[i].FEB)?"si":"no",(Uarray[i].MAR)?"si":"no" ) );
                }else{
                    System.out.println(i+ " "+ index);
                }//if-else
            }//for
            
            Reporte=HEADER+"\n"+Reporte;
            
            Reporte=Reporte+"\n\"+++++++++++++++++++++++++++++++++++++++++++++++++\"\n\n";
            
            Reporte=Reporte+"\"Usuarios que facturaron solo el primes mes: \"\n";
            Reporte=Reporte+HEADER+"\n";
            
            for(int i=0;i< index;++i){
                
                if(Uarray[i]!=null ){
                	Reporte= Reporte + Uarray[i].Print(true);
                }else{
                	System.out.println(i+ " "+ index);
                }//if-else
                
            }//for
            
            for(int i=0;i< index;++i){
                
                if(Uarray[i]!=null){
                    
                    if(Uarray[i].FEB==true && Uarray[i].MAR==false ){
                        Se=Se+1;
                    }//if
                    
                    if(Uarray[i].FEB==false && Uarray[i].MAR==true ){
                        Sf=Sf+1;
                    }//if
                    
                    if(Uarray[i].FEB==true && Uarray[i].MAR==true ){
                        ef=ef+1;
                    }//if    
                    
                    total_usu=total_usu+1;
                    
                }//if
                
            }//for

            Reporte="\"Total de usuarios en el bimestre: "+total_usu+"\"\n"+
            "\"Usuarios que facturaron los dos meses: "+ef+"\"\n"+
            "\"Usuarios que ya no facturaron en el Segundo mes: "+Se+"\"\n"+
            "\"Comprobantes generados el primer mes (CFD,CFDI,CBB): "+cm1+"\"\n"+
            "\"Comprobantes generados el segundo mes (CFD,CFDI,CBB): "+cm2+"\"\n"+
            "\"Comprobantes cbb en el bimestre: "+cbb+"\"\n"+
            "\"Total de comprobantes en el bimestre: "+(cm1+cm2)+"\"\n"+Reporte;
            
            reporteBimestralString= Reporte;
            
            System.out.println(Reporte);
            
            con.close();
            concbb.close();
            
    	}catch(SQLException e){
            
            System.out.println("ERROR SQL: "+e.getMessage());
            return;
        }catch(ClassNotFoundException CE){
        	System.out.println("ERROR Class");
        	return;
        }//try-catch
    	
        
    }//generateString
    
    public boolean Existe(String IDD, UsuarioRep[] Uarr){
        
        for(int i=0;i< Uarr.length;i++){
            
            if( Uarr[i]== null ){
                return false;
            }//if
                
            if(Uarr[i].IsId(IDD)){
                where=i;
                return true;
            }//if
                    
              
        }//for 
        
        return false;
    }//Existe

    
    
    /**
     * Clase auxuliar para guardar la informacion de los reportes generados por los usuarios.
     * Pueden integrarse nuevas funcionalidades para reportes mas detallados.
     * @author fold
     *
     */
    public class UsuarioRep {
        
        String id="",NOMBRE="",USU_NOMBRE="",m1,m2,y1,y2;
        String REPORT="";
        ArrayList<Coco> Cocos;
        
        
        int l_len;
        
        boolean FEB=false, MAR=false;
         
        
        UsuarioRep(ResultSet rs,String mm1,String mm2,String yy1,String yy2){
            
            m1=mm1;
            m2=mm2;
            y1=yy1;
            y2=yy2;
            
            try{
                
                id=rs.getString("usuario.USU_ID_PK"); 
                NOMBRE=rs.getString("usuario.NOMBRE");
                USU_NOMBRE=rs.getString("usuario.USU_NOMBRE");
                
                Cocos= new ArrayList<Coco>();
                Cocos.add(new Coco(rs));
                l_len=1;
                
                if(rs.getString("FECHA_CREACION").contains((y1+"-"+m1+"-")) ){
                    FEB=true;
                }//if
                
                if(rs.getString("FECHA_CREACION").contains((y2+"-"+m2+"-")) ){
                    MAR=true;
                }//if
                
                
            }catch(SQLException e){ 
                System.out.println("Error Cliente: 0");
            }//try-catch
            
            
        }//Usuario 0
        
        
        /**
         * Método que agrega  
         * @param rs 
         */
        public void AddCoco(ResultSet rs){
            
            Cocos.add( new Coco(rs) );
            l_len+=1;
            
            try{
                
                if(rs.getString("FECHA_CREACION").contains((y1+"-"+m1+"-")) ){
                    FEB=true;
                }//if
                
                if(rs.getString("FECHA_CREACION").contains((y2+"-"+m2+"-")) ){
                    MAR=true;
                }//if
                
            }catch(SQLException e){
                System.out.println("AddCoco");
            }//try-catch
            
        }//AddCoco
        
        public String Print(boolean cond){
            
            
            if(cond){
                
                if( FEB==true && MAR==true ){
                    return "";
                }//if
                
                if( FEB==false && MAR==true ){
                    return "";
                }//if
                
            }//if
            
            REPORT="\""+USU_NOMBRE+"\""+","+"\""+NOMBRE+"\""+","+"\""+( (FEB==true)?"Si":"No" )+"\""+","+"\""+(  (MAR==true)?"Si":"No"  )+"\""+"\n";
            
            return REPORT;
        }//Print 
        

        
        public boolean IsId(String ID2){
            
            return id.equalsIgnoreCase(ID2);
            
        }//IsId
        
        /**
         * Clase auxiliar que guarda informacion de los reportes.
         * @author fold
         *
         */
        private class Coco {
            
            String FECHA_CREACION,TOTAL,CONTR_ID_PK,NOMBRE_RAZON;
            
            public Coco(ResultSet rs){
                try {
                    FECHA_CREACION=rs.getString("FECHA_CREACION");
                    TOTAL="";
                    CONTR_ID_PK=rs.getString("contribuyente.CONTR_ID_PK");
                    NOMBRE_RAZON=rs.getString("contribuyente.NOMBRE_RAZON");
                    
                    
                    
                } catch (SQLException ex) {
                   System.out.println("Error Coco: 0 " + ex.getMessage());
                }//
                
            }//Coco 0
            
            public void Print(){
                
                
                System.out.println("Comprobante fecha de creaci\'on: " + FECHA_CREACION);
                System.out.println("Total: "+TOTAL);
                System.out.println("Contribuyente ID: "+CONTR_ID_PK);
                System.out.println("Contribuyente-Nombre / Razon: "+NOMBRE_RAZON);
                
            }//Print 
            
            
        }//class 
        
        
    }//class
    
    /**
     * 
     */
    public class ReporteBimestralItem{
    	
    	private String usuNombre;
    	private String cuenta;
    	private String facturo1;
    	private String facturo2;
    	
    	public ReporteBimestralItem(String usuNombre,String cuenta,String facturo1,String facturo2){
    		this.usuNombre=usuNombre;
    		this.cuenta=cuenta;
    		this.facturo1=facturo1;
    		this.facturo2=facturo2;
    	}//
    	
    	public String getUsuNombre(){
    		return this.usuNombre;
    	}//getUsuNombre
    	
    	public String getCuenta(){
    		return this.cuenta;
    	}//getCuenta
    	
    	public String getFacturo1(){
    		return this.facturo1;
    	}//getFacturo1
    	
    	public String getFacturo2(){
    		return this.facturo2;
    	}//getFacturo2
    	
    	
    	
    }//class
    
    
    
}//class
