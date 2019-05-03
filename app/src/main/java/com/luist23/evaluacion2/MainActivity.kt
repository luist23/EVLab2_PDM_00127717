package com.luist23.evaluacion2

import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luist23.evaluacion2.fragmentos.ContentFragment
import com.luist23.evaluacion2.fragmentos.barFragment

class MainActivity : AppCompatActivity() , barFragment.OnFragmentInteractionListener , ContentFragment.OnFragmentInteractionListeners{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction (id: Int){
        var colorsito=""
        var colors = when (id){
            1 -> {colorsito="1"
                Color.rgb(100,0,0)}
            2-> {colorsito="2"
                Color.rgb(0,100,0)
            }
            3-> {colorsito="3"
                Color.rgb(0,0,100)
            }
            else -> {
                "fuck"
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content,
                        ContentFragment.newInstance("min","max"
                        ,colorsito,colors.toString()))
                                .addToBackStack("co").commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){
            var bar = barFragment.newInstance("back","next")

            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, bar)
                    .commit()
        }
    }
}
