package uz.jasurbekruzimov.alifbeapp.Alifbe

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import uz.jasurbekruzimov.alifbeapp.R

@SuppressLint("StaticFieldLeak")

class Alifbe_Ru : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alifbe_ru)

    }
// russian alphabet
    fun CallA(view: View) {
        val mp = MediaPlayer.create(this, R.raw.a_r)
        mp.start()
    }

    fun CallB(view: View) {
        val mp = MediaPlayer.create(this, R.raw.b_r)
        mp.start()
    }

    fun CallV(view: View) {
        val mp = MediaPlayer.create(this, R.raw.v_r)
        mp.start()
    }

    fun CallG(view: View) {
        val mp = MediaPlayer.create(this, R.raw.g_r)
        mp.start()
    }

    fun CallD(view: View) {
        val mp = MediaPlayer.create(this, R.raw.d_r)
        mp.start()
    }

    fun CallE(view: View) {
        val mp = MediaPlayer.create(this, R.raw.e_r)
        mp.start()
    }

    fun CallYo(view: View) {
        val mp = MediaPlayer.create(this, R.raw.yo2_r)
        mp.start()
    }

    fun CallJ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.j_r)
        mp.start()
    }

    fun CallZ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.z_r)
        mp.start()
    }

    fun CallI(view: View) {
        val mp = MediaPlayer.create(this, R.raw.i_r)
        mp.start()
    }

    fun CallK(view: View) {
        val mp = MediaPlayer.create(this, R.raw.k_r)
        mp.start()
    }

    fun CallL(view: View) {
        val mp = MediaPlayer.create(this, R.raw.l_r)
        mp.start()
    }

    fun CallM(view: View) {
        val mp = MediaPlayer.create(this, R.raw.m_r)
        mp.start()
    }

    fun CallN(view: View) {
        val mp = MediaPlayer.create(this, R.raw.n_r)
        mp.start()
    }

    fun CallO(view: View) {
        val mp = MediaPlayer.create(this, R.raw.o_r)
        mp.start()
    }

    fun CallP(view: View) {
        val mp = MediaPlayer.create(this, R.raw.p_r)
        mp.start()
    }

    fun CallR(view: View) {
        val mp = MediaPlayer.create(this, R.raw.r_r)
        mp.start()
    }

    fun CallS(view: View) {
        val mp = MediaPlayer.create(this, R.raw.c_r)
        mp.start()
    }

    fun CallT(view: View) {
        val mp = MediaPlayer.create(this, R.raw.t_r)
        mp.start()
    }

    fun CallU(view: View) {
        val mp = MediaPlayer.create(this, R.raw.u_r)
        mp.start()
    }

    fun CallF(view: View) {
        val mp = MediaPlayer.create(this, R.raw.f_r)
        mp.start()
    }

    fun CallX(view: View) {
        val mp = MediaPlayer.create(this, R.raw.x_r)
        mp.start()
    }

    fun CallTSe(view: View) {
        val mp = MediaPlayer.create(this, R.raw.ts_r)
        mp.start()
    }

    fun CallCh(view: View) {
        val mp = MediaPlayer.create(this, R.raw.ch_r)
        mp.start()
    }

    fun CallSh(view: View) {
        val mp = MediaPlayer.create(this, R.raw.sh_r)
        mp.start()
    }

    fun CallShA(view: View) {
        val mp = MediaPlayer.create(this, R.raw.sha_r)
        mp.start()
    }

    fun CallY(view: View) {
        val mp = MediaPlayer.create(this, R.raw.y_r)
        mp.start()
    }

    fun CallEe(view: View) {
        val mp = MediaPlayer.create(this, R.raw.iy_r)
        mp.start()
    }

    fun CallYu(view: View) {
        val mp = MediaPlayer.create(this, R.raw.yu_r)
        mp.start()
    }

    fun CallYa(view: View) {
        val mp = MediaPlayer.create(this, R.raw.ya_r)
        mp.start()
    }



    fun backHome(view: View) {
        finish()
    }
}
