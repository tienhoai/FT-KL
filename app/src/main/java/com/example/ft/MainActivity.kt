package com.example.ft

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeSetContentView()
        setContentView(R.layout.activity_main)
        afterSetContentView()
    }

    private fun beforeSetContentView() {
        hideStatusBar()
    }

    private fun afterSetContentView() {
        customActionBar()
        customNavigationView()
    }

    private fun hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun customActionBar() {
        setSupportActionBar(abm__ToolBar_actionbar)
        supportActionBar?.title = "F Tag"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            android.R.id.home -> {
                abm__DrawerLayout_content.openDrawer(GravityCompat.START)
            }

            R.id.search_item -> {

            }

            else -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun customNavigationView() {

        abm__NavigationView_menu.setNavigationItemSelectedListener { menuIem ->

            when(menuIem.itemId) {

                R.id.nav_home -> {
                    abm__DrawerLayout_content.closeDrawers()
                }

                R.id.nav_1 -> {
                    abm__DrawerLayout_content.closeDrawers()
                }

                R.id.nav_2 -> {
                    abm__DrawerLayout_content.closeDrawers()
                }

                else -> {

                }
            }

             true
        }

        abm__DrawerLayout_content.addDrawerListener(

            object : DrawerLayout.DrawerListener {

                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    //Log.e("DrawerListener", "Respond when the drawer's position changes")
                }

                override fun onDrawerOpened(drawerView: View) {
                    //Log.e("DrawerListener", "Respond when the drawer is opened")
                }

                override fun onDrawerClosed(drawerView: View) {
                    //Log.e("DrawerListener", "Respond when the drawer is closed")
                }

                override fun onDrawerStateChanged(newState: Int) {
                    //Log.e("DrawerListener", "Respond when the drawer motion state changes")
                }
            }
        )
    }

    private fun replaceFragmentContent(fragment: Fragment, title: String) {
        supportActionBar?.title = title
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.abm__FrameLayout_container, fragment)
        ft.addToBackStack(fragment.javaClass.simpleName)
        ft.commit()
    }
}
