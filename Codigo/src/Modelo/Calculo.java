package Modelo;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.JEP;

public class Calculo {
    
    
    private String funcion;
    private String resultado;
    private DJep djep;
    private Node nodoFuncion;
    private Node nodoDerivada;
    private double x;
    private JEP jep;

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void derivar(){
        
        try{
            
            this.djep = new DJep();
            
            this.djep.addStandardFunctions();
            
            this.djep.addStandardConstants();
            
            this.djep.addComplex();
            
            this.djep.setAllowUndeclared(true);
            
            this.djep.setAllowAssignment(true);
            
            this.djep.setImplicitMul(true);
            
            this. djep.addStandardDiffRules();
            
            this.nodoFuncion = this.djep.parse(funcion);
                    
            Node n = this.djep.differentiate(nodoFuncion, "x");
            
            this.nodoDerivada = this.djep.simplify(n);
            
            this.resultado = this.djep.toString(this.nodoDerivada);
            
        }catch(ParseException e){
            
            System.out.println(e);
        }
    }
    
    public void evaluar(){
            
            jep = new JEP();
             
            this.jep.addStandardConstants();
            
            this.jep.addStandardFunctions();
            
            this.jep.addVariable("x", this.x);
            
            this.jep.parseExpression(this.funcion);
            
            this.resultado = Double.toString(this.jep.getValue());
          
    }
      
}
