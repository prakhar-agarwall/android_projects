package com.example.graphs

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidplot.xy.*
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plot: XYPlot = findViewById(R.id.plot)

        val domainLabels = arrayOf<Number>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val seriesLabels = arrayOf<Number>(1, 4, 8, 12, 32, 26, 39, 18, 59, 74)

        val series: XYSeries = SimpleXYSeries(
            Arrays.asList(* seriesLabels),
            SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
            "Series 1"
        )

        val seriesFormat = LineAndPointFormatter(Color.BLUE, Color.BLACK, null, null)

        seriesFormat.setInterpolationParams(CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal))

        plot.addSeries(series, seriesFormat)

        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format() {
            override fun format(obj: Any?, toAppendTo: StringBuffer?, p2: FieldPosition?): StringBuffer? {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo?.append(domainLabels[i])
            }

            override fun parseObject(p0: String?, p1: ParsePosition?): Any? {
                return null
            }
        }

        PanZoom.attach(plot)

    }
}