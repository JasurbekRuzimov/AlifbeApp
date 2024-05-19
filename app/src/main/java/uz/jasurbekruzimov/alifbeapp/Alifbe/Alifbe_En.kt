package uz.jasurbekruzimov.alifbeapp.Alifbe

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import uz.jasurbekruzimov.alifbeapp.R

@SuppressLint("StaticFieldLeak")

class Alifbe_En : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alifbe_en)
    }

    fun CallA(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_a)
        mp.start()
    }

    fun CallB(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_b)
        mp.start()
    }

    fun CallC(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_c)
        mp.start()
    }

    fun CallD(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_d)
        mp.start()
    }

    fun CallE(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_e)
        mp.start()
    }

    fun CallF(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_f)
        mp.start()
    }

    fun CallG(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_g)
        mp.start()
    }

    fun CallH(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_h)
        mp.start()
    }

    fun CallI(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_i)
        mp.start()
    }

    fun CallJ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_j)
        mp.start()
    }

    fun CallK(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_k)
        mp.start()
    }

    fun CallL(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_l)
        mp.start()
    }

    fun CallM(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_m)
        mp.start()
    }

    fun CallN(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_n)
        mp.start()
    }

    fun CallO(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_o)
        mp.start()
    }

    fun CallP(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_p)
        mp.start()
    }

    fun CallQ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_q)
        mp.start()
    }

    fun CallR(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_r)
        mp.start()
    }

    fun CallS(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_s)
        mp.start()
    }

    fun CallT(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_t)
        mp.start()
    }

    fun CallU(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_u)
        mp.start()
    }

    fun CallV(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_v)
        mp.start()
    }

    fun CallW(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_w)
        mp.start()
    }

    fun CallX(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_x)
        mp.start()
    }

    fun CallY(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_y)
        mp.start()
    }

    fun CallZ(view: View) {
        val mp = MediaPlayer.create(this, R.raw.english_letter_z)
        mp.start()
    }

    fun backHome(view: View) {
        finish()
    }
}
