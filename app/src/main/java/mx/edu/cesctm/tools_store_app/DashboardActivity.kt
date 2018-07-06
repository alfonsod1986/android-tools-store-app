package mx.edu.cesctm.tools_store_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*
import mx.edu.cesctm.tools_store_app.adapters.DashboardMenuItemAdapter
import mx.edu.cesctm.tools_store_app.logic.DashboarMenuItem

class DashboardActivity : AppCompatActivity() {
    var adapter: DashboardMenuItemAdapter? = null
    var dashboarMenuItemList = ArrayList<DashboarMenuItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setupDashboardMenu()
    }

    /**
     * Método para configurar el GridView Menu
     */
    private fun setupDashboardMenu(): Unit{
        // Cargando el menú
        dashboarMenuItemList.add(DashboarMenuItem(getString(R.string.grid_view_item_companies_txt), R.drawable.ic_companies))
        dashboarMenuItemList.add(DashboarMenuItem(getString(R.string.grid_view_item_customers_txt), R.drawable.ic_customers))
        dashboarMenuItemList.add(DashboarMenuItem(getString(R.string.grid_view_item_products_txt), R.drawable.ic_products))
        dashboarMenuItemList.add(DashboarMenuItem(getString(R.string.grid_view_item_sales_txt), R.drawable.ic_sales))
        dashboarMenuItemList.add(DashboarMenuItem(getString(R.string.grid_view_item_reports_txt), R.drawable.ic_reports))

        adapter = DashboardMenuItemAdapter(this@DashboardActivity, dashboarMenuItemList)

        dashboard_gv_menu.adapter = adapter
    }
}
