package com.thegrafico.raul.evertectest

import com.thegrafico.raul.evertectest.Modals.ResponseWalletTransaction

interface CompleteListener {

    fun downloadCompleted(result: String, response: ResponseWalletTransaction?)

}