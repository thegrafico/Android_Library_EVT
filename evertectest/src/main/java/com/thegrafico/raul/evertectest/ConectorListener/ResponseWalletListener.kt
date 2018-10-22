package com.thegrafico.raul.evertectest.ConectorListener

import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction

interface ResponseWalletListener {

    fun downloadCompleted(result: String, response: ResponseWalletTransaction?)
}