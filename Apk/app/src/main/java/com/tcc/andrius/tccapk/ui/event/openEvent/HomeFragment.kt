package com.tcc.andrius.tccapk.ui.event.openEvent

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.toast
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.R.id.*
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.ui.googlemaps.MapsActivity
import com.tcc.andrius.tccapk.utils.CustomDateUtils
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.startActivity
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig

/**
 * Created by Andrius on 08/04/2018.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)

        val event = arguments.getSerializable("event") as Event

        view.text_description.text = event.description
        view.text_adress.text = event.adress
        view.text_date.text = CustomDateUtils.getFormatedDate(event.dateInit, "dd/MM/yyyy") + " - " + CustomDateUtils.getFormatedDate(event.dateEnd, "dd/MM/yyyy")
        view.btn_location.setOnClickListener {
            context.startActivity<MapsActivity>("event" to event)
        }
        view.btn_adress.setOnClickListener {
            if ( Build.VERSION.SDK_INT >= 23 &&
                    ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            } else {
                showLocation(event.localization?.latitude, event.localization?.longitude)
            }
        }


        val sequence = MaterialShowcaseSequence(activity)
        val config = ShowcaseConfig()
        config.delay = 300
        config.maskColor = ContextCompat.getColor(context, R.color.showcaseBody)
        sequence.setConfig(config)
        sequence.addSequenceItem(activity.navigation.findViewById(navigation_home),"Nesta área é possível acessar as principais informações do evento.", "PRÓXIMO")
        sequence.addSequenceItem(activity.navigation.findViewById(navigation_schedule),"Nesta área é possível acessar a programação do evento.", "PRÓXIMO")
        sequence.addSequenceItem(activity.navigation.findViewById(navigation_agenda),"Nesta área é possível acessar suas atividades favoritadas.", "PRÓXIMO")
        sequence.addSequenceItem(activity.navigation.findViewById(navigation_map),"Nesta área é possível acessar o mapa do evento.", "PRÓXIMO")
        sequence.addSequenceItem(view.btn_adress,"Com este botão é possível traçar uma rota até o evento.", "OK")
        //sequence.start()

        return  view
    }

    @SuppressLint("MissingPermission")
    fun showLocation(lat: Double?, lng: Double?){

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val providers = locationManager.getProviders(true)
        var bestLocation: Location? = null

        for(provider in providers){
            val l = locationManager.getLastKnownLocation(provider) ?: continue
            if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                bestLocation = l
            }
        }

        if(bestLocation != null) {
            val uri = "http://maps.google.com/maps?f=d&hl=en&saddr=$lat,$lng&daddr=${bestLocation.latitude},${bestLocation.longitude}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            context.startActivity(Intent.createChooser(intent, "Selecione um aplicativo"))
        } else context.toast("Não foi possível pegar sua localização")
    }

    companion object {
        fun newInstance(event: Event): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putSerializable("event", event)
            fragment.arguments = args
            return fragment
        }
    }
}