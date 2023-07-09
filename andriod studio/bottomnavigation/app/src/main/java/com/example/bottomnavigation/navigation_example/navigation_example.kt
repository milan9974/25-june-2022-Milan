package com.example.bottomnavigation.navigation_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.R
import com.google.android.material.navigation.NavigationView

class navigation_example : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_example)

        var toolbar:Toolbar=findViewById(R.id.my_nev_toolbar)
        setSupportActionBar(toolbar)

        var drawerLayout: DrawerLayout = findViewById(R.id.main_drawer_layout)
        var nev_view: NavigationView = findViewById(R.id.nev_view)
        var navController= findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_nev_fragment3, R.id.profile_nev_fragment2, R.id.logout_nev_fragment2),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        nev_view.setupWithNavController(navController)


    }



    override fun onSupportNavigateUp(): Boolean {

        var navController=findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}