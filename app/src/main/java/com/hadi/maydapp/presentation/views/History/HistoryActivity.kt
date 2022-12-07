package com.hadi.maydapp.presentation.views.Home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hadi.maydapp.databinding.ActivityShortLinkIntroBinding
import dagger.android.support.DaggerAppCompatActivity
import java.util.regex.Pattern
//import kotlinx.android.synthetic.main.activity_main.teams_recycler_view_list
import javax.inject.Inject

class HistoryActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var PATTERN: Pattern
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var paymentPageBinding: ActivityShortLinkIntroBinding
    private var selectedCurrency: String? = null
    private var selectedCountry: String? = null
    private var sendingAmount: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)

        setContentView(paymentPageBinding.root)

        paymentPageBinding = ActivityShortLinkIntroBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)

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
