
package db_try;
import java.sql.*;


public class Cliente {
    
    String id="",NOMBRE_RAZON="",AP_PATERNO="",AP_MATERNO="",TIPO_PERSONA="",TEL_PARTICULAR="",TEL_CELULAR="";
    String RFC="",TAX_ID="",CURP="",FEC_NAC="",FEC_ALTA="",EMAIL="",STATUS="",FEC_BAJA="",DOM_FISCAL_CALLE="",DOM_FISCAL_NO_EXT="";
    String DOM_FISCAL_NO_INT="",DOM_FISCAL_COLONIA="",DOM_FISCAL_LOCALIDAD="",DOM_FISCAL_REFERENCIA="",DOM_FISCAL_MUNICIPIO="";
    String DOM_FISCAL_ESTADO="",DOM_FISCAL_PAIS="",DOM_FISCAL_CP="",NUM_CTA_PAGO="";
    Lista_dob<Coco> Cocos;
    
    int l_len;
    
    boolean ENE, FEB;
     
    
    Cliente(ResultSet rs){
        
        try{
            
            id=rs.getString("CTE_ID_PK"); 
            NOMBRE_RAZON=rs.getString("cliente.NOMBRE_RAZON");
            RFC=rs.getString("RFC");
            
            Cocos= new Lista_dob<Coco>( new Coco(rs) );
            l_len=1;
            
            if(rs.getString("FECHA_CREACION").contains("2013-01-") || rs.getString("FECHA_CREACION").contains("2013-1-") ){
                ENE=true;
            }//if
            
            if(rs.getString("FECHA_CREACION").contains("2013-02-") || rs.getString("FECHA_CREACION").contains("2013-2-") ){
                FEB=true;
            }//if
            
            
        }catch(SQLException e){
            System.out.println("Cliente");
        }//try-catch
        
        
    }//Cliente 0
    
    
    
    public void AddCoco(ResultSet rs){
        
        Cocos.insertarUltimo( new Coco(rs) );
        l_len+=1;
        
        try{
            
            if(rs.getString("FECHA_CREACION").contains("2013-01-") || rs.getString("FECHA_CREACION").contains("2013-1-") ){
                ENE=true;
            }//if
            
            if(rs.getString("FECHA_CREACION").contains("2013-02-") || rs.getString("FECHA_CREACION").contains("2013-2-") ){
                FEB=true;
            }//if
            
        }catch(SQLException e){
            System.out.println("AddCoco");
        }//try-catch
        
    }//AddCoco
    
    
    
    public void Print(boolean cond){
        
        if(cond){
            
            if( ENE==true && FEB==true ) return;
            if( ENE==false && FEB==true ) return;
            
        }//if
        
        System.out.println("---------------------------------------------------------------------");
        System.out.println("CTE_ID_PK: "+id);
        System.out.println("Nombre / Razon: "+NOMBRE_RAZON+"\n");
        
        System.out.println("Facturo en Enero: " + (  (ENE)?"Si":"No"  ) );
        System.out.println("Facturo en Febre: " + (  (FEB)?"Si":"No"  ) );
        
        System.out.println("Comprobantes - Contribuyentes: \n");
        
        Cocos.primero();
        
        for(int i=1;i <=l_len;++i){
            
            Cocos.elemento().Print();
            Cocos.avanza();
            
        }//for
        
        System.out.println("\n");
        
        
        
    }//Print 
    

    
    public boolean IsId(String ID2){
        
        return id.equalsIgnoreCase(ID2);
        
    }//IsId
    
    private class Coco {
        
        String FECHA_CREACION,TOTAL,CONTR_ID_PK,NOMBRE_RAZON;
        
        public Coco(ResultSet rs){
            try {
                FECHA_CREACION=rs.getString("FECHA_CREACION");
                TOTAL=rs.getString("TOTAL");
                CONTR_ID_PK=rs.getString("CONTR_ID_PK");
                NOMBRE_RAZON=rs.getString("contribuyente.NOMBRE_RAZON");
                
                
                
            } catch (SQLException ex) {
               System.out.println("Eror coco");
            }//
            
        }//Coco 0
        
        public void Print(){
            
            System.out.println("**********************************************************************");
            
            System.out.println("Comprobante fecha de creaci\'on:" + FECHA_CREACION);
            System.out.println("Total: "+TOTAL);
            System.out.println("Contribuyente ID: "+CONTR_ID_PK);
            System.out.println("Contribuyente-Nombre / Razon: "+NOMBRE_RAZON);
            
        }//Print 
        
        
    }//class 
    
    
}//class 

