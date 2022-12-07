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
    private lateinit var PATTERN: Pattern
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var paymentPageBinding: ActivityShortLinkIntroBinding
    private var selectedCurrency: String? = null
    private lateinit var selectedCountry: String
    private var sendingAmount: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)

        setContentView(paymentPageBinding.root)
//        Log.e("crush", selectedCountry.toString())

        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)
        //homeViewModel.ch

        val historyListAdapter = HistoryListAdapter()
        recylerViewLinks.adapter = historyListAdapter

        observeServerResponse()
        showLinkHistory()

        shorten_button.setOnClickListener{
            val textTo = input_edit_text.text.toString()
            Toast.makeText(this@HomeActivity, textTo, Toast.LENGTH_LONG).show()
            homeViewModel.getShortenedUrl(textTo)
        }

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
            }
        })
    }
//
//    fun test() {
//        val n: Int = 75
//
//        val binary: String = Integer.toBinaryString(n)
//
//        println(binary)
//    }
//
//    // Function to check Binary Number
//    private fun isBinaryNumber(binaryNumber: Long): Boolean {
//        var binaryNumber = binaryNumber
//        while (binaryNumber > 0) {
//            if (binaryNumber % 10 > 1) {
//                return false
//            }
//            binaryNumber /= 10
//        }
//        return true
//    }
//
//    private fun convertBinaryToDecimal(num: Long): Long {
//        var num = num
//        var decimalNumber = 0L
//        var i = 0
//        var remainder: Long
//
//        while (num.toInt() != 0) {
//            remainder = num % 10
//            num /= 10
//            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
//            ++i
//        }
//        return decimalNumber
//    }
//
//    private fun getCurrency(country: String) = when (country) {
//        "Kenya" -> "KES"
//        "Nigeria" -> "NGN"
//        "Tanzania" -> "TZS"
//        "Uganda" -> "UGX"
//        else -> null
//
//    }
//
//    private fun getRateForCurrency(currency: String, remoteRates: LinkUIModel) = when (currency) {
//        "KES" -> remoteRates.kenyaRate
//        "NGN" -> remoteRates.nigeriaRate
//        "TZS" -> remoteRates.tanzaniaRate
//        "UGX" -> remoteRates.ugandaRate
//        else -> null
//
//    }
//
//    private fun calculateReceivingAmountInBinary(send: Long, rate: Double): String {
//        val amountInDecimals = send * rate
//        val binary = Integer.toBinaryString(amountInDecimals.toInt())
//
//        return binary.toString()
//    }
//
//    private fun isPhoneNumberValid(number: String): Boolean {
//
//
//        val expectedRegex = when (selectedCountry) {
//            "Kenya" -> "^(\\+254[\\-\\s]?)?\\d{9}\$"
//            "Nigeria" -> "^(\\+234[\\-\\s]?)?\\d{7}\$"
//            "Tanzania" -> "^(\\+255[\\-\\s]?)?\\d{9}\$"
//            "Uganda" -> "^(\\+256[\\-\\s]?)?\\d{9}\$"
//            else -> null
//        }
//
//        PATTERN = Pattern.compile(expectedRegex)
//        val finalBoolean = number.isPhoneNumber()
//
//
//
//        return finalBoolean
//
//    }
//
//    fun CharSequence.isPhoneNumber(): Boolean = PATTERN.matcher(this).find()
}
