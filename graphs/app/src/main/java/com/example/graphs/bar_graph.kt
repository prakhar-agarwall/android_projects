package com.example.graphs

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_bar_graph.*

class bar_graph : AppCompatActivity() {

    lateinit var barList: ArrayList<BarEntry>

    lateinit var barDataSet: BarDataSet
    lateinit var barData: BarData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_graph)

        barList = ArrayList()
        barList.add(BarEntry(1f, 500f))
        barList.add(BarEntry(2f, 100f))
        barList.add(BarEntry(3f, 300f))
        barList.add(BarEntry(4f, 800f))
        barList.add(BarEntry(5f, 5400f))
        barList.add(BarEntry(6f, 1000f))
        barList.add(BarEntry(7f, 800f))
        barDataSet = BarDataSet(barList, "Population")
        barData = BarData(barDataSet)
        barChart.data = barData
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 15f
        barChart.axisLeft.setDrawGridLines(false)
        barChart.xAxis.setDrawGridLines(false)
        barChart.xAxis.setDrawAxisLine(false)
        barChart.legend.isEnabled = false
        barChart.setDrawBarShadow(false)
        barChart.setDrawMarkers(false)
        //barChart.description.isEnabled = false

    }
}