package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.tcc.andrius.tccapk.R
import kotlinx.android.synthetic.main.fragment_map.view.*

/**
 * Created by Andrius on 14/04/2018.
 */
class MapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_map, container, false)

        val map = arguments.getSerializable("map") as String
        Picasso.get().load(map).error(R.drawable.default_image).into(view.img_map)

        return  view
    }

    companion object {
        fun newInstance(map: String?): MapFragment {
            val fragment = MapFragment()
            val args = Bundle()
            args.putSerializable("map", map)
            fragment.arguments = args
            return fragment
        }
    }
}