package com.example.linegraph1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lineChart = (LineChart) findViewById(R.id.lineChart);
/*        LimitLine upper_lim = new LimitLine(65f,"Danger");
        upper_lim.setLineWidth(4f);
        upper_lim.enableDashedLine(10f,10f,0f);
        upper_lim.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_lim.setTextSize(15f);

        LimitLine lower_lim = new LimitLine(35f,"Too low");
        upper_lim.setLineWidth(4f);
        upper_lim.enableDashedLine(10f,10f,0f);
        upper_lim.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        upper_lim.setTextSize(15f);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(upper_lim);
        leftAxis.addLimitLine(lower_lim);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisMaximum(25f);
        leftAxis.enableGridDashedLine(10f,10f,0);
        leftAxis.setDrawLimitLinesBehindData(true); //Line will be drawn behind the data*/
        lineChart.getAxisRight().setEnabled(false);

        //Create data
        ArrayList<String> xAXES = new ArrayList<>();
        ArrayList<Entry> yAXESsin = new ArrayList<>();
        ArrayList<Entry> yAXEScos = new ArrayList<>();
        double x = 0;
        int numDataPoints = 1000;
        for(int i=0;i<numDataPoints;i++){
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));
            x = x + 0.1;
            yAXESsin.add(new Entry(sinFunction,i)); //fill y array with data
            yAXEScos.add(new Entry(cosFunction,i));
            xAXES.add(i, String.valueOf(x));
        }
        String[] xaxes = new String[xAXES.size()]; //define x axes
        for(int i=0; i<xAXES.size();i++){
            xaxes[i] = xAXES.get(i).toString();
        }


        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>(); //make a data set
        //Line data set
        LineDataSet lineDataSet1 = new LineDataSet(yAXEScos,"cos");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin,"sin");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);
        //Set the data into the chart:
        lineChart.setData(new LineData(lineDataSets));

        lineChart.setVisibleXRangeMaximum(65f);




    }
}
