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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)

        setContentView(paymentPageBinding.root)

        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)

        val historyListAdapter = HistoryListAdapter()
        recylerViewLinks.adapter = historyListAdapter

        observeServerResponse()

        shorten_button.setOnClickListener{
            val textTo = input_edit_text.text.toString()
            Toast.makeText(this@HomeActivity, textTo, Toast.LENGTH_LONG).show()
            homeViewModel.getShortenedUrl(textTo)

        }

        homeViewModel.savedLinks.observe(this, {
            if(it.size != 0) {
                empty_links_page.visibility = View.GONE
                historyListAdapter.providelinkHistoryList(it.map { eachItem -> eachItem.toLinkUIModel() })
                recylerViewLinks.visibility = View.VISIBLE

            }
            else{

                empty_links_page.visibility = View.VISIBLE
                recylerViewLinks.visibility = View.GONE
            }
        })
        homeViewModel.isThereAnySavedLink.observeForever {
            Log.e("11111 saved link", it.toString())
            if(it) {
                empty_links_page.visibility = View.GONE
                historyListAdapter.providelinkHistoryList(homeViewModel.savedLinks.value?.map { eachItem -> eachItem.toLinkUIModel() })
                recylerViewLinks.visibility = View.VISIBLE
            }
        }


    }

    private fun observeServerResponse() {
        homeViewModel.serverShortenedUrl.observeForever  {

            if(it.data != null){
                Log.e("observe 78",  it.data.toString())

                input_edit_text.text.clear()
                showLinkHistory()

            }


        }
    }

    fun showLinkHistory(){
        val historyListAdapter = HistoryListAdapter()
        recylerViewLinks.adapter = historyListAdapter
        homeViewModel.checkIfThereAnySavedLinks()
        homeViewModel.savedLinks.observe(this, {
            it.forEach(){
                Log.e("observe 95 show Link", it.toString())
            }
            empty_links_page.visibility = View.GONE
            historyListAdapter.providelinkHistoryList(it.map { eachItem -> eachItem.toLinkUIModel() })
            recylerViewLinks.visibility = View.VISIBLE
//
        })
    }

}
