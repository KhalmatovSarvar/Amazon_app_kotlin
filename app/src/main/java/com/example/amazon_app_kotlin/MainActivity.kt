package com.example.amazon_app_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon_app_kotlin.adapter.CamerasAdapter
import com.example.amazon_app_kotlin.adapter.EssentialAdapter
import com.example.amazon_app_kotlin.adapter.SneakersAdapter
import com.example.amazon_app_kotlin.model.Camera
import com.example.amazon_app_kotlin.model.Essential
import com.example.amazon_app_kotlin.model.Sneakers

class MainActivity : AppCompatActivity() {

    lateinit var rv_essential:RecyclerView
    lateinit var rv_sneakers:RecyclerView
    lateinit var rv_cameras:RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {


        rv_essential = findViewById(R.id.rv_essential)
        rv_sneakers = findViewById(R.id.rv_sneakers)
        rv_cameras = findViewById(R.id.rv_cameras)

        val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_essential.layoutManager = manager
        refreshAdapter(getEssentials())

        rv_sneakers.layoutManager = GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
        refreshAdapterSneakers(getSneakers())

        rv_cameras.layoutManager = GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
        refreshAdapterCameras(getCameras())

        var item_products = findViewById<LinearLayout>(R.id.item_products)
        var item_products_1 = findViewById<LinearLayout>(R.id.item_products_1)
        setLinearHeight(item_products)
        setLinearHeight(item_products_1)
    }

    private fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this,items)
        rv_essential!!.adapter = adapter
    }

    private fun refreshAdapterSneakers(items: ArrayList<Sneakers>) {
        val adapter = SneakersAdapter(this,items)
        rv_sneakers!!.adapter = adapter
    }

    private fun refreshAdapterCameras(items: ArrayList<Camera>) {
        val adapter = CamerasAdapter(this,items)
        rv_cameras!!.adapter = adapter
    }

    private fun setLinearHeight(layout: LinearLayout) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixels =displayMetrics.widthPixels

        val params:ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }

    private fun getSneakers(): ArrayList<Sneakers> {

        val sneakers:ArrayList<Sneakers> = ArrayList()
        sneakers.add(Sneakers(R.drawable.trainer_1))
        sneakers.add(Sneakers(R.drawable.trainer_2))
        sneakers.add(Sneakers(R.drawable.trainer_3))
        sneakers.add(Sneakers(R.drawable.trainer_4))

        return sneakers
    }

    private fun getCameras(): ArrayList<Camera> {

        val cameras:ArrayList<Camera> = ArrayList()
        cameras.add(Camera(R.drawable.camera_1))
        cameras.add(Camera(R.drawable.camera_2))
        cameras.add(Camera(R.drawable.camera_3))
        cameras.add(Camera(R.drawable.camera_4))

        return cameras
    }

    private fun getEssentials(): ArrayList<Essential> {

        val essentials:ArrayList<Essential> = ArrayList()
        essentials.add(Essential("Camera pro",R.drawable.camera_1))
        essentials.add(Essential("Camera plus",R.drawable.camera_2))
        essentials.add(Essential("Camera pro 7",R.drawable.camera_3))
        essentials.add(Essential("Camera proMax",R.drawable.camera_4))

        return essentials
    }
}