package com.jimmy.common.impl;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.awt.Paint;
import org.jfree.data.time.*;
import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;

import javax.swing.*;

public class KLineCombineChart extends JApplet{

public static void main(String[] args) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//
     double highValue = Double.MIN_VALUE;//
     double minValue = Double.MAX_VALUE;//
     double high2Value = Double.MIN_VALUE;//
     double min2Value = Double.MAX_VALUE;//
     OHLCSeries series = new OHLCSeries("");//
     series.add(new Day(28, 9, 2017), 9.2, 9.58, 9.16, 9.34);
     series.add(new Day(27, 9, 2017), 8.9, 9.06, 8.83, 8.96);
     series.add(new Day(26, 9, 2017), 9.0, 9.1, 8.82, 9.04);
     series.add(new Day(25, 9, 2017), 9.25, 9.33, 8.88, 9.00);
     series.add(new Day(24, 9, 2017), 9.05, 9.50, 8.91, 9.25);
     series.add(new Day(21, 9, 2017), 8.68, 9.05, 8.40, 9.00);
     series.add(new Day(20, 9, 2017), 8.68, 8.95, 8.50, 8.69);
     series.add(new Day(19, 9, 2017), 8.80, 8.94, 8.50, 8.66);
     series.add(new Day(18, 9, 2017), 8.88, 9.17, 8.69, 8.80);
     series.add(new Day(17, 9, 2017), 8.26, 8.98, 8.15, 8.89);
     series.add(new Day(14, 9, 2017), 8.44, 8.45, 8.13, 8.33);
     series.add(new Day(13, 9, 2017), 8.13, 8.46, 7.97, 8.42);
     series.add(new Day(12, 9, 2017), 8.2, 8.4, 7.81, 8.13);
     series.add(new Day(11, 9, 2017), 9.0, 9.0, 8.1, 8.24);
     series.add(new Day(10, 9, 2017), 8.6, 9.03, 8.40, 8.95);
     series.add(new Day(7, 9, 2017), 8.89, 9.04, 8.70, 8.73);
     series.add(new Day(6, 9, 2017), 8.4, 9.08, 8.33, 8.88);
     series.add(new Day(5, 9, 2017), 8.2, 8.74, 8.17, 8.36);
     series.add(new Day(4, 9, 2017), 7.7, 8.46, 7.67, 8.27);
     series.add(new Day(3, 9, 2017), 7.5, 7.8, 7.48, 7.69);
     series.add(new Day(31, 8, 2017), 7.4, 7.6, 7.28, 7.43);
     series.add(new Day(30, 8, 2017), 7.42, 7.56, 7.31, 7.40);
     series.add(new Day(29, 8, 2017), 7.42, 7.66, 7.22, 7.33);
     series.add(new Day(28, 8, 2017), 7.31, 7.70, 7.15, 7.56);
     series.add(new Day(27, 8, 2017), 7.05, 7.46, 7.02, 7.41);
     series.add(new Day(24, 8, 2017), 7.05, 7.09, 6.90, 6.99);
     series.add(new Day(23, 8, 2017), 7.12, 7.16, 7.00, 7.03);
     series.add(new Day(22, 8, 2017), 6.96, 7.15, 6.93, 7.11);
     series.add(new Day(21, 8, 2017), 7.10, 7.15, 7.02, 7.07);
     series.add(new Day(20, 8, 2017), 7.02, 7.19, 6.94, 7.14);
     final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();//
     seriesCollection.addSeries(series);
     TimeSeries series2=new TimeSeries("");//
     series2.add(new Day(28, 9, 2017), 260659400/100);
     series2.add(new Day(27, 9, 2017), 119701900/100);
     series2.add(new Day(26, 9, 2017), 109719000/100);
     series2.add(new Day(25, 9, 2017), 178492400/100);
     series2.add(new Day(24, 9, 2017), 269978500/100);
     series2.add(new Day(21, 9, 2017), 361042300/100);
     series2.add(new Day(20, 9, 2017), 173912600/100);
     series2.add(new Day(19, 9, 2017), 154622600/100);
     series2.add(new Day(18, 9, 2017), 200661600/100);
     series2.add(new Day(17, 9, 2017), 312799600/100);
     series2.add(new Day(14, 9, 2017), 141652900/100);
     series2.add(new Day(13, 9, 2017), 221260400/100);
     series2.add(new Day(12, 9, 2017), 274795400/100);
     series2.add(new Day(11, 9, 2017), 289287300/100);
     series2.add(new Day(10, 9, 2017), 289063600/100);
     series2.add(new Day(7, 9, 2017), 351575300/100);
     series2.add(new Day(6, 9, 2017), 451357300/100);
     series2.add(new Day(5, 9, 2017), 442421200/100);
     series2.add(new Day(4, 9, 2017), 671942600/100);
     series2.add(new Day(3, 9, 2017), 349647800/100);
     series2.add(new Day(31, 8, 2017), 225339300/100);
     series2.add(new Day(30, 8, 2017), 160048200/100);
     series2.add(new Day(29, 8, 2017), 247341700/100);
     series2.add(new Day(28, 8, 2017), 394975400/100);
     series2.add(new Day(27, 8, 2017), 475797500/100);
     series2.add(new Day(24, 8, 2017), 297679500/100);
     series2.add(new Day(23, 8, 2017), 191760600/100);
     series2.add(new Day(22, 8, 2017), 232570200/100);
     series2.add(new Day(21, 8, 2017), 215693200/100);
     series2.add(new Day(20, 8, 2017), 200287500/100);
     TimeSeriesCollection timeSeriesCollection=new TimeSeriesCollection();//
     timeSeriesCollection.addSeries(series2);
  
     //
     int seriesCount = seriesCollection.getSeriesCount();//
     for (int i = 0; i < seriesCount; i++) {
      int itemCount = seriesCollection.getItemCount(i);//
      for (int j = 0; j < itemCount; j++) {
       if (highValue < seriesCollection.getHighValue(i, j)) {//
        highValue = seriesCollection.getHighValue(i, j);
       }
       if (minValue > seriesCollection.getLowValue(i, j)) {//
        minValue = seriesCollection.getLowValue(i, j);
       }
      }

     }
     //
     int seriesCount2 = timeSeriesCollection.getSeriesCount();//
     for (int i = 0; i < seriesCount2; i++) {
      int itemCount = timeSeriesCollection.getItemCount(i);//
      for (int j = 0; j < itemCount; j++) {
       if (high2Value < timeSeriesCollection.getYValue(i,j)) {//
        high2Value = timeSeriesCollection.getYValue(i,j);
       }
       if (min2Value > timeSeriesCollection.getYValue(i, j)) {//
        min2Value = timeSeriesCollection.getYValue(i, j);
       }
      }

     }
     final CandlestickRenderer candlestickRender=new CandlestickRenderer();//
     candlestickRender.setUseOutlinePaint(true); //
     candlestickRender.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_AVERAGE);//
     candlestickRender.setAutoWidthGap(0.001);//
     candlestickRender.setUpPaint(Color.RED);//
     candlestickRender.setDownPaint(Color.GREEN);//
     DateAxis x1Axis=new DateAxis();//
     x1Axis.setAutoRange(false);//
     try{
      x1Axis.setRange(dateFormat.parse("2017-08-20"),dateFormat.parse("2017-09- 29"));//
     }catch(Exception e){
      e.printStackTrace();
     }
     x1Axis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());//
     x1Axis.setAutoTickUnitSelection(false);//
     x1Axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);//
     x1Axis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());//
     x1Axis.setTickUnit(new DateTickUnit(DateTickUnit.DAY,7));//
     x1Axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));//
     NumberAxis y1Axis=new NumberAxis();//
     y1Axis.setAutoRange(false);//
     y1Axis.setRange(minValue*0.9, highValue*1.1);//
     y1Axis.setTickUnit(new NumberTickUnit((highValue*1.1-minValue*0.9)/10));//
     XYPlot plot1=new XYPlot(seriesCollection,x1Axis,y1Axis,candlestickRender);//
  
     XYBarRenderer xyBarRender=new XYBarRenderer(){
     private static final long serialVersionUID = 1L;//
     public Paint getItemPaint(int i, int j){//
       if(seriesCollection.getCloseValue(i,j)>seriesCollection.getOpenValue(i,j)){//
        return candlestickRender.getUpPaint();
       }else{
        return candlestickRender.getDownPaint();
       }
     }};
     xyBarRender.setMargin(0.1);//
     NumberAxis y2Axis=new NumberAxis();//
     y2Axis.setAutoRange(false);
     y2Axis.setRange(min2Value*0.9, high2Value*1.1);
     y2Axis.setTickUnit(new NumberTickUnit((high2Value*1.1-min2Value*0.9)/4));
     XYPlot plot2=new XYPlot(timeSeriesCollection,null,y2Axis,xyBarRender);//
     CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(x1Axis);//
     combineddomainxyplot.add(plot1, 2);//
        combineddomainxyplot.add(plot2, 1);//
        combineddomainxyplot.setGap(10);//
        JFreeChart chart = new JFreeChart("汇率K线图", JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, false);
        ChartFrame frame = new ChartFrame("K线展示", chart);
     frame.pack();
     frame.setVisible(true);
}

}

