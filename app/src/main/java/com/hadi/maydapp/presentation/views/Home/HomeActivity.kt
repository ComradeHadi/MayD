package com.hadi.maydapp.presentation.views.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.hadi.maydapp.databinding.ActivityShortLinkIntroBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_short_link_intro.*
import java.util.regex.Pattern
//import kotlinx.android.synthetic.main.activity_main.teams_recycler_view_list
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    var EMPTY_STATE: Boolean = false
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var paymentPageBinding: ActivityShortLinkIntroBinding
    private lateinit var selectedCountry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)

        setContentView(paymentPageBinding.root)
        Log.e("crush", selectedCountry.toString())

        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)
        //homeViewModel.ch

        val historyListAdapter = HistoryListAdapter()
        recylerViewLinks.adapter = historyListAdapter

        observeServerResponse()

        shorten_button.setOnClickListener{
            val textTo = input_edit_text.text.toString()
            Toast.makeText(this@HomeActivity, textTo, Toast.LENGTH_LONG).show()
            homeViewModel.getShortenedUrl(textTo)
            showLinkHistory()
        }

        homeViewModel.savedLinks.observe(this, {
            if(it.size != 0) {
                Log.e("11111111 changes 1",  it.size.toString())
                empty_links_page.visibility = View.GONE
                historyListAdapter.providelinkHistoryList(it.map { eachItem -> eachItem.toLinkUIModel() })
                recylerViewLinks.visibility = View.VISIBLE

            }
            else{
                Log.e("11111111 test 2",  it.size.toString())

                empty_links_page.visibility = View.VISIBLE
                recylerViewLinks.visibility = View.GONE
            }
        })


    }

    private fun observeServerResponse() {
        homeViewModel.serverShortenedUrl.observe(this, {

            if(it.data != null){
                Log.e("11111111 data",  it.data.toString())
                /** All actions here
                 * */

                input_edit_text.text.clear()
                showLinkHistory()

            }


        })
    }

    fun showLinkHistory(){
        val historyListAdapter = HistoryListAdapter()
        recylerViewLinks.adapter = historyListAdapter
        homeViewModel.savedLinks.observe(this, {
            if(it.size != 0) {
                Log.e("11111111 test 1",  it.size.toString())
                empty_links_page.visibility = View.GONE
                historyListAdapter.providelinkHistoryList(it.map { eachItem -> eachItem.toLinkUIModel() })
                recylerViewLinks.visibility = View.VISIBLE

            }
            else{
                Log.e("11111111 test 2",  it.size.toString())

                empty_links_page.visibility = View.VISIBLE
                recylerViewLinks.visibility = View.GONE
                EMPTY_STATE = true
            }
        })
    }
}
