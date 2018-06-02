package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ItensScheduleAdapter
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.viewpage_schedule.view.*
import me.toptas.fancyshowcase.FancyShowCaseView
import android.util.Log
import kotlinx.android.synthetic.main.showcase_screen.view.*
import me.toptas.fancyshowcase.FancyShowCaseQueue


/**
 * Created by Andrius on 08/04/2018.
 */
class ScheduleViewpage : Fragment() {

    private var fancyShowCaseQueue: FancyShowCaseQueue? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.viewpage_schedule, container, false)

        val itens = arguments.getSerializable("itens") as ArrayList<Item>

        if (itens.isNotEmpty()) {
            var adapter = ItensScheduleAdapter(context, itens)
            view.recyclerview_itens.setHasFixedSize(true)
            view.recyclerview_itens.layoutManager = LinearLayoutManager(context)
            view.recyclerview_itens.adapter = adapter


            val test = view.recyclerview_itens.findViewHolderForAdapterPosition(0)
            Log.d("ninja", test.toString())

        } else {
            view.text_error.visibility = View.VISIBLE
        }



        val fancyShowCaseView = FancyShowCaseView.Builder(activity)
                .title("Third Queue Item")
                .customView(R.layout.showcase_screen) { view ->
                    kotlin.run {
                        view.text_description.text = "Favorite atividades par receber notificações quando iniciarem.\nAtividades faviritadas estarão disponíveis na agenda"
                        view.btn_close.setOnClickListener(mClickListener)
                    }
                }
                .closeOnTouch(false)
                .build()

        fancyShowCaseQueue = FancyShowCaseQueue().add(fancyShowCaseView)
        fancyShowCaseQueue!!.show()

        return view
    }

    var mClickListener: View.OnClickListener = View.OnClickListener {
        fancyShowCaseQueue?.cancel(true)
    }

    companion object {
        fun newInstance(itens: ArrayList<Item>): ScheduleViewpage {
            val fragment = ScheduleViewpage()
            val args = Bundle()
            args.putSerializable("itens", itens)
            fragment.arguments = args
            return fragment
        }
    }

}