/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author PHAM DAC THANG
 */
public class bieudo {
 
       public  String ox;
       public  float oy;

    public bieudo() {
    }

    public bieudo(String ox, float oy) {
        this.ox = ox;
        this.oy = oy;
    }

    public String getOx() {
        return ox;
    }

    public void setOx(String ox) {
        this.ox = ox;
    }

    public float getOy() {
        return oy;
    }

    public void setOy(float oy) {
        this.oy = oy;
    }

    @Override
    public String toString() {
        return  ox + "----------" + oy ;
    }
       
       
    
    
    
    
    
    
    
    
    
    
    
   

}
