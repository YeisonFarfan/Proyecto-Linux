package Controlador;

import Modelo.Calculo;
import Vista.vistaCalculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCalculo implements ActionListener{
    
    private vistaCalculadora vista;
    private Calculo metodo;
    private String funcion;
    private double x;
    
    public ControladorCalculo(){
        
        vista = new vistaCalculadora(this);
        metodo = new Calculo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        if(e.getActionCommand().equals("Derivar")) {
         
            funcion = vista.Funcion();
           
            metodo.setFuncion(funcion);
            
            metodo.derivar();
            
            ResultadoDerivar();
            
        }
        
        if(e.getActionCommand().equals("Evaluar")) {
         
            funcion = vista.Funcion();
            
            x = vista.X();
            
           
            metodo.setFuncion(funcion);
            
            metodo.setX(x);
            
            metodo.evaluar();
            
            ResultadoEvaluar();
            
        }
        
        
    }
    
    public void ResultadoDerivar(){
        
        String resultado = metodo.getResultado();
        vista.ColocarResultadoDerivada(resultado);
    }
    
    public void ResultadoEvaluar(){
        
        String resultado = metodo.getResultado();
        vista.ColocarResultadoEvaluar(resultado);
    }
    
    
}
