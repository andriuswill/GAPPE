package com.tcc.andrius.tccapk

import android.app.Application
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.onesignal.OneSignal
import com.tcc.andrius.tccapk.models.*
import com.tcc.andrius.tccapk.network.OnesignalService
import com.tcc.andrius.tccapk.utils.CustomDateUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import st.lowlevel.storo.Storo
import st.lowlevel.storo.StoroBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by Andrius on 01/04/2018.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .setNotificationReceivedHandler(NotificationReceivedHandler(this))
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init()
        //fillEvents()
    }

    fun fillEvents(){

        var itens = ArrayList<Item>()

        ///Futsal Feminino
        itens.add(Item("J1", "Rio Grande x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 09:00"), "Futsal Feminino","Quadra 1","Chave A"))
        itens.add(Item("J2", "Restinga x Osório", CustomDateUtils.getDateTimeFromString("17/05/2018 09:20"), "Futsal Feminino","Quadra 1","Chave B"))
        itens.add(Item("J3", "Viamão x Sertão", CustomDateUtils.getDateTimeFromString("17/05/2018 09:40"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J4", "Caxias x Rolante", CustomDateUtils.getDateTimeFromString("17/05/2018 10:00"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J5", "Ibirubá x Rio Grande", CustomDateUtils.getDateTimeFromString("17/05/2018 10:20"), "Futsal Feminino","","Chave A"))
        itens.add(Item("J6", "Bento x Restinga", CustomDateUtils.getDateTimeFromString("17/05/2018 10:40"), "Futsal Feminino","Quadra 1","Chave B"))
        itens.add(Item("J7", "Caxias x Viamão", CustomDateUtils.getDateTimeFromString("17/05/2018 11:00"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J8", "Rolante x Sertão", CustomDateUtils.getDateTimeFromString("17/05/2018 11:20"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J9", "Feliz x Ibirubá", CustomDateUtils.getDateTimeFromString("17/05/2018 11:40"), "Futsal Feminino","Quadra 1","Chave A"))
        itens.add(Item("J10", "Osório x Bento", CustomDateUtils.getDateTimeFromString("17/05/2018 12:00"), "Futsal Feminino","Quadra 1","Chave B"))
        itens.add(Item("J11", "Viamão x Rolante", CustomDateUtils.getDateTimeFromString("17/05/2018 12:20"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J12", "Sertão x Caxias", CustomDateUtils.getDateTimeFromString("17/05/2018 12:40"), "Futsal Feminino","Quadra 1","Chave C"))
        itens.add(Item("J13", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("17/05/2018 14:00"), "Futsal Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J14", "2º Chave A x 2º Chave C", CustomDateUtils.getDateTimeFromString("17/05/2018 14:20"), "Futsal Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J15", "1º Chave B x 1º Melhor 3º", CustomDateUtils.getDateTimeFromString("17/05/2018 14:40"), "Futsal Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J16", "1º Chave C x 2º Melhor 3º", CustomDateUtils.getDateTimeFromString("17/05/2018 15:00"), "Futsal Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J17", "Venc. Jogo 13 x Venc. Jogo 14", CustomDateUtils.getDateTimeFromString("17/05/2018 15:20"), "Futsal Feminino","Quadra 1","Semifinal"))
        itens.add(Item("J18", "Venc. Jogo 15 x Venc. Jogo 16", CustomDateUtils.getDateTimeFromString("17/05/2018 15:45"), "Futsal Feminino","Quadra 1","Semifinal"))
        itens.add(Item("J19", "Venc. Jogo 17 x Venc. Jogo 18", CustomDateUtils.getDateTimeFromString("17/05/2018 16:30"), "Futsal Feminino","Quadra 1","Final"))

        //Futsal Masculino
        itens.add(Item("J1", "Bento x Vacaria", CustomDateUtils.getDateTimeFromString("18/05/2018 13:00"), "Futsal Masculino","Quadra 1","Chave A"))
        itens.add(Item("J2", "Feliz x Viamão", CustomDateUtils.getDateTimeFromString("18/05/2018 13:20"), "Futsal Masculino","Quadra 1","Chave B"))
        itens.add(Item("J3", "Caxias x Rio Grande", CustomDateUtils.getDateTimeFromString("18/05/2018 13:40"), "Futsal Masculino","Quadra 1","Chave C"))
        itens.add(Item("J4", "Rolante x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 14:00"), "Futsal Masculino","Quadra 1","Chave D"))
        itens.add(Item("J5", "Osório x Restinga", CustomDateUtils.getDateTimeFromString("18/05/2018 14:20"), "Futsal Masculino","","Chave D"))
        itens.add(Item("J6", "Ibirubá x Bento", CustomDateUtils.getDateTimeFromString("18/05/2018 14:40"), "Futsal Masculino","Quadra 1","Chave A"))
        itens.add(Item("J7", "Alvorada x Feliz", CustomDateUtils.getDateTimeFromString("18/05/2018 15:00"), "Futsal Masculino","Quadra 1","Chave B"))
        itens.add(Item("J8", "Sertão x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 15:20"), "Futsal Masculino","Quadra 1","Chave B"))
        itens.add(Item("J9", "Osório x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 15:40"), "Futsal Masculino","Quadra 1","Chave C"))
        itens.add(Item("J10", "Farroupilha x Restinga", CustomDateUtils.getDateTimeFromString("18/05/2018 16:00"), "Futsal Masculino","Quadra 1","Chave C"))
        itens.add(Item("J11", "Vacaria x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 16:20"), "Futsal Masculino","Quadra 1","Chave A"))
        itens.add(Item("J12", "Viamão x Alvorada", CustomDateUtils.getDateTimeFromString("18/05/2018 16:40"), "Futsal Masculino","Quadra 1","Chave B"))

        itens.add(Item("J13", "Rio Grande x Sertão", CustomDateUtils.getDateTimeFromString("19/05/2018 14:00"), "Futsal Masculino","Quadra 1","Chave B"))
        itens.add(Item("J14", "Rolante x Restinga", CustomDateUtils.getDateTimeFromString("19/05/2018 14:20"), "Futsal Masculino","Quadra 1","Chave C"))
        itens.add(Item("J15", "Osório x Farroupilha", CustomDateUtils.getDateTimeFromString("19/05/2018 14:40"), "Futsal Masculino","Quadra 1","Chave C"))
        itens.add(Item("J16", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("19/05/2018 15:00"), "Futsal Masculino","Quadra 1","Quartas de Final"))
        itens.add(Item("J17", "2º Chave C x 2º Chave D", CustomDateUtils.getDateTimeFromString("19/05/2018 15:20"), "Futsal Masculino","Quadra 1","Quartas de Final"))
        itens.add(Item("J18", "1º Chave B x 2º Chave A", CustomDateUtils.getDateTimeFromString("19/05/2018 15:40"), "Futsal Masculino","Quadra 1","Quartas de Final"))
        itens.add(Item("J19", "1º Chave D x 2º Chave C", CustomDateUtils.getDateTimeFromString("19/05/2018 16:00"), "Futsal Masculino","Quadra 1","Quartas de Final"))
        itens.add(Item("J20", "Venc. Jogo 16 x Venc. Jogo 17", CustomDateUtils.getDateTimeFromString("19/05/2018 16:20"), "Futsal Masculino","Quadra 1","Semifinal"))
        itens.add(Item("J21", "Venc. Jogo 18 x Venc. Jogo 19", CustomDateUtils.getDateTimeFromString("19/05/2018 16:45"), "Futsal Masculino","Quadra 1","Semifinal"))
        itens.add(Item("J22", "Venc. Jogo 20 x Venc. Jogo 21", CustomDateUtils.getDateTimeFromString("19/05/2018 17:30"), "Futsal Masculino","Quadra 1","Final"))

        //Voleibol Feminino
        itens.add(Item("J1", "Farroupilha x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 17:30"), "Voleibol Feminino","Quadra 1","Chave A"))

        itens.add(Item("J2", "Viamão x Bento", CustomDateUtils.getDateTimeFromString("18/05/2018 08:00"), "Voleibol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J3", "Alvorada x Sertão", CustomDateUtils.getDateTimeFromString("18/05/2018 08:30"), "Voleibol Feminino","Quadra 2","Chave C"))
        itens.add(Item("J4", "Rolante x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 09:00"), "Voleibol Feminino","Quadra 2","Chave D"))
        itens.add(Item("J5", "Rio Grande x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 09:30"), "Voleibol Feminino","Quadra 2","Chave D"))
        itens.add(Item("J6", "Ibirubá x Viamão", CustomDateUtils.getDateTimeFromString("18/05/2018 10:00"), "Voleibol Feminino","Quadra 2","Chave A"))
        itens.add(Item("J7", "Canoas x Alvorada", CustomDateUtils.getDateTimeFromString("18/05/2018 10:30"), "Voleibol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J8", "Restinga x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 11:00"), "Voleibol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J9", "Feliz x Rio Grande", CustomDateUtils.getDateTimeFromString("18/05/2018 11:30"), "Voleibol Feminino","Quadra 2","Chave C"))
        itens.add(Item("J10", "Bento x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 12:00"), "Voleibol Feminino","Quadra 2","Chave C"))

        itens.add(Item("J11", "Sertão x Canoas", CustomDateUtils.getDateTimeFromString("18/05/2018 13:00"), "Voleibol Feminino","Quadra 2","Chave A"))
        itens.add(Item("J12", "Caxias x Restinga", CustomDateUtils.getDateTimeFromString("18/05/2018 13:30"), "Voleibol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J13", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("18/05/2018 14:00"), "Voleibol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J14", "1º Chave C x 2º Chave D", CustomDateUtils.getDateTimeFromString("18/05/2018 14:30"), "Voleibol Feminino","Quadra 2","Chave C"))
        itens.add(Item("J15", "1º Chave B x 2º Chave A", CustomDateUtils.getDateTimeFromString("18/05/2018 15:00"), "Voleibol Feminino","Quadra 2","Chave C"))
        itens.add(Item("J16", "1º Chave D x 2º Chave C", CustomDateUtils.getDateTimeFromString("18/05/2018 15:30"), "Voleibol Feminino","Quadra 2","Quartas de Final"))
        itens.add(Item("J17", "Venc. Jogo 13 x Venc. Jogo 14" , CustomDateUtils.getDateTimeFromString("18/05/2018 16:00"), "Voleibol Feminino","Quadra 2","Quartas de Final"))
        itens.add(Item("J18", "Venc. Jogo 15 x Venc. Jogo 16", CustomDateUtils.getDateTimeFromString("18/05/2018 16:30"), "Voleibol Feminino","Quadra 2","Quartas de Final"))
        itens.add(Item("J19", "Venc. Jogo 17 x Venc. Jogo 18", CustomDateUtils.getDateTimeFromString("18/05/2018 17:00"), "Voleibol Feminino","Quadra 2","Quartas de Final"))


        //Voleibol Masculino
        itens.add(Item("J1", "Farroupilha x Ibirubá", CustomDateUtils.getDateTimeFromString("17/05/2018 09:00"), "Voleibol Masculino","Quadra 2","Chave A"))
        itens.add(Item("J2", "Osório x Viamão", CustomDateUtils.getDateTimeFromString("17/05/2018 09:30"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J3", "Rio Grande x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 10:00"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J4", "Sertão x Rolante", CustomDateUtils.getDateTimeFromString("17/05/2018 10:30"), "Voleibol Masculino","Quadra 2","Chave C"))
        itens.add(Item("J5", "Alvorada x Canoas", CustomDateUtils.getDateTimeFromString("17/05/2018 11:00"), "Voleibol Masculino","","Chave C"))
        itens.add(Item("J6", "Restinga x Farroupilha", CustomDateUtils.getDateTimeFromString("17/05/2018 11:30"), "Voleibol Masculino","Quadra 2","Chave A"))
        itens.add(Item("J7", "Rio Grande x Osório", CustomDateUtils.getDateTimeFromString("17/05/2018 12:00"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J8", "Viamão x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 12:30"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J9", "Alvorada x Sertão", CustomDateUtils.getDateTimeFromString("17/05/2018 14:00"), "Voleibol Masculino","Quadra 2","Chave C"))
        itens.add(Item("J10", "Rolante x Canoas", CustomDateUtils.getDateTimeFromString("17/05/2018 14:30"), "Voleibol Masculino","Quadra 2","Chave C"))
        itens.add(Item("J11", "Ibirubá x Restinga", CustomDateUtils.getDateTimeFromString("17/05/2018 15:00"), "Voleibol Masculino","Quadra 2","Chave A"))
        itens.add(Item("J12", "Osório x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 15:30"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J13", "Viamão x Rio Grande", CustomDateUtils.getDateTimeFromString("17/05/2018 16:00"), "Voleibol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J14", "Sertão x Canoas", CustomDateUtils.getDateTimeFromString("17/05/2018 16:30"), "Voleibol Masculino","Quadra 2","Chave C"))
        itens.add(Item("J15", "Rolante x Alvorada", CustomDateUtils.getDateTimeFromString("17/05/2018 17:00"), "Voleibol Masculino","Quadra 2","Chave C"))

        itens.add(Item("J16", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("18/05/2018 18:00"), "Voleibol Masculino","Quadra 2","Quartas de Final"))
        itens.add(Item("J17", "2º Chave A x 2º Chave C", CustomDateUtils.getDateTimeFromString("18/05/2018 18:30"), "Voleibol Masculino","Quadra 2","Quartas de Final"))
        itens.add(Item("J18", "1º Chave B x 1º Melhor 3º", CustomDateUtils.getDateTimeFromString("18/05/2018 19:00"), "Voleibol Masculino","Quadra 2","Quartas de Final"))
        itens.add(Item("J19", "1º Chave C x 2º Melhor 3º", CustomDateUtils.getDateTimeFromString("18/05/2018 19:30"), "Voleibol Masculino","Quadra 2","Quartas de Final"))
        itens.add(Item("J20", "Venc. Jogo 16 x Venc. Jogo 17", CustomDateUtils.getDateTimeFromString("18/05/2018 20:00"), "Voleibol Masculino","Quadra 2","Semifinal"))
        itens.add(Item("J21", "Venc. Jogo 18 x Venc. Jogo 19", CustomDateUtils.getDateTimeFromString("18/05/2018 20:30"), "Voleibol Masculino","Quadra 2","Semifinal"))
        itens.add(Item("J22", "Venc. Jogo 20 x Venc. Jogo 21", CustomDateUtils.getDateTimeFromString("18/05/2018 21:00"), "Voleibol Masculino","Quadra 2","Final"))

        //Basquetebol Feminino
        itens.add(Item("J1", "Ibirubá x Farroupilha", CustomDateUtils.getDateTimeFromString("19/05/2018 14:00"), "Basquetebol Feminino","Quadra 2","Chave A"))
        itens.add(Item("J2", "Feliz x Osório", CustomDateUtils.getDateTimeFromString("19/05/2018 14:20"), "Basquetebol Feminino","Quadra 2","Chave B"))
        itens.add(Item("J3", "Feliz x Ibirubá", CustomDateUtils.getDateTimeFromString("19/05/2018 15:00"), "Basquetebol Feminino","Quadra 2","Chave C"))
        itens.add(Item("J4", "Osório x Farroupilha", CustomDateUtils.getDateTimeFromString("19/05/2018 15:20"), "Basquetebol Feminino","Quadra 2","Chave D"))
        itens.add(Item("J5", "Ibirubá x Osório", CustomDateUtils.getDateTimeFromString("19/05/2018 16:00"), "Basquetebol Feminino","Quadra 2","Chave D"))
        itens.add(Item("J6", "Farroupilha x Feliz", CustomDateUtils.getDateTimeFromString("19/05/2018 16:20"), "Basquetebol Feminino","Quadra 2","Chave A"))

        //Voleibol Masculino
        itens.add(Item("J1", "Bento x Ibirubá", CustomDateUtils.getDateTimeFromString("19/05/2018 08:00"), "Basquetebol Masculino","Quadra 2","Chave A"))
        itens.add(Item("J2", "Osório x Viamão", CustomDateUtils.getDateTimeFromString("19/05/2018 08:20"), "Basquetebol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J3", "Farroupilha x Bento", CustomDateUtils.getDateTimeFromString("19/05/2018 08:40"), "Basquetebol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J4", "Feliz x Osório", CustomDateUtils.getDateTimeFromString("19/05/2018 09:00"), "Basquetebol Masculino","Quadra 2","Chave C"))
        itens.add(Item("J5", "Ibirubá x Farroupilha", CustomDateUtils.getDateTimeFromString("19/05/2018 09:20"), "Basquetebol Masculino","","Chave C"))
        itens.add(Item("J6", "Viamão x Feliz", CustomDateUtils.getDateTimeFromString("19/05/2018 09:40"), "Basquetebol Masculino","Quadra 2","Chave A"))
        itens.add(Item("J7", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("19/05/2018 10:00"), "Basquetebol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J8", "1º Chave B x 2º Chave A", CustomDateUtils.getDateTimeFromString("19/05/2018 10:25"), "Basquetebol Masculino","Quadra 2","Chave B"))
        itens.add(Item("J9", "Venc. Jogo 7 x Venc. Jogo 8", CustomDateUtils.getDateTimeFromString("19/05/2018 10:50"), "Basquetebol Masculino","Quadra 2","Chave C"))

        //Handebol Feminino
        itens.add(Item("J1", "Feliz x Bento", CustomDateUtils.getDateTimeFromString("18/05/2018 18:00"), "Handebol Feminino","Quadra 1","Chave A"))
        itens.add(Item("J2", "Sertão x Viamão", CustomDateUtils.getDateTimeFromString("18/05/2018 18:20"), "Handebol Feminino","Quadra 1","Chave B"))
        itens.add(Item("J3", "Rolante x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 18:40"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J4", "Alvorada x Feliz", CustomDateUtils.getDateTimeFromString("18/05/2018 19:00"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J5", "Farroupilha x Sertão", CustomDateUtils.getDateTimeFromString("18/05/2018 19:20"), "Handebol Feminino","","Chave A"))
        itens.add(Item("J6", "Ibirubá x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 19:40"), "Handebol Feminino","Quadra 1","Chave B"))
        itens.add(Item("J7", "Bento x Alvorada", CustomDateUtils.getDateTimeFromString("18/05/2018 20:00"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J8", "Viamão x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 20:20"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J9", "Caxias x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 20:40"), "Handebol Feminino","Quadra 1","Chave A"))

        itens.add(Item("J10", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("19/05/2018 09:00"), "Handebol Feminino","Quadra 1","Chave B"))
        itens.add(Item("J11", "2º Chave A x 2º Chave C", CustomDateUtils.getDateTimeFromString("19/05/2018 09:20"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J12", "1º Chave B x 1º 1º Melhor 3º", CustomDateUtils.getDateTimeFromString("19/05/2018 09:40"), "Handebol Feminino","Quadra 1","Chave C"))
        itens.add(Item("J13", "1º Chave C x 1º 2º Melhor 3º", CustomDateUtils.getDateTimeFromString("19/05/2018 10:00"), "Handebol Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J14", "Venc. Jogo 10 x Venc. Jogo 11", CustomDateUtils.getDateTimeFromString("19/05/2018 10:20"), "Handebol Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J15", "Venc. Jogo 12 x Venc. Jogo 13", CustomDateUtils.getDateTimeFromString("19/05/2018 10:45"), "Handebol Feminino","Quadra 1","Quartas de Final"))
        itens.add(Item("J16", "Venc. Jogo 14 x Venc. Jogo 15", CustomDateUtils.getDateTimeFromString("19/05/2018 11:15"), "Handebol Feminino","Quadra 1","Quartas de Final"))

        //Handebol Masculino
         itens.add(Item("J1", "Sertão x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 08:00"), "Handebol Masculino","Quadra 1","Chave A"))
        itens.add(Item("J2", "Feliz x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 08:20"), "Handebol Masculino","Quadra 1","Chave B"))
        itens.add(Item("J3", "Caxias x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 08:40"), "Handebol Masculino","Quadra 1","Chave C"))
        itens.add(Item("J4", "Osório x Vacaria", CustomDateUtils.getDateTimeFromString("18/05/2018 09:00"), "Handebol Masculino","Quadra 1","Chave D"))
        itens.add(Item("J5", "Feliz x Sertão", CustomDateUtils.getDateTimeFromString("18/05/2018 09:20"), "Handebol Masculino","","Chave D"))
        itens.add(Item("J6", "Farroupilha x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 09:40"), "Handebol Masculino","Quadra 1","Chave A"))
        itens.add(Item("J7", "Osório x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 10:00"), "Handebol Masculino","Quadra 1","Chave B"))
        itens.add(Item("J8", "Vacaria x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 10:20"), "Handebol Masculino","Quadra 1","Chave B"))
        itens.add(Item("J9", "Sertão x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 10:40"), "Handebol Masculino","Quadra 1","Chave C"))
        itens.add(Item("J10", "Ibirubá x Feliz", CustomDateUtils.getDateTimeFromString("18/05/2018 11:00"), "Handebol Masculino","Quadra 1","Chave C"))
        itens.add(Item("J11", "Caxias x Vacaria", CustomDateUtils.getDateTimeFromString("18/05/2018 11:20"), "Handebol Masculino","Quadra 1","Chave A"))
        itens.add(Item("J12", "Rolante x Osório", CustomDateUtils.getDateTimeFromString("18/05/2018 11:40"), "Handebol Masculino","Quadra 1","Chave B"))

        itens.add(Item("J13", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("19/05/2018 11:40"), "Handebol Masculino","Quadra 1","Chave B"))
        itens.add(Item("J14", "1º Chave B x 2º Chave A", CustomDateUtils.getDateTimeFromString("19/05/2018 12:05"), "Handebol Masculino","Quadra 1","Chave C"))
        itens.add(Item("J15", "Venc. Jogo 13 x Venc. Jogo 14", CustomDateUtils.getDateTimeFromString("19/05/2018 12:35"), "Handebol Masculino","Quadra 1","Chave C"))

        //Vôlei Praia Feminino
        itens.add(Item("J1", "Rio Grande x Canoas", CustomDateUtils.getDateTimeFromString("17/05/2018 09:00"), "Vôlei Praia Feminino","Quadra Única","Chave A"))
        itens.add(Item("J2", "Osório x Rolante", CustomDateUtils.getDateTimeFromString("17/05/2018 09:25"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J3", "Sertão x Caxias", CustomDateUtils.getDateTimeFromString("17/05/2018 09:50"), "Vôlei Praia Feminino","Quadra Única","Chave C"))
        itens.add(Item("J4", "Feliz x Bento", CustomDateUtils.getDateTimeFromString("17/05/2018 10:15"), "Vôlei Praia Feminino","Quadra Única","Chave D"))
        itens.add(Item("J5", "Farroupilha x Ibirubá", CustomDateUtils.getDateTimeFromString("17/05/2018 10:40"), "Vôlei Praia Feminino","Quadra Única","Chave D"))
        itens.add(Item("J6", "Viamão x Rio Grande", CustomDateUtils.getDateTimeFromString("17/05/2018 11:05"), "Vôlei Praia Feminino","Quadra Única","Chave A"))
        itens.add(Item("J7", "Sertão x Osório", CustomDateUtils.getDateTimeFromString("17/05/2018 11:30"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J8", "Caxias x Rolante", CustomDateUtils.getDateTimeFromString("17/05/2018 11:55"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J9", "Farroupilha x Feliz", CustomDateUtils.getDateTimeFromString("17/05/2018 12:20"), "Vôlei Praia Feminino","Quadra Única","Chave C"))
        itens.add(Item("J10", "Ibirubá x Bento", CustomDateUtils.getDateTimeFromString("17/05/2018 12:45"), "Vôlei Praia Feminino","Quadra Única","Chave C"))

        itens.add(Item("J11", "Canoas x Viamão", CustomDateUtils.getDateTimeFromString("17/05/2018 14:00"), "Vôlei Praia Feminino","Quadra Única","Chave A"))
        itens.add(Item("J12", "Osório x Caxias", CustomDateUtils.getDateTimeFromString("17/05/2018 14:25"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J13", "Rolante x Sertão", CustomDateUtils.getDateTimeFromString("17/05/2018 14:50"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J14", "Feliz x Ibirubá", CustomDateUtils.getDateTimeFromString("17/05/2018 15:15"), "Vôlei Praia Feminino","Quadra Única","Chave C"))
        itens.add(Item("J15", "Bento x Farroupilha", CustomDateUtils.getDateTimeFromString("17/05/2018 15:40"), "Vôlei Praia Feminino","Quadra Única","Chave C"))
        itens.add(Item("J16", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("17/05/2018 16:05"), "Vôlei Praia Feminino","Quadra Única","Quartas de Final"))
        itens.add(Item("J17", "2º Chave A x 2º Chave C" , CustomDateUtils.getDateTimeFromString("17/05/2018 16:30"), "Vôlei Praia Feminino","Quadra Única","Quartas de Final"))
        itens.add(Item("J18", "1º Chave B x 1º Melhor 3º", CustomDateUtils.getDateTimeFromString("17/05/2018 16:55"), "Vôlei Praia Feminino","Quadra Única","Quartas de Final"))
        itens.add(Item("J19", "1º Chave C x 2º Melhor 3º", CustomDateUtils.getDateTimeFromString("17/05/2018 17:20"), "Vôlei Praia Feminino","Quadra Única","Quartas de Final"))

        itens.add(Item("J20", "Venc. Jogo 16 x Venc. Jogo 17", CustomDateUtils.getDateTimeFromString("19/05/2018 14:00"), "Vôlei Praia Feminino","Quadra Única","Chave B"))
        itens.add(Item("J21", "Venc. Jogo 18 x Venc. Jogo 19", CustomDateUtils.getDateTimeFromString("19/05/2018 14:25"), "Vôlei Praia Feminino","Quadra Única","Chave C"))
        itens.add(Item("J22", "Venc. Jogo 20 x Venc. Jogo 21", CustomDateUtils.getDateTimeFromString("19/05/2018 16:00"), "Vôlei Praia Feminino","Quadra Única","Chave D"))

        //Vôlei Praia Masculino
        itens.add(Item("J1", "Viamão x Feliz", CustomDateUtils.getDateTimeFromString("18/05/2018 08:00"), "Vôlei Praia Masculino","Quadra Única","Chave A"))
        itens.add(Item("J2", "Rolante x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 08:25"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J3", "Osório x Restinga", CustomDateUtils.getDateTimeFromString("18/05/2018 08:50"), "Vôlei Praia Masculino","Quadra Única","Chave C"))
        itens.add(Item("J4", "Sertão x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 09:15"), "Vôlei Praia Masculino","Quadra Única","Chave D"))
        itens.add(Item("J5", "Rio Grande x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 09:40"), "Vôlei Praia Masculino","Quadra Única","Chave D"))
        itens.add(Item("J6", "Canoas x Viamão", CustomDateUtils.getDateTimeFromString("18/05/2018 10:05"), "Vôlei Praia Masculino","Quadra Única","Chave A"))
        itens.add(Item("J7", "Osório x Rolante", CustomDateUtils.getDateTimeFromString("18/05/2018 10:30"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J8", "Restinga x Farroupilha", CustomDateUtils.getDateTimeFromString("18/05/2018 10:55"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J9", "Rio Grande x Sertão", CustomDateUtils.getDateTimeFromString("18/05/2018 11:20"), "Vôlei Praia Masculino","Quadra Única","Chave C"))
        itens.add(Item("J10", "Ibirubá x Caxias", CustomDateUtils.getDateTimeFromString("18/05/2018 11:45"), "Vôlei Praia Masculino","Quadra Única","Chave C"))

        itens.add(Item("J11", "Feliz x Canoas", CustomDateUtils.getDateTimeFromString("18/05/2018 14:00"), "Vôlei Praia Masculino","Quadra Única","Chave A"))
        itens.add(Item("J12", "Rolante x Restinga", CustomDateUtils.getDateTimeFromString("18/05/2018 14:25"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J13", "Farroupilha x Osório", CustomDateUtils.getDateTimeFromString("18/05/2018 14:50"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J14", "Sertão x Ibirubá", CustomDateUtils.getDateTimeFromString("18/05/2018 15:15"), "Vôlei Praia Masculino","Quadra Única","Chave C"))
        itens.add(Item("J15", "Caxias x Rio Grande", CustomDateUtils.getDateTimeFromString("18/05/2018 15:40"), "Vôlei Praia Masculino","Quadra Única","Chave C"))
        itens.add(Item("J16", "1º Chave A x 2º Chave B", CustomDateUtils.getDateTimeFromString("18/05/2018 16:05"), "Vôlei Praia Masculino","Quadra Única","Quartas de Final"))
        itens.add(Item("J17", "2º Chave A x 2º Chave C" , CustomDateUtils.getDateTimeFromString("18/05/2018 16:30"), "Vôlei Praia Masculino","Quadra Única","Quartas de Final"))
        itens.add(Item("J18", "1º Chave B x 1º Melhor 3º", CustomDateUtils.getDateTimeFromString("18/05/2018 16:55"), "Vôlei Praia Masculino","Quadra Única","Quartas de Final"))
        itens.add(Item("J19", "1º Chave C x 2º Melhor 3º", CustomDateUtils.getDateTimeFromString("18/05/2018 17:20"), "Vôlei Praia Masculino","Quadra Única","Quartas de Final"))

        itens.add(Item("J20", "Venc. Jogo 16 x Venc. Jogo 17", CustomDateUtils.getDateTimeFromString("19/05/2018 15:00"), "Vôlei Praia Masculino","Quadra Única","Chave B"))
        itens.add(Item("J21", "Venc. Jogo 18 x Venc. Jogo 19", CustomDateUtils.getDateTimeFromString("19/05/2018 15:25"), "Vôlei Praia Masculino","Quadra Única","Chave C"))
        itens.add(Item("J22", "Venc. Jogo 20 x Venc. Jogo 21", CustomDateUtils.getDateTimeFromString("19/05/2018 16:30"), "Vôlei Praia Masculino","Quadra Única","Chave D"))

        //Tênis de Mesa Masculino
        itens.add(Item("J01", "Início Tênis de Mesa Masc.", CustomDateUtils.getDateTimeFromString("17/05/2018 09:00"), "Tênis de Mesa Masculino","Mesa Única","Chave C"))
        itens.add(Item("J02", "Início Tênis de Mesa Masc.", CustomDateUtils.getDateTimeFromString("17/05/2018 14:00"), "Tênis de Mesa Masculino","Mesa Única","Chave D"))
        itens.add(Item("J03", "Início Tênis de Mesa Masc.", CustomDateUtils.getDateTimeFromString("18/05/2018 08:00"), "Tênis de Mesa Masculino","Mesa Única","Chave D"))
        itens.add(Item("J04", "Finais Tênis de Mesa Masc.", CustomDateUtils.getDateTimeFromString("19/05/2018 14:40"), "Tênis de Mesa Masculino","Mesa Única","Chave D"))

        //Tênis de Mesa Feminino
        itens.add(Item("J01", "Início Tênis de Mesa Fem.", CustomDateUtils.getDateTimeFromString("18/05/2018 18:00"), "Tênis de Mesa Feminino","Mesa Única","Chave C"))
        itens.add(Item("J02", "Início Tênis de Mesa Fem.", CustomDateUtils.getDateTimeFromString("19/05/2018 08:00"), "Tênis de Mesa Feminino","Mesa Única","Chave D"))
        itens.add(Item("J03", "Finais Tênis de Mesa Fem.", CustomDateUtils.getDateTimeFromString("19/05/2018 13:00"), "Tênis de Mesa Feminino","Mesa Única","Chave D"))





        val localization = Localization(-29.6843219,-51.1402698)
        var events = ArrayList<Event>()
        var event = Event("1","5º JOGOS DO IFRS",
                CustomDateUtils.getDateTimeFromString("17/05/2018 00:00"),
                CustomDateUtils.getDateTimeFromString("19/05/2018 23:00"),
                "Os 5o Jogos do IFRS têm por objetivo proporcionar momentos de integração e prática de esportes entre a comunidade acadêmica do IFRS. O(s) vencedor(es) da(s) modalidade(s) terão o direito de representar o IFRS na Fase Regional dos Jogos dos Institutos Federais, no ano de 2018.",
                "https://firebasestorage.googleapis.com/v0/b/tcc-ifrs.appspot.com/o/mapa.png?alt=media&token=48085389-d3fd-4b21-b896-4bd263ebbb13",
                "Sociedade Ginástica Novo Hamburgo - R. Castro Alves, 166 - Rio Branco, Novo Hamburgo - RS, 93310-270",
                localization,
                itens)

        /*itens.add(Item("J01", "Evento 1", CustomDateUtils.getDateTimeFromString("16/05/2018 12:30"), "teste","----","Chave D"))
        itens.add(Item("J02", "Evento 2", CustomDateUtils.getDateTimeFromString("16/05/2018 12:40"), "teste","----","Chave D"))
        itens.add(Item("J03", "Evento 3", CustomDateUtils.getDateTimeFromString("16/05/2018 13:30"), "teste","----","Chave D"))
        itens.add(Item("J04", "Evento 4", CustomDateUtils.getDateTimeFromString("16/05/2018 13:40"), "teste","----","Chave D"))
        itens.add(Item("J05", "Evento 5", CustomDateUtils.getDateTimeFromString("16/05/2018 14:30"), "teste","----","Chave D"))
        itens.add(Item("J06", "Evento 6", CustomDateUtils.getDateTimeFromString("16/05/2018 14:40"), "teste","----","Chave D"))
        itens.add(Item("J07", "Evento 7", CustomDateUtils.getDateTimeFromString("16/05/2018 15:30"), "teste","----","Chave D"))
        itens.add(Item("J08", "Evento 8", CustomDateUtils.getDateTimeFromString("16/05/2018 15:40"), "teste","----","Chave D"))
        itens.add(Item("J009", "Evento 9", CustomDateUtils.getDateTimeFromString("16/05/2018 16:30"), "teste","----","Chave D"))
        itens.add(Item("J10", "Evento 10", CustomDateUtils.getDateTimeFromString("16/05/2018 16:40"), "teste","----","Chave D"))
        itens.add(Item("J11", "Evento 11", CustomDateUtils.getDateTimeFromString("16/05/2018 17:30"), "teste","----","Chave D"))
        itens.add(Item("J12", "Evento 12", CustomDateUtils.getDateTimeFromString("16/05/2018 17:40"), "teste","----","Chave D"))*/



        //s.name + CustomDateUtils.getFormatedDate(s.date, "ddMMyyyyHHmm")
/*
        val localization = Localization(-29.6843219,-51.1402698)


        var events = ArrayList<Event>()
        var event = Event("1","Teste de pushing",
                CustomDateUtils.getDateTimeFromString("16/05/2018 00:00"),
                CustomDateUtils.getDateTimeFromString("16/05/2018 23:59"),
                "Teste de notificação no aplicativo",
                "https://i.pinimg.com/originals/6f/49/ac/6f49ac14c53e8e462c7c7dde207f2fc4.jpg",
                "web - somewhere",
                localization,
                itens)*/

        events.add(event)


        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("events")
        myRef.push().setValue(event)

        for (item in itens) createNotification(formateddate(item.date!!), item.name + " - " + item.speaker + " - " +  CustomDateUtils.getFormatedDate(item.date, "HH:mm"), item.name!! + CustomDateUtils.getFormatedDate(item.date, "ddMMyyyyHHmm"))


    }

    fun createNotification(time: String, text: String, tag: String){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://onesignal.com/api/v1/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        var included_segments = ArrayList<String>()
        included_segments.add("All")
        var notification = Notification("d74d5747-1648-4918-b00b-2a108cc9a7fc", Content(text), included_segments,  time , Data(tag))

        val service = retrofit.create(OnesignalService::class.java)
        val serviceCall = service.createNotification(notification)

        serviceCall.enqueue(object : Callback<NotificationResponse> {
            override fun onResponse(call: Call<NotificationResponse>?, response: Response<NotificationResponse>?) {
                Log.d("ninja","onResponse")
            }

            override fun onFailure(call: Call<NotificationResponse>?, t: Throwable?) {
                Log.d("ninja","onFailure")
            }
        })

    }

    fun formateddate(date: Date):String{
        var cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, -15)
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDateFormat.format(cal.time)+" GMT-0300"
    }


}