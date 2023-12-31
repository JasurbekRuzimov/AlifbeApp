package uz.jasurbekruzimov.alifbeapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("StaticFieldLeak")

class HarfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harf)

    }

    fun CallA(view: View) {
        val mp = MediaPlayer.create(this, R.raw.a)
        mp.start()
    }

    fun CallB(view: View) {
        val mp = MediaPlayer.create(this, R.raw.b)
        mp.start()
    }

    fun CallC(view: View) {
        val mp = MediaPlayer.create(this, R.raw.c)
        mp.start()
    }

    fun CallD(view: View) {
        val mp = MediaPlayer.create(this, R.raw.d)
        mp.start()
    }

    fun CallE(view: View) {
        val mp = MediaPlayer.create(this, R.raw.e)
        mp.start()
    }

    fun CallF(view: View) {
        val mp = MediaPlayer.create(this, R.raw.f)
        mp.start()
    }

    fun CallG(view: View) {
        val mp = MediaPlayer.create(this, R.raw.g)
        mp.start()
    }

    fun CallH(view: View) {
        val mp = MediaPlayer.create(this, R.raw.h)
        mp.start()
    }

    fun CallI(view: View) {
        val mp = MediaPlayer.create(this, R.raw.i)
        mp.start()
    }

    fun CallJ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.j)
        mp.start()
    }

    fun CallK(view: View) {
        val mp = MediaPlayer.create(this, R.raw.k)
        mp.start()
    }

    fun CallL(view: View) {
        val mp = MediaPlayer.create(this, R.raw.l)
        mp.start()
    }

    fun CallM(view: View) {
        val mp = MediaPlayer.create(this, R.raw.m)
        mp.start()
    }

    fun CallN(view: View) {
        val mp = MediaPlayer.create(this, R.raw.n)
        mp.start()
    }

    fun CallO(view: View) {
        val mp = MediaPlayer.create(this, R.raw.o)
        mp.start()
    }

    fun CallP(view: View) {
        val mp = MediaPlayer.create(this, R.raw.p)
        mp.start()
    }

    fun CallQ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.q)
        mp.start()
    }

    fun CallR(view: View) {
        val mp = MediaPlayer.create(this, R.raw.r)
        mp.start()
    }

    fun CallS(view: View) {
        val mp = MediaPlayer.create(this, R.raw.s)
        mp.start()
    }

    fun CallT(view: View) {
        val mp = MediaPlayer.create(this, R.raw.t)
        mp.start()
    }

    fun CallU(view: View) {
        val mp = MediaPlayer.create(this, R.raw.u)
        mp.start()
    }

    fun CallV(view: View) {
        val mp = MediaPlayer.create(this, R.raw.v)
        mp.start()
    }

    fun CallW(view: View) {
        val mp = MediaPlayer.create(this, R.raw.w)
        mp.start()
    }

    fun CallX(view: View) {
        val mp = MediaPlayer.create(this, R.raw.x)
        mp.start()
    }

    fun CallY(view: View) {
        val mp = MediaPlayer.create(this, R.raw.y)
        mp.start()
    }

    fun CallZ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.z)
        mp.start()
    }
    // CallCH
//    fun CallCH(view: View) {
//        val mp = MediaPlayer.create(this, R.raw.ch)
//        mp.start()
//    }

    // CallGʻ

//    fun CallGʻ(view: View) {
//        val mp = MediaPlayer.create(this, R.raw.g)
//        mp.start()
//    }

    // CallOʻ

    fun CallOʻ(view: View) {
//        val mp = MediaPlayer.create(this, R.raw.o)
//        mp.start()
    }

    // CallSH

    fun CallSH(view: View) {
//        val mp = MediaPlayer.create(this, R.raw.sh)
//        mp.start()
    }

    // CallYO

    //    fun CallYO(view: View) {
//        val mp = MediaPlayer.create(this, R.raw.yo)
//        mp.start()
//    }
    fun CallTutuqBelgi(view: View) {

    }

    fun backHome(view: View) {
        finish()
    }
}
