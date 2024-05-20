package com.zaar.meatkgb2_m.view.activity.reports

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zaar.meatkgb2_m.R
import com.zaar.meatkgb2_m.databinding.ActivityShopReportsBinding
import com.zaar.meatkgb2_m.view.adapters.report.ProdCertViewPagerAdapter

class ProductionCertificatesActivity : AppCompatActivity() {
    private var _binding: ActivityShopReportsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProdCertViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabNames: Array<String> by lazy { resources.getStringArray(R.array.arrShopReports) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShopReportsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.shopReportTitle.text = "VSD"

        adapter = ProdCertViewPagerAdapter(this)
        viewPager = binding.viewPagerShopReports
        viewPager.adapter = adapter
        tabLayout = binding.tabLayoutShopReports
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}