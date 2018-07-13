package mx.edu.cesctm.tools_store_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_company.*
import kotlinx.android.synthetic.main.app_bar_main.*

class CompanyActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, company_drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        company_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view_company.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (company_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            company_drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_logout -> finish()
        }
        company_drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
