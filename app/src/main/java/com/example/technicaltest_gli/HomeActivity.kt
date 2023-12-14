package com.example.technicaltest_gli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var listRv : RecyclerView
    private lateinit var listArr : ArrayList<Data>
    lateinit var imageId: Array<Int>
    lateinit var nameId: Array<String>
    lateinit var addressId: Array<String>
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        imageId = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9,
            R.drawable.pic10
        )

        nameId = arrayOf(
            "Muhamad Bayu Nur Fiqri",
            "Muhamad Raja Saputra",
            "Icha Alifiya Putri",
            "Ilham Fikri",
            "Amelia Tuzahra",
            "Delta Sagara",
            "Fani Rahmadani",
            "Novilatul Laili",
            "Refli Aprian",
            "Wulan Ayu Septiana"
        )

        addressId = arrayOf(
            "Jl. Pemandangan Indah Utama Blok G No. 25, Sentul Timur",
            "Kompleks Villa Sejahtera Permai Kavling 17, Sentul Barat",
            "Perumahan Bumi Sentul Sejahtera Cluster Citra Indah No. 33",
            "Jl. Rancamaya Residence Blok M No. 12, Sentul Selatan",
            "Griya Harmoni Sentul City RT 05 RW 09, Jl. Pesona Alam",
            "Perkampungan Hijau Indah Blok C-2 No. 45, Sentul Utara",
            "Jl. Villa Kayu Manis Raya No. 28, Sentul Baru",
            "Cluster Puri Sentul Asri Blok D No. 7, Sentul Indah",
            "Taman Pesona Sentul Jaya Kavling 19, Sentul Timur",
            "Jl. Melati Sejahtera No. 8, Perumahan Bukit Sentul Permai",
        )

        listRv = findViewById(R.id.rvList)
        listRv.layoutManager = LinearLayoutManager(this)
        listRv.setHasFixedSize(true)

        progressBar = findViewById(R.id.progressBar)
        listArr = arrayListOf<Data>()
        progressBar.visibility = View.VISIBLE
        Handler().postDelayed({
            getData()
            // Hide ProgressBar after loading is complete
            progressBar.visibility = View.GONE
        }, 2500)
    }

    private fun getData(){

        for(i in imageId.indices){
            val data = Data(imageId[i], nameId[i], addressId[i])
            listArr.add(data)
        }

        listRv.adapter = MyAdapter(listArr)

    }
}