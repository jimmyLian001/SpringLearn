package com.jimmy.common.impl;

import java.awt.Color;//��ɫϵͳ
import java.text.SimpleDateFormat;//ʱ���ʽ
import java.awt.Paint;//����ϵͳ
import org.jfree.data.time.*;
import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;

public class KLineCombineChart {

public static void main(String[] args) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
     double highValue = Double.MIN_VALUE;//����K�����ݵ��е����ֵ
     double minValue = Double.MAX_VALUE;//����K�����ݵ��е���Сֵ
     double high2Value = Double.MIN_VALUE;//���óɽ��������ֵ
     double min2Value = Double.MAX_VALUE;//���óɽ��������ֵ
     OHLCSeries series = new OHLCSeries("");//�߿������������У���ƱK��ͼ���ĸ����ݣ������ǿ����ߣ��ͣ���
     series.add(new Day(28, 9, 2007), 9.2, 9.58, 9.16, 9.34);
     series.add(new Day(27, 9, 2007), 8.9, 9.06, 8.83, 8.96);
     series.add(new Day(26, 9, 2007), 9.0, 9.1, 8.82, 9.04);
     series.add(new Day(25, 9, 2007), 9.25, 9.33, 8.88, 9.00);
     series.add(new Day(24, 9, 2007), 9.05, 9.50, 8.91, 9.25);
     series.add(new Day(21, 9, 2007), 8.68, 9.05, 8.40, 9.00);
     series.add(new Day(20, 9, 2007), 8.68, 8.95, 8.50, 8.69);
     series.add(new Day(19, 9, 2007), 8.80, 8.94, 8.50, 8.66);
     series.add(new Day(18, 9, 2007), 8.88, 9.17, 8.69, 8.80);
     series.add(new Day(17, 9, 2007), 8.26, 8.98, 8.15, 8.89);
     series.add(new Day(14, 9, 2007), 8.44, 8.45, 8.13, 8.33);
     series.add(new Day(13, 9, 2007), 8.13, 8.46, 7.97, 8.42);
     series.add(new Day(12, 9, 2007), 8.2, 8.4, 7.81, 8.13);
     series.add(new Day(11, 9, 2007), 9.0, 9.0, 8.1, 8.24);
     series.add(new Day(10, 9, 2007), 8.6, 9.03, 8.40, 8.95);
     series.add(new Day(7, 9, 2007), 8.89, 9.04, 8.70, 8.73);
     series.add(new Day(6, 9, 2007), 8.4, 9.08, 8.33, 8.88);
     series.add(new Day(5, 9, 2007), 8.2, 8.74, 8.17, 8.36);
     series.add(new Day(4, 9, 2007), 7.7, 8.46, 7.67, 8.27);
     series.add(new Day(3, 9, 2007), 7.5, 7.8, 7.48, 7.69);
     series.add(new Day(31, 8, 2007), 7.4, 7.6, 7.28, 7.43);
     series.add(new Day(30, 8, 2007), 7.42, 7.56, 7.31, 7.40);
     series.add(new Day(29, 8, 2007), 7.42, 7.66, 7.22, 7.33);
     series.add(new Day(28, 8, 2007), 7.31, 7.70, 7.15, 7.56);
     series.add(new Day(27, 8, 2007), 7.05, 7.46, 7.02, 7.41);
     series.add(new Day(24, 8, 2007), 7.05, 7.09, 6.90, 6.99);
     series.add(new Day(23, 8, 2007), 7.12, 7.16, 7.00, 7.03);
     series.add(new Day(22, 8, 2007), 6.96, 7.15, 6.93, 7.11);
     series.add(new Day(21, 8, 2007), 7.10, 7.15, 7.02, 7.07);
     series.add(new Day(20, 8, 2007), 7.02, 7.19, 6.94, 7.14);
     final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();//����K�����ݵ����ݼ�����������Ϊfinal������Ҫ�������ڲ��������õ�
     seriesCollection.addSeries(series);
     TimeSeries series2=new TimeSeries("");//��Ӧʱ��ɽ�������
     series2.add(new Day(28, 9, 2007), 260659400/100);
     series2.add(new Day(27, 9, 2007), 119701900/100);
     series2.add(new Day(26, 9, 2007), 109719000/100);
     series2.add(new Day(25, 9, 2007), 178492400/100);
     series2.add(new Day(24, 9, 2007), 269978500/100);
     series2.add(new Day(21, 9, 2007), 361042300/100);
     series2.add(new Day(20, 9, 2007), 173912600/100);
     series2.add(new Day(19, 9, 2007), 154622600/100);
     series2.add(new Day(18, 9, 2007), 200661600/100);
     series2.add(new Day(17, 9, 2007), 312799600/100);
     series2.add(new Day(14, 9, 2007), 141652900/100);
     series2.add(new Day(13, 9, 2007), 221260400/100);
     series2.add(new Day(12, 9, 2007), 274795400/100);
     series2.add(new Day(11, 9, 2007), 289287300/100);
     series2.add(new Day(10, 9, 2007), 289063600/100);
     series2.add(new Day(7, 9, 2007), 351575300/100);
     series2.add(new Day(6, 9, 2007), 451357300/100);
     series2.add(new Day(5, 9, 2007), 442421200/100);
     series2.add(new Day(4, 9, 2007), 671942600/100);
     series2.add(new Day(3, 9, 2007), 349647800/100);
     series2.add(new Day(31, 8, 2007), 225339300/100);
     series2.add(new Day(30, 8, 2007), 160048200/100);
     series2.add(new Day(29, 8, 2007), 247341700/100);
     series2.add(new Day(28, 8, 2007), 394975400/100);
     series2.add(new Day(27, 8, 2007), 475797500/100);
     series2.add(new Day(24, 8, 2007), 297679500/100);
     series2.add(new Day(23, 8, 2007), 191760600/100);
     series2.add(new Day(22, 8, 2007), 232570200/100);
     series2.add(new Day(21, 8, 2007), 215693200/100);
     series2.add(new Day(20, 8, 2007), 200287500/100);
     TimeSeriesCollection timeSeriesCollection=new TimeSeriesCollection();//�����ɽ������ݵļ���
     timeSeriesCollection.addSeries(series2);
  
     //��ȡK�����ݵ����ֵ�����ֵ
     int seriesCount = seriesCollection.getSeriesCount();//һ���ж��ٸ����У�ĿǰΪһ��
     for (int i = 0; i < seriesCount; i++) {
      int itemCount = seriesCollection.getItemCount(i);//ÿһ�������ж��ٸ�������
      for (int j = 0; j < itemCount; j++) {
       if (highValue < seriesCollection.getHighValue(i, j)) {//ȡ��i�������еĵ�j������������ֵ
        highValue = seriesCollection.getHighValue(i, j);
       }
       if (minValue > seriesCollection.getLowValue(i, j)) {//ȡ��i�������еĵ�j�����������Сֵ
        minValue = seriesCollection.getLowValue(i, j);
       }
      }

     }
     //��ȡ���ֵ�����ֵ
     int seriesCount2 = timeSeriesCollection.getSeriesCount();//һ���ж��ٸ����У�ĿǰΪһ��
     for (int i = 0; i < seriesCount2; i++) {
      int itemCount = timeSeriesCollection.getItemCount(i);//ÿһ�������ж��ٸ�������
      for (int j = 0; j < itemCount; j++) {
       if (high2Value < timeSeriesCollection.getYValue(i,j)) {//ȡ��i�������еĵ�j���������ֵ
        high2Value = timeSeriesCollection.getYValue(i,j);
       }
       if (min2Value > timeSeriesCollection.getYValue(i, j)) {//ȡ��i�������еĵ�j���������ֵ
        min2Value = timeSeriesCollection.getYValue(i, j);
       }
      }

     }
     final CandlestickRenderer candlestickRender=new CandlestickRenderer();//����K��ͼ�Ļ�ͼ������������Ϊfinal������Ҫ�������ڲ��������õ�
     candlestickRender.setUseOutlinePaint(true); //�����Ƿ�ʹ���Զ���ı߿��ߣ������Դ��ı߿��ߵ���ɫ�������й���Ʊ�г���ϰ��
     candlestickRender.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_AVERAGE);//������ζ�K��ͼ�Ŀ�Ƚ����趨
     candlestickRender.setAutoWidthGap(0.001);//���ø���K��ͼ֮��ļ��
     candlestickRender.setUpPaint(Color.RED);//���ù�Ʊ���ǵ�K��ͼ��ɫ
     candlestickRender.setDownPaint(Color.GREEN);//���ù�Ʊ�µ���K��ͼ��ɫ
     DateAxis x1Axis=new DateAxis();//����x�ᣬҲ����ʱ����
     x1Axis.setAutoRange(false);//���ò������Զ�����ʱ�䷶Χ
     try{
      x1Axis.setRange(dateFormat.parse("2007-08-20"),dateFormat.parse("2007-09- 29"));//����ʱ�䷶Χ��ע��ʱ������ֵҪ�����е�ʱ�����ֵҪ��һ��
     }catch(Exception e){
      e.printStackTrace();
     }
     x1Axis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());// ����ʱ������ʾ�Ĺ���������������������������������Щû�н��׵�����(�ܶ��˶���֪���д˷���)��ʹͼ�ο���ȥ����
     x1Axis.setAutoTickUnitSelection(false);//���ò������Զ�ѡ��̶�ֵ
     x1Axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);//���ñ�ǵ�λ��
     x1Axis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());//���ñ�׼��ʱ��̶ȵ�λ
     x1Axis.setTickUnit(new DateTickUnit(DateTickUnit.DAY,7));//����ʱ��̶ȵļ����һ������Ϊ��λ
     x1Axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));//������ʾʱ��ĸ�ʽ
     NumberAxis y1Axis=new NumberAxis();//�趨y�ᣬ����������
     y1Axis.setAutoRange(false);//����ʹ���Զ��趨��Χ
     y1Axis.setRange(minValue*0.9, highValue*1.1);//�趨y��ֵ�ķ�Χ�������ֵҪ��һЩ�������ֵҪ��һЩ������ͼ�ο�����������Щ
     y1Axis.setTickUnit(new NumberTickUnit((highValue*1.1-minValue*0.9)/10));//���ÿ̶���ʾ���ܶ�
     XYPlot plot1=new XYPlot(seriesCollection,x1Axis,y1Axis,candlestickRender);//���û�ͼ�������
  
     XYBarRenderer xyBarRender=new XYBarRenderer(){
     private static final long serialVersionUID = 1L;//Ϊ�˱�����־�����Ϣ�����趨��ֵ
     public Paint getItemPaint(int i, int j){//�����ڲ������������յĳɽ�������ͼ����ɫ��K��ͼ����ɫ����һ��
       if(seriesCollection.getCloseValue(i,j)>seriesCollection.getOpenValue(i,j)){//���̼۸��ڿ��̼ۣ���Ʊ���ǣ�ѡ�ù�Ʊ���ǵ���ɫ
        return candlestickRender.getUpPaint();
       }else{
        return candlestickRender.getDownPaint();
       }
     }};
     xyBarRender.setMargin(0.1);//��������ͼ֮��ļ��
     NumberAxis y2Axis=new NumberAxis();//����Y�ᣬΪ��ֵ,��������ã��ο������y������
     y2Axis.setAutoRange(false);
     y2Axis.setRange(min2Value*0.9, high2Value*1.1);
     y2Axis.setTickUnit(new NumberTickUnit((high2Value*1.1-min2Value*0.9)/4));
     XYPlot plot2=new XYPlot(timeSeriesCollection,null,y2Axis,xyBarRender);//�����ڶ�����ͼ���������Ҫ��ʱ�� x����Ϊ��nullֵ����ΪҪ���һ����ͼ���������x��
     CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(x1Axis);//����һ��ǡ��������ͼ�����������x��Ϊ������
     combineddomainxyplot.add(plot1, 2);//���ͼ��������󣬺���������Ǽ�������������Ӧ��ռ�ݶ�������2/3
        combineddomainxyplot.add(plot2, 1);//���ͼ��������󣬺���������Ǽ�������������Ӧ��ռ�ݶ�������1/3
        combineddomainxyplot.setGap(10);//��������ͼ���������֮��ļ���ռ�
        JFreeChart chart = new JFreeChart("�й���ͨ", JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, false);
        ChartFrame frame = new ChartFrame("�й���ͨ��Ʊ", chart);
     frame.pack();
     frame.setVisible(true);
}

}

